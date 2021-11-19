// Generated from .\calc.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, FuncType=12, Ident=13, Orfunc=14, Andfunc=15, Comfunc=16, 
		Judgefunc=17, Idigit=18, Nondigit=19, Addfunc=20, Mulfunc=21, Number=22, 
		Decimalconst=23, Octalconst=24, Hexadecimalconst=25, Hexadecimalprefix=26, 
		Nonzerodigit=27, Octaldigit=28, Digit=29, Hexadecimaldigit=30, WHITE_SPACE=31;
	public static final int
		RULE_compUnit = 0, RULE_funcDef = 1, RULE_decl = 2, RULE_constDecl = 3, 
		RULE_constDef = 4, RULE_constInitVal = 5, RULE_constExp = 6, RULE_varDecl = 7, 
		RULE_varDef = 8, RULE_initVal = 9, RULE_block = 10, RULE_blockItem = 11, 
		RULE_stmt = 12, RULE_cond = 13, RULE_lorexp = 14, RULE_landexp = 15, RULE_eqexp = 16, 
		RULE_relexp = 17, RULE_exp = 18, RULE_lval = 19, RULE_primaryexp = 20, 
		RULE_addexp = 21, RULE_mulexp = 22, RULE_unaryexp = 23, RULE_funcrParams = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcDef", "decl", "constDecl", "constDef", "constInitVal", 
			"constExp", "varDecl", "varDef", "initVal", "block", "blockItem", "stmt", 
			"cond", "lorexp", "landexp", "eqexp", "relexp", "exp", "lval", "primaryexp", 
			"addexp", "mulexp", "unaryexp", "funcrParams"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'const'", "','", "';'", "'='", "'{'", "'}'", "'if'", 
			"'else'", "'return'", "'int'", "'main'", "'||'", "'&&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"FuncType", "Ident", "Orfunc", "Andfunc", "Comfunc", "Judgefunc", "Idigit", 
			"Nondigit", "Addfunc", "Mulfunc", "Number", "Decimalconst", "Octalconst", 
			"Hexadecimalconst", "Hexadecimalprefix", "Nonzerodigit", "Octaldigit", 
			"Digit", "Hexadecimaldigit", "WHITE_SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitCompUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompUnitContext compUnit() throws RecognitionException {
		CompUnitContext _localctx = new CompUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			funcDef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public TerminalNode Ident() { return getToken(calcParser.Ident, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(FuncType);
			setState(53);
			match(Ident);
			setState(54);
			match(T__0);
			setState(55);
			match(T__1);
			setState(56);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				constDecl();
				}
				break;
			case FuncType:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				varDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__2);
			setState(63);
			match(FuncType);
			setState(64);
			constDef();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(65);
				match(T__3);
				setState(66);
				constDef();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDefContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(Idigit);
			setState(75);
			match(T__5);
			setState(76);
			constInitVal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constInitVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			constExp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			addexp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode FuncType() { return getToken(calcParser.FuncType, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(FuncType);
			setState(83);
			varDef();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(84);
				match(T__3);
				setState(85);
				varDef();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDef);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(Idigit);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(Idigit);
				setState(95);
				match(T__5);
				setState(96);
				initVal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_initVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__6);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << T__10) | (1L << FuncType) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
				{
				{
				setState(102);
				blockItem();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockItem);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case FuncType:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				decl();
				}
				break;
			case T__0:
			case T__4:
			case T__6:
			case T__8:
			case T__10:
			case Idigit:
			case Addfunc:
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				lval();
				setState(115);
				match(T__5);
				setState(116);
				exp();
				setState(117);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(120);
					exp();
					}
				}

				setState(123);
				match(T__4);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(T__8);
				setState(125);
				match(T__0);
				setState(126);
				cond();
				setState(127);
				match(T__1);
				setState(128);
				stmt();
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(129);
					match(T__9);
					setState(130);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(T__10);
				setState(134);
				exp();
				setState(135);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return ((calcVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			lorexp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LorexpContext extends ParserRuleContext {
		public LandexpContext landexp() {
			return getRuleContext(LandexpContext.class,0);
		}
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public TerminalNode Orfunc() { return getToken(calcParser.Orfunc, 0); }
		public LorexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lorexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitLorexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LorexpContext lorexp() throws RecognitionException {
		return lorexp(0);
	}

	private LorexpContext lorexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LorexpContext _localctx = new LorexpContext(_ctx, _parentState);
		LorexpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_lorexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(142);
			landexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LorexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lorexp);
					setState(144);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(145);
					match(Orfunc);
					setState(146);
					landexp(0);
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LandexpContext extends ParserRuleContext {
		public EqexpContext eqexp() {
			return getRuleContext(EqexpContext.class,0);
		}
		public LandexpContext landexp() {
			return getRuleContext(LandexpContext.class,0);
		}
		public TerminalNode Andfunc() { return getToken(calcParser.Andfunc, 0); }
		public LandexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_landexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitLandexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandexpContext landexp() throws RecognitionException {
		return landexp(0);
	}

	private LandexpContext landexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LandexpContext _localctx = new LandexpContext(_ctx, _parentState);
		LandexpContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_landexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(153);
			eqexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LandexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_landexp);
					setState(155);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(156);
					match(Andfunc);
					setState(157);
					eqexp(0);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqexpContext extends ParserRuleContext {
		public RelexpContext relexp() {
			return getRuleContext(RelexpContext.class,0);
		}
		public EqexpContext eqexp() {
			return getRuleContext(EqexpContext.class,0);
		}
		public TerminalNode Judgefunc() { return getToken(calcParser.Judgefunc, 0); }
		public EqexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitEqexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqexpContext eqexp() throws RecognitionException {
		return eqexp(0);
	}

	private EqexpContext eqexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqexpContext _localctx = new EqexpContext(_ctx, _parentState);
		EqexpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_eqexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(164);
			relexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqexp);
					setState(166);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(167);
					match(Judgefunc);
					setState(168);
					relexp(0);
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelexpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public RelexpContext relexp() {
			return getRuleContext(RelexpContext.class,0);
		}
		public TerminalNode Comfunc() { return getToken(calcParser.Comfunc, 0); }
		public RelexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitRelexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelexpContext relexp() throws RecognitionException {
		return relexp(0);
	}

	private RelexpContext relexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelexpContext _localctx = new RelexpContext(_ctx, _parentState);
		RelexpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_relexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175);
			addexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relexp);
					setState(177);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(178);
					match(Comfunc);
					setState(179);
					addexp(0);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			addexp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalContext extends ParserRuleContext {
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitLval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(Idigit);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryexpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public TerminalNode Number() { return getToken(calcParser.Number, 0); }
		public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitPrimaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpContext primaryexp() throws RecognitionException {
		PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryexp);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(T__0);
				setState(190);
				exp();
				setState(191);
				match(T__1);
				}
				break;
			case Idigit:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				lval();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(Number);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddexpContext extends ParserRuleContext {
		public MulexpContext mulexp() {
			return getRuleContext(MulexpContext.class,0);
		}
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public TerminalNode Addfunc() { return getToken(calcParser.Addfunc, 0); }
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitAddexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexpContext addexp() throws RecognitionException {
		return addexp(0);
	}

	private AddexpContext addexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddexpContext _localctx = new AddexpContext(_ctx, _parentState);
		AddexpContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_addexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(198);
			mulexp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addexp);
					setState(200);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(201);
					match(Addfunc);
					setState(202);
					mulexp(0);
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulexpContext extends ParserRuleContext {
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public MulexpContext mulexp() {
			return getRuleContext(MulexpContext.class,0);
		}
		public TerminalNode Mulfunc() { return getToken(calcParser.Mulfunc, 0); }
		public MulexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitMulexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexpContext mulexp() throws RecognitionException {
		return mulexp(0);
	}

	private MulexpContext mulexp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulexpContext _localctx = new MulexpContext(_ctx, _parentState);
		MulexpContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_mulexp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(209);
			unaryexp();
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulexpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulexp);
					setState(211);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(212);
					match(Mulfunc);
					setState(213);
					unaryexp();
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryexpContext extends ParserRuleContext {
		public PrimaryexpContext primaryexp() {
			return getRuleContext(PrimaryexpContext.class,0);
		}
		public TerminalNode Idigit() { return getToken(calcParser.Idigit, 0); }
		public FuncrParamsContext funcrParams() {
			return getRuleContext(FuncrParamsContext.class,0);
		}
		public TerminalNode Addfunc() { return getToken(calcParser.Addfunc, 0); }
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public UnaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitUnaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpContext unaryexp() throws RecognitionException {
		UnaryexpContext _localctx = new UnaryexpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unaryexp);
		int _la;
		try {
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				primaryexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(Idigit);
				setState(221);
				match(T__0);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Idigit) | (1L << Addfunc) | (1L << Number))) != 0)) {
					{
					setState(222);
					funcrParams();
					}
				}

				setState(225);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(Addfunc);
				setState(227);
				unaryexp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncrParamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncrParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcrParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calcVisitor ) return (T) ((calcVisitor<? extends T>)visitor).visitFuncrParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncrParamsContext funcrParams() throws RecognitionException {
		FuncrParamsContext _localctx = new FuncrParamsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_funcrParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			exp();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(231);
				match(T__3);
				setState(232);
				exp();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return lorexp_sempred((LorexpContext)_localctx, predIndex);
		case 15:
			return landexp_sempred((LandexpContext)_localctx, predIndex);
		case 16:
			return eqexp_sempred((EqexpContext)_localctx, predIndex);
		case 17:
			return relexp_sempred((RelexpContext)_localctx, predIndex);
		case 21:
			return addexp_sempred((AddexpContext)_localctx, predIndex);
		case 22:
			return mulexp_sempred((MulexpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lorexp_sempred(LorexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean landexp_sempred(LandexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqexp_sempred(EqexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relexp_sempred(RelexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addexp_sempred(AddexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulexp_sempred(MulexpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00f1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\5\4?\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\7\tY\n\t\f\t\16\t\\\13\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\5\nd\n\n\3\13\3\13\3\f\3\f\7\fj\n\f\f\f\16\fm\13\f\3\f\3\f\3\r\3\r\5"+
		"\rs\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16|\n\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u0086\n\16\3\16\3\16\3\16\3\16\5\16\u008c"+
		"\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0096\n\20\f\20\16"+
		"\20\u0099\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00a1\n\21\f\21\16"+
		"\21\u00a4\13\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00ac\n\22\f\22\16"+
		"\22\u00af\13\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00b7\n\23\f\23\16"+
		"\23\u00ba\13\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u00c6\n\26\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00ce\n\27\f\27\16\27\u00d1"+
		"\13\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u00d9\n\30\f\30\16\30\u00dc"+
		"\13\30\3\31\3\31\3\31\3\31\5\31\u00e2\n\31\3\31\3\31\3\31\5\31\u00e7\n"+
		"\31\3\32\3\32\3\32\7\32\u00ec\n\32\f\32\16\32\u00ef\13\32\3\32\2\b\36"+
		" \"$,.\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\2"+
		"\u00ef\2\64\3\2\2\2\4\66\3\2\2\2\6>\3\2\2\2\b@\3\2\2\2\nL\3\2\2\2\fP\3"+
		"\2\2\2\16R\3\2\2\2\20T\3\2\2\2\22c\3\2\2\2\24e\3\2\2\2\26g\3\2\2\2\30"+
		"r\3\2\2\2\32\u008b\3\2\2\2\34\u008d\3\2\2\2\36\u008f\3\2\2\2 \u009a\3"+
		"\2\2\2\"\u00a5\3\2\2\2$\u00b0\3\2\2\2&\u00bb\3\2\2\2(\u00bd\3\2\2\2*\u00c5"+
		"\3\2\2\2,\u00c7\3\2\2\2.\u00d2\3\2\2\2\60\u00e6\3\2\2\2\62\u00e8\3\2\2"+
		"\2\64\65\5\4\3\2\65\3\3\2\2\2\66\67\7\16\2\2\678\7\17\2\289\7\3\2\29:"+
		"\7\4\2\2:;\5\26\f\2;\5\3\2\2\2<?\5\b\5\2=?\5\20\t\2><\3\2\2\2>=\3\2\2"+
		"\2?\7\3\2\2\2@A\7\5\2\2AB\7\16\2\2BG\5\n\6\2CD\7\6\2\2DF\5\n\6\2EC\3\2"+
		"\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\7\2\2K\t\3"+
		"\2\2\2LM\7\24\2\2MN\7\b\2\2NO\5\f\7\2O\13\3\2\2\2PQ\5\16\b\2Q\r\3\2\2"+
		"\2RS\5,\27\2S\17\3\2\2\2TU\7\16\2\2UZ\5\22\n\2VW\7\6\2\2WY\5\22\n\2XV"+
		"\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\7\2\2"+
		"^\21\3\2\2\2_d\7\24\2\2`a\7\24\2\2ab\7\b\2\2bd\5\24\13\2c_\3\2\2\2c`\3"+
		"\2\2\2d\23\3\2\2\2ef\5&\24\2f\25\3\2\2\2gk\7\t\2\2hj\5\30\r\2ih\3\2\2"+
		"\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\n\2\2o\27\3\2"+
		"\2\2ps\5\6\4\2qs\5\32\16\2rp\3\2\2\2rq\3\2\2\2s\31\3\2\2\2tu\5(\25\2u"+
		"v\7\b\2\2vw\5&\24\2wx\7\7\2\2x\u008c\3\2\2\2y\u008c\5\26\f\2z|\5&\24\2"+
		"{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}\u008c\7\7\2\2~\177\7\13\2\2\177\u0080"+
		"\7\3\2\2\u0080\u0081\5\34\17\2\u0081\u0082\7\4\2\2\u0082\u0085\5\32\16"+
		"\2\u0083\u0084\7\f\2\2\u0084\u0086\5\32\16\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u008c\3\2\2\2\u0087\u0088\7\r\2\2\u0088\u0089\5&"+
		"\24\2\u0089\u008a\7\7\2\2\u008a\u008c\3\2\2\2\u008bt\3\2\2\2\u008by\3"+
		"\2\2\2\u008b{\3\2\2\2\u008b~\3\2\2\2\u008b\u0087\3\2\2\2\u008c\33\3\2"+
		"\2\2\u008d\u008e\5\36\20\2\u008e\35\3\2\2\2\u008f\u0090\b\20\1\2\u0090"+
		"\u0091\5 \21\2\u0091\u0097\3\2\2\2\u0092\u0093\f\3\2\2\u0093\u0094\7\20"+
		"\2\2\u0094\u0096\5 \21\2\u0095\u0092\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\37\3\2\2\2\u0099\u0097\3\2\2"+
		"\2\u009a\u009b\b\21\1\2\u009b\u009c\5\"\22\2\u009c\u00a2\3\2\2\2\u009d"+
		"\u009e\f\3\2\2\u009e\u009f\7\21\2\2\u009f\u00a1\5\"\22\2\u00a0\u009d\3"+
		"\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"!\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\b\22\1\2\u00a6\u00a7\5$\23\2"+
		"\u00a7\u00ad\3\2\2\2\u00a8\u00a9\f\3\2\2\u00a9\u00aa\7\23\2\2\u00aa\u00ac"+
		"\5$\23\2\u00ab\u00a8\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae#\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\b\23\1\2"+
		"\u00b1\u00b2\5,\27\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4\f\3\2\2\u00b4\u00b5"+
		"\7\22\2\2\u00b5\u00b7\5,\27\2\u00b6\u00b3\3\2\2\2\u00b7\u00ba\3\2\2\2"+
		"\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9%\3\2\2\2\u00ba\u00b8\3"+
		"\2\2\2\u00bb\u00bc\5,\27\2\u00bc\'\3\2\2\2\u00bd\u00be\7\24\2\2\u00be"+
		")\3\2\2\2\u00bf\u00c0\7\3\2\2\u00c0\u00c1\5&\24\2\u00c1\u00c2\7\4\2\2"+
		"\u00c2\u00c6\3\2\2\2\u00c3\u00c6\5(\25\2\u00c4\u00c6\7\30\2\2\u00c5\u00bf"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6+\3\2\2\2\u00c7"+
		"\u00c8\b\27\1\2\u00c8\u00c9\5.\30\2\u00c9\u00cf\3\2\2\2\u00ca\u00cb\f"+
		"\3\2\2\u00cb\u00cc\7\26\2\2\u00cc\u00ce\5.\30\2\u00cd\u00ca\3\2\2\2\u00ce"+
		"\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0-\3\2\2\2"+
		"\u00d1\u00cf\3\2\2\2\u00d2\u00d3\b\30\1\2\u00d3\u00d4\5\60\31\2\u00d4"+
		"\u00da\3\2\2\2\u00d5\u00d6\f\3\2\2\u00d6\u00d7\7\27\2\2\u00d7\u00d9\5"+
		"\60\31\2\u00d8\u00d5\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db/\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00e7\5*\26\2"+
		"\u00de\u00df\7\24\2\2\u00df\u00e1\7\3\2\2\u00e0\u00e2\5\62\32\2\u00e1"+
		"\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e7\7\4"+
		"\2\2\u00e4\u00e5\7\26\2\2\u00e5\u00e7\5\60\31\2\u00e6\u00dd\3\2\2\2\u00e6"+
		"\u00de\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\61\3\2\2\2\u00e8\u00ed\5&\24"+
		"\2\u00e9\u00ea\7\6\2\2\u00ea\u00ec\5&\24\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\63\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\25>GZckr{\u0085\u008b\u0097\u00a2\u00ad\u00b8\u00c5\u00cf"+
		"\u00da\u00e1\u00e6\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}