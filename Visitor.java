import java.util.Locale;
import java.util.Objects;

public class Visitor extends calcBaseVisitor<Void>{
    public String results="";
    public int Num=1;
//    public int bnum=1;
//    public int rank=1;
//    public int t=1;
    public boolean flagif=true;
    public boolean isconst=false;
    public int Tleft=0;
    public int Tright=0;
    public int Tmid=0;
    static Integer getnumber(String s){
        int res = 0;
        s = s.toLowerCase(Locale.ROOT);
        if (s.charAt(0)=='0'){
            if(s.length()==1){
                return 0;
            }
            if(s.charAt(1)=='x'||s.charAt(1)=='X'){
                int len = s.length();
                s = s.toLowerCase();
                for (int i=2;i<len;i++){
                    if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                        res=16*res+ (int) s.charAt(i)-48;
                    }
                    else if(s.charAt(i)>='a'&&s.charAt(i)<='f'){
                        res=16*res +10+ ((int) s.charAt(i)-'a');
                    }
                    else {
                        return res;
                    }
                }
                return res;
            }
            else {
                int len = s.length();
                for(int i=1;i<len;i++){
                    res=8*res+ (int) s.charAt(i)-48;
                }
                return res;
            }
        }
        else if(s.charAt(0)<'0'||s.charAt(0)>'9'){
            return null;
        }
        else {
            return Integer.valueOf(s);
        }
    }
    @Override public Void visitCompUnit(calcParser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }
    @Override public Void visitFuncDef(calcParser.FuncDefContext ctx) {
        if(ctx.FuncType().getText().equals("int")){
            results+="define dso_local ";
        }
        if(ctx.Ident().getText().equals("main")){
            results+="i32 @main";
        }
        results+="()";
        results+="{\n";
        visit(ctx.block());
        results+="}";
        return null;
    }
    @Override public Void visitBlock(calcParser.BlockContext ctx) {
        for(int i=0;i<ctx.blockItem().size();i++){
            visit(ctx.blockItem(i));
        }
        return null;
    }
    @Override public Void visitStmt(calcParser.StmtContext ctx) {
        if(ctx.lval()!=null){
            String a=visitLval(ctx.lval());
            String s=visitExp(ctx.exp());
            VarList list=VarList.getInstance();
            if(list.getVar(ctx.lval().getText()).isIsconst()&&list.getVar(ctx.lval().getText()).isInit()){
                System.exit(-1);
            }
            list.getVar(ctx.lval().getText()).setInit(true);
            results+="store i32 "+s+", i32* "+ list.getVar(ctx.lval().getText()).getNum()+"\n";
        }
        else if(ctx.block()!=null){
            visit(ctx.block());
        }
        else if(ctx.getText().startsWith("if")){
            if(ctx.stmt().size()>1){
                Tleft=Tmid+1;
                Tright=Tmid+2;
                if(flagif){
                    Tmid+=3;
                }
            }
            else {
                Tleft=Tmid+1;
                Tright=Tmid+2;
                if(flagif){
                    Tmid+=2;
                }
            }
            boolean thi=false;
            if(flagif==true){
                thi=true;
                flagif=false;
            }
            visit(ctx.cond());
            if(Reglist.getInstance().getreg("%"+(Num-1)).getType().equals("i32")){
                results+="%"+Num+" = icmp ne "+Reglist.getInstance().getreg("%"+(Num-1)).getType() +" %" + (Num-1) + ", 0"+ "\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
            }
            if(ctx.stmt().size()==2){
                results+="br i1 %"+(Num-1)+", label %t"+Tleft+", label %t"+Tright+"\n";
            }
            else {
                results+="br i1 %"+(Num-1)+", label %t"+Tleft+", label %t"+Tmid+"\n";
            }
            results+="t"+Tleft+":\n";
            visit(ctx.stmt(0));
            results+="br label %t"+Tmid+"\n";
//            if(!results.endsWith(":\n")&&!results.endsWith("br label %b"+rank+"\n")){
//                results+="br label %b"+rank+"\n";
//            }
            if(ctx.stmt().size()>=2){
//                results+="b"+t+":\n";
//                t++;
//                if(t==rank){
//                    t++;
//                }
                results+="t"+Tright+":\n";
                visit(ctx.stmt(1));
                results+="br label %t"+Tmid+"\n";
//                if(!results.endsWith(":\n")&&!results.endsWith("br label %b"+rank+"\n")){
//                    results+="br label %b"+rank+"\n";
//                }
            }
            if(thi){
                results+="t"+Tmid+":\n";
                flagif=true;
            }
//            if(!results.endsWith(":\n")&& thi){
//                results += "b"+rank+":\n";
//                rank=1;
//                bnum++;
//                flagif=true;
//            }

//            results+="b"+rank+":\n";
        }
        else if(ctx.getText().startsWith("return")){

            String s=visitExp(ctx.exp());
            results+="ret i32 "+s+"\n";
            Num++;
        }
        else {
            if(ctx.exp()!=null){
                visit(ctx.exp());
            }
        }
        return null;
    }

    @Override
    public String visitExp(calcParser.ExpContext ctx) {
        return visitAddexp(ctx.addexp());
    }

    @Override
    public String visitAddexp(calcParser.AddexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitMulexp(ctx.mulexp());
            case 3:
                String left=visitAddexp(ctx.addexp());
                String right=visitMulexp(ctx.mulexp());
                if(Objects.equals(ctx.Addfunc().getText(), "+")){
                    if(left.startsWith("%")&&Reglist.getInstance().getreg(left).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        left = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    if(right.startsWith("%")&&Reglist.getInstance().getreg(right).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = add i32 "+left+","+right+"\n";
//                    System.out.println("%"+Num+" = add i32 "+left+","+right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(Objects.equals(ctx.Addfunc().getText(), "-")){
                    if(left.startsWith("%")&&Reglist.getInstance().getreg(left).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        left = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    if(right.startsWith("%")&&Reglist.getInstance().getreg(right).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = sub i32 "+left+","+right+"\n";
//                    System.out.println("%"+Num+" = sub i32 "+left+","+right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }

                break;
        }
        return null;
    }

    @Override
    public String visitMulexp(calcParser.MulexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitUnaryexp(ctx.unaryexp());
            case 3:
                String left=visitMulexp(ctx.mulexp());
                String right=visitUnaryexp(ctx.unaryexp());
                if(ctx.Mulfunc().getText().equals("*")){
                    if(left.startsWith("%")&&Reglist.getInstance().getreg(left).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        left = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    if(right.startsWith("%")&&Reglist.getInstance().getreg(right).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = mul i32 "+left+","+right+"\n";
//                    System.out.println("%"+Num+" = mul i32 "+left+","+right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Mulfunc().getText().equals("/")) {
                    if(left.startsWith("%")&&Reglist.getInstance().getreg(left).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        left = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    if(right.startsWith("%")&&Reglist.getInstance().getreg(right).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%" + Num + " = sdiv i32 " + left + "," + right+"\n";
//                    System.out.println("%" + Num + " = sdiv i32 " + left + "," + right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%" + (Num - 1);
                }
                else if(ctx.Mulfunc().getText().equals("%")) {
                    if(left.startsWith("%")&&Reglist.getInstance().getreg(left).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        left = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    if(right.startsWith("%")&&Reglist.getInstance().getreg(right).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%" + Num + " = srem i32 " + left + "," + right+"\n";
//                    System.out.println("%" + Num + " = srem i32 " + left + "," + right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%" + (Num - 1);
                }
                break;
        }
        return null;
    }

    @Override
    public String visitUnaryexp(calcParser.UnaryexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                return visitPrimaryexp(ctx.primaryexp());
            case 2:
                String right=visitUnaryexp(ctx.unaryexp());
                if(ctx.Addfunc().getText().equals("+")){
                    if(Reglist.getInstance().getreg("%"+(Num-1)).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = add i32 0, "+right+"\n";
//                    System.out.println("%"+Num+" = add i32 0, "+right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Addfunc().getText().equals("-")){
                    if(Reglist.getInstance().getreg("%"+(Num-1)).getType().equals("i1")){
                        results+="%"+Num+" = "+"zext i1 %"+(Num-1)+" to i32\n";
                        Register reg = new Register();
                        right = "%"+Num;
                        reg.setName("%"+Num);
                        reg.setNum(Num);
                        reg.setType("i32");
                        Reglist.getInstance().add(reg);
                        Num++;
                    }
                    results+="%"+Num+" = sub i32 0, "+right+"\n";
//                    System.out.println("%"+Num+" = sub i32 0, "+right);
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(ctx.Addfunc().getText().equals("!")){
                    results+="%"+Num+" = icmp eq "+Reglist.getInstance().getreg("%"+(Num-1)).getType() +" %" + (Num-1) + ", 0"+ "\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i1");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
            default:
                String s = ctx.Idigit().getText();
                if(s.equals("getint")){
                    results+="%"+Num+" = call i32 @getint()\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(s.equals("putint")){
                    String tt=visitFuncrParams(ctx.funcrParams());
                    results+="call void @putint(i32 "+tt+")\n";
                    return null;
                }
                else if(s.equals("getch")){
                    results+="%"+Num+" = call i32 @getch()\n";
                    Register reg = new Register();
                    reg.setName("%"+Num);
                    reg.setNum(Num);
                    reg.setType("i32");
                    Reglist.getInstance().add(reg);
                    Num++;
                    return "%"+(Num-1);
                }
                else if(s.equals("putch")){
                    String tt=visitFuncrParams(ctx.funcrParams());
                    results+="call void @putch(i32 "+tt+")\n";
                    return null;
                }
        }
        return null;
    }

    @Override
    public String visitPrimaryexp(calcParser.PrimaryexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                if(ctx.Number()!=null){
                    String s = ctx.Number().getText();
                    int temp=getnumber(s);
                    return String.valueOf(temp);
                }
                else {
                    String a=visitLval(ctx.lval());
                    Var var=VarList.getInstance().getVar(ctx.lval().getText());
                    return a;
//                    return var.getNum();
                }
            case 3:
                return visitExp(ctx.exp());
        }
        return null;
    }

    @Override
    public Void visitDecl(calcParser.DeclContext ctx) {
        if(ctx.constDecl()!=null){
            isconst=true;
            visit(ctx.constDecl());
            isconst=false;
        }
        else {
            visit(ctx.varDecl());
        }
        return null;
    }

    @Override
    public Void visitConstDecl(calcParser.ConstDeclContext ctx) {
        for(int i=0;i<ctx.constDef().size();i++){
            visit(ctx.constDef(i));
        }
        return null;
    }

    @Override
    public Void visitConstDef(calcParser.ConstDefContext ctx) {
        results+="%"+Num+" = alloca i32\n";
        String ident=ctx.Idigit().getText();
        if(VarList.getInstance().getVar(ident)!=null){
            System.exit(-1);
        }
        Var var=new Var();
        var.setName(ident);
        var.setNum("%"+Num);
        var.setInit(true);
        var.setIsconst(true);
        VarList list=VarList.getInstance();
        list.add(var);
        Register reg = new Register();
        reg.setName("%"+Num);
        reg.setNum(Num);
        reg.setType("i32");
        Reglist.getInstance().add(reg);
        Num++;
        String temp=visitConstInitVal(ctx.constInitVal());
        String loc=list.getVar(ctx.Idigit().getText()).getNum();
        results+="store i32 "+temp+", i32* " +loc+"\n";
        return null;
    }

    @Override
    public String visitConstInitVal(calcParser.ConstInitValContext ctx) {
        return visitConstExp(ctx.constExp());
    }

    @Override
    public String visitConstExp(calcParser.ConstExpContext ctx) {
        return visitAddexp(ctx.addexp());
    }

    @Override
    public Void visitVarDecl(calcParser.VarDeclContext ctx) {
        for(int i=0;i<ctx.varDef().size();i++){
            visit(ctx.varDef(i));
        }
        return null;
    }

    @Override
    public Void visitVarDef(calcParser.VarDefContext ctx) {
        switch (ctx.children.size()){
            case 1:
                results+="%"+Num+" = alloca i32\n";
                String ident=ctx.Idigit().getText();
                if(VarList.getInstance().getVar(ident)!=null){
                    System.exit(-1);
                }
                Var var=new Var();
                var.setName(ident);
                var.setNum("%"+Num);
                var.setIsconst(false);
                var.setInit(false);
                VarList list=VarList.getInstance();
                list.add(var);
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i32");
                Reglist.getInstance().add(reg);
                Num++;
                break;
            case 3:
                results+="%"+Num+" = alloca i32\n";
                ident=ctx.Idigit().getText();
                if(VarList.getInstance().getVar(ident)!=null){
                    System.exit(-1);
                }
                var=new Var();
                var.setName(ident);
                var.setNum("%"+Num);
                var.setInit(true);
                var.setIsconst(false);
                list=VarList.getInstance();
                list.add(var);
                Register reg2 = new Register();
                reg2.setName("%"+Num);
                reg2.setNum(Num);
                reg2.setType("i32");
                Reglist.getInstance().add(reg2);
                Num++;
                String temp=visitInitVal(ctx.initVal());
                String loc=list.getVar(ctx.Idigit().getText()).getNum();
                results+="store i32 "+temp+", i32* " +loc+"\n";
//                System.out.println("temp="+temp);
                break;
        }
        return null;
    }

    @Override
    public String visitInitVal(calcParser.InitValContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public Void visitBlockItem(calcParser.BlockItemContext ctx) {
        if(ctx.decl()!=null){
            visit(ctx.decl());
        }
        else {
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public String visitLval(calcParser.LvalContext ctx) {
        Var var=VarList.getInstance().getVar(ctx.getText());
        if(!var.isIsconst()&&isconst){
            System.exit(-1);
        }
        if(var.isInit()){
            results+="%"+Num+" = load i32, i32* "+var.getNum()+"\n";
            Register reg = new Register();
            reg.setName("%"+Num);
            reg.setNum(Num);
            reg.setType("i32");
            Reglist.getInstance().add(reg);
            Num++;
        }
        return "%"+(Num-1);
    }

    @Override
    public String visitFuncrParams(calcParser.FuncrParamsContext ctx) {
        String s = "";
        for(int i=0;i<ctx.exp().size();i++){
            s+=visitExp(ctx.exp(i));
        }
        return s;
    }

    @Override
    public Void visitCond(calcParser.CondContext ctx) {
        visit(ctx.lorexp());
        return null;
    }

    @Override
    public String visitLorexp(calcParser.LorexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s =visitLandexp(ctx.landexp());
                return s;
            case 3:
                String s1 = visitLorexp(ctx.lorexp());
                String s2 = visitLandexp(ctx.landexp());
//                System.out.println("left:"+s1);
//                System.out.println("right:"+s2);
                results+="%"+Num+" = or i1 "+s1+","+s2+"\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }

    @Override
    public String visitLandexp(calcParser.LandexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s = visitEqexp(ctx.eqexp());
//                System.out.println(s);
                return s;
            case 3:
                String s1 =visitLandexp(ctx.landexp());
                String s2 =visitEqexp(ctx.eqexp());
//                System.out.println("left:"+s1);
//                System.out.println("right:"+s2);
                results+="%"+Num+" = and i1 "+s1+","+s2+"\n";
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }

    @Override
    public String visitEqexp(calcParser.EqexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s = visitRelexp(ctx.relexp());
//                System.out.println(s);
                return s;
            case 3:
                String t1 = visitEqexp(ctx.eqexp());
                String t2 = visitRelexp(ctx.relexp());
                if(ctx.Judgefunc().getText().equals("==")){
                    results+="%"+Num+" = icmp eq i32 " + t1 + ", "+ t2 + "\n";
//                    flagif=true;
                }
                else {
                    results+="%"+Num+" = icmp ne i32 " + t1 + ", "+ t2 + "\n";
//                    flagif=true;
                }
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
//                results+="br i1 %"+Num+", label %b"+bnum+", label %b"+(bnum+1)+"\n";
//                bnum+=2;
////                rank=bnum;
//                Num++;
        }
        return null;
    }

    @Override
    public String visitRelexp(calcParser.RelexpContext ctx) {
        switch (ctx.children.size()){
            case 1:
                String s = visitAddexp(ctx.addexp());
//                System.out.println("rel:1.visitadd"+s);
                return s;
            case 3:
                String s1 = visitRelexp(ctx.relexp());
                String s2 = visitAddexp(ctx.addexp());
                if(ctx.Comfunc().getText().equals("<=")){
                    results+="%"+Num+" = icmp sle i32 " + s1 + ", "+ s2 + "\n";
//                    flagif=true;
                }
                else if(ctx.Comfunc().getText().equals(">=")){
                    results+="%"+Num+" = icmp sge i32 " + s1 + ", "+ s2 + "\n";
//                    flagif=true;
                }
                else if(ctx.Comfunc().getText().equals("<")){
                    results+="%"+Num+" = icmp slt i32 " + s1 + ", "+ s2 + "\n";
//                    flagif=true;
                }
                else if(ctx.Comfunc().getText().equals(">")){
                    results+="%"+Num+" = icmp sgt i32 " + s1 + ", "+ s2 + "\n";
//                    flagif=true;
                }
//                results+="br i1 %"+Num+", label %b"+bnum+", label %b"+(bnum+1)+"\n";
//                bnum+=2;
////                rank=bnum;
//                Num++;
                Register reg = new Register();
                reg.setName("%"+Num);
                reg.setNum(Num);
                reg.setType("i1");
                Reglist.getInstance().add(reg);
                Num++;
                return "%"+(Num-1);
        }
        return null;
    }
}
