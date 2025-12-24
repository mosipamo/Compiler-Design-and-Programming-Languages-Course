// Generated from /home/mosipamo/Downloads/phase-3-ce-mosipamo/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.2
package main.grammar;

    import main.ast.nodes.*;
    import main.ast.nodes.statement.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.expression.operator.*;
    import main.ast.nodes.expression.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Break=1, Char=2, Const=3, Continue=4, Do=5, Double=6, Else=7, Float=8, 
		For=9, If=10, Int=11, Long=12, Return=13, Short=14, Signed=15, Sizeof=16, 
		Switch=17, Typedef=18, Unsigned=19, Void=20, While=21, Bool=22, LeftParen=23, 
		RightParen=24, LeftBracket=25, RightBracket=26, LeftBrace=27, RightBrace=28, 
		Less=29, LessEqual=30, Greater=31, GreaterEqual=32, LeftShift=33, RightShift=34, 
		Plus=35, PlusPlus=36, Minus=37, MinusMinus=38, Star=39, Div=40, Mod=41, 
		And=42, Or=43, AndAnd=44, OrOr=45, Xor=46, Not=47, Tilde=48, Question=49, 
		Colon=50, Semi=51, Comma=52, Assign=53, StarAssign=54, DivAssign=55, ModAssign=56, 
		PlusAssign=57, MinusAssign=58, LeftShiftAssign=59, RightShiftAssign=60, 
		AndAssign=61, XorAssign=62, OrAssign=63, Equal=64, NotEqual=65, Arrow=66, 
		Dot=67, Identifier=68, Constant=69, DigitSequence=70, StringLiteral=71, 
		MultiLineMacro=72, Directive=73, Whitespace=74, Newline=75, BlockComment=76, 
		LineComment=77;
	public static final int
		RULE_program = 0, RULE_translationUnit = 1, RULE_externalDeclaration = 2, 
		RULE_functionDefinition = 3, RULE_declarationList = 4, RULE_expression = 5, 
		RULE_argumentExpressionList = 6, RULE_unaryOperator = 7, RULE_castExpression = 8, 
		RULE_assignmentOperator = 9, RULE_declaration = 10, RULE_declarationSpecifiers = 11, 
		RULE_declarationSpecifier = 12, RULE_initDeclaratorList = 13, RULE_initDeclarator = 14, 
		RULE_typeSpecifier = 15, RULE_specifierQualifierList = 16, RULE_declarator = 17, 
		RULE_directDeclarator = 18, RULE_pointer = 19, RULE_parameterList = 20, 
		RULE_parameterDeclaration = 21, RULE_identifierList = 22, RULE_typeName = 23, 
		RULE_abstractDeclarator = 24, RULE_directAbstractDeclarator = 25, RULE_initializer = 26, 
		RULE_initializerList = 27, RULE_designation = 28, RULE_designator = 29, 
		RULE_statement = 30, RULE_compoundStatement = 31, RULE_blockItem = 32, 
		RULE_expressionStatement = 33, RULE_selectionStatement = 34, RULE_iterationStatement = 35, 
		RULE_forCondition = 36, RULE_forDeclaration = 37, RULE_forExpression = 38, 
		RULE_jumpStatement = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "translationUnit", "externalDeclaration", "functionDefinition", 
			"declarationList", "expression", "argumentExpressionList", "unaryOperator", 
			"castExpression", "assignmentOperator", "declaration", "declarationSpecifiers", 
			"declarationSpecifier", "initDeclaratorList", "initDeclarator", "typeSpecifier", 
			"specifierQualifierList", "declarator", "directDeclarator", "pointer", 
			"parameterList", "parameterDeclaration", "identifierList", "typeName", 
			"abstractDeclarator", "directAbstractDeclarator", "initializer", "initializerList", 
			"designation", "designator", "statement", "compoundStatement", "blockItem", 
			"expressionStatement", "selectionStatement", "iterationStatement", "forCondition", 
			"forDeclaration", "forExpression", "jumpStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'break'", "'char'", "'const'", "'continue'", "'do'", "'double'", 
			"'else'", "'float'", "'for'", "'if'", "'int'", "'long'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'switch'", "'typedef'", "'unsigned'", 
			"'void'", "'while'", "'bool'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'<'", "'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", 
			"'*'", "'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", 
			"'?'", "':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", 
			"'<<='", "'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Break", "Char", "Const", "Continue", "Do", "Double", "Else", "Float", 
			"For", "If", "Int", "Long", "Return", "Short", "Signed", "Sizeof", "Switch", 
			"Typedef", "Unsigned", "Void", "While", "Bool", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "PlusPlus", 
			"Minus", "MinusMinus", "Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", 
			"Xor", "Not", "Tilde", "Question", "Colon", "Semi", "Comma", "Assign", 
			"StarAssign", "DivAssign", "ModAssign", "PlusAssign", "MinusAssign", 
			"LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", "OrAssign", 
			"Equal", "NotEqual", "Arrow", "Dot", "Identifier", "Constant", "DigitSequence", 
			"StringLiteral", "MultiLineMacro", "Directive", "Whitespace", "Newline", 
			"BlockComment", "LineComment"
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
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public TranslationUnitContext t;
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).programRet =  new Program(); 
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier) {
				{
				setState(81);
				((ProgramContext)_localctx).t = translationUnit();
				 _localctx.programRet.setTranslationUnit(((ProgramContext)_localctx).t.translationUnitRet); _localctx.programRet.setLine(_localctx.getStart().getLine()); 
				}
			}

			setState(86);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TranslationUnitContext extends ParserRuleContext {
		public TranslationUnit translationUnitRet;
		public ExternalDeclarationContext e;
		public List<ExternalDeclarationContext> externalDeclaration() {
			return getRuleContexts(ExternalDeclarationContext.class);
		}
		public ExternalDeclarationContext externalDeclaration(int i) {
			return getRuleContext(ExternalDeclarationContext.class,i);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTranslationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTranslationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_translationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TranslationUnitContext)_localctx).translationUnitRet =  new TranslationUnit(); 
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				((TranslationUnitContext)_localctx).e = externalDeclaration();
				_localctx.translationUnitRet.addExternalDeclaration(((TranslationUnitContext)_localctx).e.externalDeclarationRet); _localctx.translationUnitRet.setLine(_localctx.getStart().getLine()); 
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2252349583972684L) != 0) || _la==Identifier );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExternalDeclarationContext extends ParserRuleContext {
		public ExternalDeclaration externalDeclarationRet;
		public FunctionDefinitionContext f;
		public DeclarationContext d;
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExternalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExternalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_externalDeclaration);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((ExternalDeclarationContext)_localctx).externalDeclarationRet =  new ExternalDeclaration(); 
				setState(97);
				((ExternalDeclarationContext)_localctx).f = functionDefinition();
				 _localctx.externalDeclarationRet.setFunctionDefinition(((ExternalDeclarationContext)_localctx).f.functionDefinitionRet); _localctx.externalDeclarationRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				((ExternalDeclarationContext)_localctx).d = declaration();
				 _localctx.externalDeclarationRet.setDeclaration(((ExternalDeclarationContext)_localctx).d.declarationRet); _localctx.externalDeclarationRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				match(Semi);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public FunctionDefinition functionDefinitionRet;
		public DeclarationSpecifiersContext ds;
		public DeclaratorContext d;
		public DeclarationListContext dl;
		public CompoundStatementContext cs;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionDefinitionContext)_localctx).functionDefinitionRet =  new FunctionDefinition(); 
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(107);
				((FunctionDefinitionContext)_localctx).ds = declarationSpecifiers();
				 _localctx.functionDefinitionRet.addDeclarationSpecifiers(((FunctionDefinitionContext)_localctx).ds.declarationSpecifiersRet); _localctx.functionDefinitionRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			}
			setState(112);
			((FunctionDefinitionContext)_localctx).d = declarator();
			 _localctx.functionDefinitionRet.setDeclarator(((FunctionDefinitionContext)_localctx).d.declaratorRet); _localctx.functionDefinitionRet.setLine(_localctx.getStart().getLine()); 
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
				{
				setState(114);
				((FunctionDefinitionContext)_localctx).dl = declarationList();
				 _localctx.functionDefinitionRet.addDeclarationList(((FunctionDefinitionContext)_localctx).dl.declarationListRet); _localctx.functionDefinitionRet.setLine(_localctx.getStart().getLine()); 
				}
			}

			setState(119);
			((FunctionDefinitionContext)_localctx).cs = compoundStatement();
			 _localctx.functionDefinitionRet.setCompoundStatement(((FunctionDefinitionContext)_localctx).cs.compoundStatementRet); _localctx.functionDefinitionRet.setLine(_localctx.getStart().getLine()); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationListContext extends ParserRuleContext {
		public DeclarationList declarationListRet;
		public DeclarationContext d;
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declarationList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationListContext)_localctx).declarationListRet =  new DeclarationList(); 
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				((DeclarationListContext)_localctx).d = declaration();
				_localctx.declarationListRet.addDeclaration(((DeclarationListContext)_localctx).d.declarationRet); _localctx.declarationListRet.setLine(_localctx.getStart().getLine()); 
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionContext e3;
		public ExpressionContext e4;
		public ExpressionContext e7;
		public ExpressionContext e9;
		public ExpressionContext e11;
		public ExpressionContext e13;
		public ExpressionContext e15;
		public ExpressionContext e17;
		public ExpressionContext e19;
		public ExpressionContext e21;
		public ExpressionContext e23;
		public ExpressionContext e25;
		public ExpressionContext e27;
		public ExpressionContext e30;
		public Token Identifier;
		public Token Constant;
		public Token StringLiteral;
		public ExpressionContext e;
		public TypeNameContext typ1;
		public InitializerListContext i;
		public Token an;
		public ExpressionContext e6;
		public TypeNameContext typ;
		public InitializerListContext i1;
		public UnaryOperatorContext uu;
		public CastExpressionContext c;
		public TypeNameContext typ2;
		public TypeNameContext typ3;
		public CastExpressionContext ca;
		public Token s;
		public ExpressionContext e8;
		public ExpressionContext e10;
		public ExpressionContext e12;
		public ExpressionContext e14;
		public ExpressionContext e16;
		public ExpressionContext e18;
		public ExpressionContext e20;
		public ExpressionContext e22;
		public ExpressionContext e24;
		public ExpressionContext e26;
		public Token sl;
		public ExpressionContext e28;
		public Token sr;
		public ExpressionContext e29;
		public AssignmentOperatorContext as;
		public ExpressionContext e31;
		public ExpressionContext e5;
		public Token l;
		public ArgumentExpressionListContext a;
		public Token r;
		public Token pp;
		public Token mm;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(SimpleLangParser.Constant, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(SimpleLangParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(SimpleLangParser.StringLiteral, i);
		}
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public List<TerminalNode> Sizeof() { return getTokens(SimpleLangParser.Sizeof); }
		public TerminalNode Sizeof(int i) {
			return getToken(SimpleLangParser.Sizeof, i);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public List<TerminalNode> PlusPlus() { return getTokens(SimpleLangParser.PlusPlus); }
		public TerminalNode PlusPlus(int i) {
			return getToken(SimpleLangParser.PlusPlus, i);
		}
		public List<TerminalNode> MinusMinus() { return getTokens(SimpleLangParser.MinusMinus); }
		public TerminalNode MinusMinus(int i) {
			return getToken(SimpleLangParser.MinusMinus, i);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Div() { return getToken(SimpleLangParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SimpleLangParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(SimpleLangParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(SimpleLangParser.RightShift, 0); }
		public TerminalNode Less() { return getToken(SimpleLangParser.Less, 0); }
		public TerminalNode Greater() { return getToken(SimpleLangParser.Greater, 0); }
		public TerminalNode LessEqual() { return getToken(SimpleLangParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(SimpleLangParser.GreaterEqual, 0); }
		public TerminalNode Equal() { return getToken(SimpleLangParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(SimpleLangParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Xor() { return getToken(SimpleLangParser.Xor, 0); }
		public TerminalNode Or() { return getToken(SimpleLangParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(SimpleLangParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(SimpleLangParser.OrOr, 0); }
		public TerminalNode Question() { return getToken(SimpleLangParser.Question, 0); }
		public TerminalNode Colon() { return getToken(SimpleLangParser.Colon, 0); }
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(131);
				((ExpressionContext)_localctx).Identifier = match(Identifier);
				 IdentifierExpression identifierexpr = new IdentifierExpression((((ExpressionContext)_localctx).Identifier!=null?((ExpressionContext)_localctx).Identifier.getText():null)); identifierexpr.setLine(((ExpressionContext)_localctx).Identifier.getLine()); ((ExpressionContext)_localctx).expressionRet =  identifierexpr; 
				}
				break;
			case 2:
				{
				setState(133);
				((ExpressionContext)_localctx).Constant = match(Constant);
				 ConstantExpression commaexpr = new ConstantExpression((((ExpressionContext)_localctx).Constant!=null?((ExpressionContext)_localctx).Constant.getText():null)); commaexpr.setLine(((ExpressionContext)_localctx).Constant.getLine()); ((ExpressionContext)_localctx).expressionRet =  commaexpr; 
				}
				break;
			case 3:
				{
				StringLiteralExpression stringlit = new StringLiteralExpression();
				setState(138); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(136);
						((ExpressionContext)_localctx).StringLiteral = match(StringLiteral);
						 stringlit.addStringLiteralExpression((((ExpressionContext)_localctx).StringLiteral!=null?((ExpressionContext)_localctx).StringLiteral.getText():null)); stringlit.setLine(((ExpressionContext)_localctx).StringLiteral.getLine()); ((ExpressionContext)_localctx).expressionRet =  stringlit; 
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(140); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				setState(142);
				match(LeftParen);
				{
				setState(143);
				((ExpressionContext)_localctx).e = expression(0);
				 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).e.expressionRet; 
				}
				setState(146);
				match(RightParen);
				}
				break;
			case 5:
				{
				setState(148);
				match(LeftParen);
				setState(149);
				((ExpressionContext)_localctx).typ1 = typeName();

				          PtrExpression ptr = new PtrExpression();
				          ptr.setTypeName(((ExpressionContext)_localctx).typ1.typeNameRet);
				          ptr.setLine(_localctx.getStart().getLine());
				      
				setState(151);
				match(RightParen);
				setState(152);
				match(LeftBrace);
				setState(153);
				((ExpressionContext)_localctx).i = initializerList();

				          ptr.setInitializerList(((ExpressionContext)_localctx).i.initializerListRet);
				          ptr.setLine(_localctx.getStart().getLine());
				          ((ExpressionContext)_localctx).expressionRet =  ptr;
				      
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(155);
					match(Comma);
					}
				}

				setState(158);
				match(RightBrace);
				}
				break;
			case 6:
				{
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(160);
						((ExpressionContext)_localctx).an = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 343597449216L) != 0)) ) {
							((ExpressionContext)_localctx).an = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(165);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				setState(204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(166);
					((ExpressionContext)_localctx).Identifier = match(Identifier);
					 IdentifierExpression identifierexpr = new IdentifierExpression((((ExpressionContext)_localctx).Identifier!=null?((ExpressionContext)_localctx).Identifier.getText():null)); identifierexpr.setLine(((ExpressionContext)_localctx).Identifier.getLine());  ((ExpressionContext)_localctx).expressionRet =  identifierexpr; {_localctx.expressionRet.addTemp_op((((ExpressionContext)_localctx).an!=null?((ExpressionContext)_localctx).an.getText():null));} 
					}
					break;
				case 2:
					{
					setState(168);
					((ExpressionContext)_localctx).Constant = match(Constant);
					 ConstantExpression commaexpr = new ConstantExpression((((ExpressionContext)_localctx).Constant!=null?((ExpressionContext)_localctx).Constant.getText():null)); commaexpr.setLine(((ExpressionContext)_localctx).Constant.getLine()); ((ExpressionContext)_localctx).expressionRet =  commaexpr;
					}
					break;
				case 3:
					{
					StringLiteralExpression stringlit = new StringLiteralExpression();
					setState(173); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(171);
							((ExpressionContext)_localctx).StringLiteral = match(StringLiteral);
							 stringlit.addStringLiteralExpression((((ExpressionContext)_localctx).StringLiteral!=null?((ExpressionContext)_localctx).StringLiteral.getText():null)); stringlit.setLine(((ExpressionContext)_localctx).StringLiteral.getLine()); ((ExpressionContext)_localctx).expressionRet =  stringlit; 
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(175); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				case 4:
					{
					setState(177);
					match(LeftParen);
					setState(178);
					((ExpressionContext)_localctx).e6 = expression(0);
					 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).e6.expressionRet; 
					setState(180);
					match(RightParen);
					}
					break;
				case 5:
					{
					setState(182);
					match(LeftParen);
					setState(183);
					((ExpressionContext)_localctx).typ = typeName();
					 PtrExpression ptr = new PtrExpression(); ptr.setTypeName(((ExpressionContext)_localctx).typ.typeNameRet); ptr.setLine(_localctx.getStart().getLine());
					setState(185);
					match(RightParen);
					setState(186);
					match(LeftBrace);
					setState(187);
					((ExpressionContext)_localctx).i1 = initializerList();
					 ptr.setInitializerList(((ExpressionContext)_localctx).i1.initializerListRet); ptr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  ptr;
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(189);
						match(Comma);
						}
					}

					setState(192);
					match(RightBrace);
					}
					break;
				case 6:
					{
					setState(194);
					((ExpressionContext)_localctx).uu = unaryOperator();
					{
					setState(195);
					((ExpressionContext)_localctx).c = castExpression();
					 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).c.castExpressionRet; _localctx.expressionRet.setUnaryOperator(((ExpressionContext)_localctx).uu.unaryOperatorRet); _localctx.expressionRet.setLine(_localctx.getStart().getLine()); 
					}
					}
					break;
				case 7:
					{
					setState(198);
					match(Sizeof);
					setState(199);
					match(LeftParen);
					setState(200);
					((ExpressionContext)_localctx).typ2 = typeName();
					 PtrExpressionWithoutInitializerList ptr2 = new PtrExpressionWithoutInitializerList(); ptr2.setTypeName(((ExpressionContext)_localctx).typ2.typeNameRet); ptr2.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  ptr2; 
					setState(202);
					match(RightParen);
					}
					break;
				}
				}
				break;
			case 7:
				{
				setState(206);
				match(LeftParen);
				setState(207);
				((ExpressionContext)_localctx).typ3 = typeName();
				setState(208);
				match(RightParen);
				setState(209);
				((ExpressionContext)_localctx).ca = castExpression();

				      ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).ca.castExpressionRet;
				      _localctx.expressionRet.setTypeName(((ExpressionContext)_localctx).typ3.typeNameRet);
				      _localctx.expressionRet.setLine(_localctx.getStart().getLine());
				  
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e7 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(215);
						((ExpressionContext)_localctx).s = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3848290697216L) != 0)) ) {
							((ExpressionContext)_localctx).s = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(216);
						((ExpressionContext)_localctx).e8 = expression(13);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e7.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e8.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e9 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(220);
						((ExpressionContext)_localctx).s = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((ExpressionContext)_localctx).s = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						((ExpressionContext)_localctx).e10 = expression(12);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e9.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e10.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e11 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(224);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(225);
						((ExpressionContext)_localctx).s = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((ExpressionContext)_localctx).s = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(226);
						((ExpressionContext)_localctx).e12 = expression(11);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e11.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e12.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e13 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(230);
						((ExpressionContext)_localctx).s = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053063680L) != 0)) ) {
							((ExpressionContext)_localctx).s = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(231);
						((ExpressionContext)_localctx).e14 = expression(10);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e13.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e14.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e15 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(235);
						((ExpressionContext)_localctx).s = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((ExpressionContext)_localctx).s = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(236);
						((ExpressionContext)_localctx).e16 = expression(9);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e15.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e16.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e17 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(240);
						((ExpressionContext)_localctx).s = match(And);
						setState(241);
						((ExpressionContext)_localctx).e18 = expression(8);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e17.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e18.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e19 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(245);
						((ExpressionContext)_localctx).s = match(Xor);
						setState(246);
						((ExpressionContext)_localctx).e20 = expression(7);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e19.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e20.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e21 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(250);
						((ExpressionContext)_localctx).s = match(Or);
						setState(251);
						((ExpressionContext)_localctx).e22 = expression(6);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e21.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e22.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e23 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(255);
						((ExpressionContext)_localctx).s = match(AndAnd);
						setState(256);
						((ExpressionContext)_localctx).e24 = expression(5);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e23.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e24.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e25 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(259);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(260);
						((ExpressionContext)_localctx).s = match(OrOr);
						setState(261);
						((ExpressionContext)_localctx).e26 = expression(4);
						BinaryExpression bexpr = new BinaryExpression(); bexpr.setLeft(((ExpressionContext)_localctx).e25.expressionRet); bexpr.setRight(((ExpressionContext)_localctx).e26.expressionRet); bexpr.setOperator((((ExpressionContext)_localctx).s!=null?((ExpressionContext)_localctx).s.getText():null)); bexpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e27 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(264);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(265);
						((ExpressionContext)_localctx).sl = match(Question);
						setState(266);
						((ExpressionContext)_localctx).e28 = expression(0);
						setState(267);
						((ExpressionContext)_localctx).sr = match(Colon);
						setState(268);
						((ExpressionContext)_localctx).e29 = expression(3);
						ThreeExpression ternaryExpr = new ThreeExpression(); ternaryExpr.setLeft(((ExpressionContext)_localctx).e27.expressionRet); ternaryExpr.setRight(((ExpressionContext)_localctx).e29.expressionRet); ternaryExpr.setMid(((ExpressionContext)_localctx).e28.expressionRet); ternaryExpr.setLeftOp((((ExpressionContext)_localctx).sl!=null?((ExpressionContext)_localctx).sl.getText():null)); ternaryExpr.setRightOp((((ExpressionContext)_localctx).sr!=null?((ExpressionContext)_localctx).sr.getText():null)); ternaryExpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  ternaryExpr;
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e30 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(272);
						((ExpressionContext)_localctx).as = assignmentOperator();
						setState(273);
						((ExpressionContext)_localctx).e31 = expression(2);
						AssignmentExpression assignExpr = new AssignmentExpression(); assignExpr.setLeft(((ExpressionContext)_localctx).e30.expressionRet); assignExpr.setRight(((ExpressionContext)_localctx).e31.expressionRet); assignExpr.setOperator(((ExpressionContext)_localctx).as.assignmentOperatorRet); assignExpr.setLine(_localctx.getStart().getLine()); ((ExpressionContext)_localctx).expressionRet =  assignExpr;
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(277);
						match(LeftBracket);
						setState(278);
						((ExpressionContext)_localctx).e5 = expression(0);
						setState(279);
						match(RightBracket);
						BinaryExpression bexpr = new BinaryExpression();
						                                                                           bexpr.setLeft(((ExpressionContext)_localctx).e1.expressionRet);
						                                                                           bexpr.setRight(((ExpressionContext)_localctx).e5.expressionRet);
						                                                                           bexpr.setOperator("[");
						                                                                           bexpr.setLine(_localctx.getStart().getLine());
						                                                                           ((ExpressionContext)_localctx).expressionRet =  bexpr;
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						 FunctionCallExpression fce = new FunctionCallExpression(); fce.setExpression(((ExpressionContext)_localctx).e2.expressionRet); 
						setState(284);
						((ExpressionContext)_localctx).l = match(LeftParen);
						setState(288);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(285);
							((ExpressionContext)_localctx).a = argumentExpressionList();
							 fce.setArgumentExpressionList(((ExpressionContext)_localctx).a.argumentExpressionListRet); fce.setLeft_par((((ExpressionContext)_localctx).l!=null?((ExpressionContext)_localctx).l.getText():null)); fce.setLine(_localctx.getStart().getLine()); 
							}
						}

						setState(290);
						((ExpressionContext)_localctx).r = match(RightParen);
						fce.setRight_par((((ExpressionContext)_localctx).r!=null?((ExpressionContext)_localctx).r.getText():null)); ((ExpressionContext)_localctx).expressionRet =  fce;
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e3 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).e3.expressionRet; 
						setState(294);
						((ExpressionContext)_localctx).pp = match(PlusPlus);
						_localctx.expressionRet.addTemp_op((((ExpressionContext)_localctx).pp!=null?((ExpressionContext)_localctx).pp.getText():null));
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e4 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						 ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).e4.expressionRet; 
						setState(298);
						((ExpressionContext)_localctx).mm = match(MinusMinus);
						_localctx.expressionRet.addTemp_op((((ExpressionContext)_localctx).mm!=null?((ExpressionContext)_localctx).mm.getText():null));
						}
						break;
					}
					} 
				}
				setState(304);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public ArgumentExpressionList argumentExpressionListRet;
		public ExpressionContext e;
		public ExpressionContext ex;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitArgumentExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitArgumentExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumentExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentExpressionListContext)_localctx).argumentExpressionListRet =  new ArgumentExpressionList(); 
			setState(306);
			((ArgumentExpressionListContext)_localctx).e = expression(0);
			 _localctx.argumentExpressionListRet.addExpression(((ArgumentExpressionListContext)_localctx).e.expressionRet); _localctx.argumentExpressionListRet.setLine(_localctx.getStart().getLine());
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(308);
				match(Comma);
				{
				setState(309);
				((ArgumentExpressionListContext)_localctx).ex = expression(0);
				 _localctx.argumentExpressionListRet.addExpression(((ArgumentExpressionListContext)_localctx).ex.expressionRet); _localctx.argumentExpressionListRet.setLine(_localctx.getStart().getLine()); 
				}
				}
				}
				setState(316);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperator unaryOperatorRet;
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public TerminalNode Star() { return getToken(SimpleLangParser.Star, 0); }
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public TerminalNode Tilde() { return getToken(SimpleLangParser.Tilde, 0); }
		public TerminalNode Not() { return getToken(SimpleLangParser.Not, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitUnaryOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unaryOperator);
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case And:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(And);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.AND; 
				}
				break;
			case Star:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(Star);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.STAR; 
				}
				break;
			case Plus:
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				match(Plus);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.PLUS; 
				}
				break;
			case Minus:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				match(Minus);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.MINUS; 
				}
				break;
			case Tilde:
				enterOuterAlt(_localctx, 5);
				{
				setState(325);
				match(Tilde);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.TILDE; 
				}
				break;
			case Not:
				enterOuterAlt(_localctx, 6);
				{
				setState(327);
				match(Not);
				 ((UnaryOperatorContext)_localctx).unaryOperatorRet =  UnaryOperator.NOT; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public CastExpression castExpressionRet;
		public TypeNameContext t;
		public CastExpressionContext c;
		public ExpressionContext e;
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DigitSequence() { return getToken(SimpleLangParser.DigitSequence, 0); }
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_castExpression);
		try {
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(LeftParen);
				setState(332);
				((CastExpressionContext)_localctx).t = typeName();
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(); _localctx.castExpressionRet.setTypeName(((CastExpressionContext)_localctx).t.typeNameRet); _localctx.castExpressionRet.setLine(_localctx.getStart().getLine()); 
				setState(334);
				match(RightParen);
				setState(335);
				((CastExpressionContext)_localctx).c = castExpression();
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(); _localctx.castExpressionRet.setCastExpression(((CastExpressionContext)_localctx).c.castExpressionRet); _localctx.castExpressionRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				((CastExpressionContext)_localctx).e = expression(0);
				 ((CastExpressionContext)_localctx).castExpressionRet =  new CastExpression(); _localctx.castExpressionRet.setExpression(((CastExpressionContext)_localctx).e.expressionRet); _localctx.castExpressionRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(DigitSequence);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperator assignmentOperatorRet;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public TerminalNode StarAssign() { return getToken(SimpleLangParser.StarAssign, 0); }
		public TerminalNode DivAssign() { return getToken(SimpleLangParser.DivAssign, 0); }
		public TerminalNode ModAssign() { return getToken(SimpleLangParser.ModAssign, 0); }
		public TerminalNode PlusAssign() { return getToken(SimpleLangParser.PlusAssign, 0); }
		public TerminalNode MinusAssign() { return getToken(SimpleLangParser.MinusAssign, 0); }
		public TerminalNode LeftShiftAssign() { return getToken(SimpleLangParser.LeftShiftAssign, 0); }
		public TerminalNode RightShiftAssign() { return getToken(SimpleLangParser.RightShiftAssign, 0); }
		public TerminalNode AndAssign() { return getToken(SimpleLangParser.AndAssign, 0); }
		public TerminalNode XorAssign() { return getToken(SimpleLangParser.XorAssign, 0); }
		public TerminalNode OrAssign() { return getToken(SimpleLangParser.OrAssign, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentOperator);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Assign:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(Assign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.ASSIGN;
				}
				break;
			case StarAssign:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				match(StarAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.STAR_ASSIGN;
				}
				break;
			case DivAssign:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				match(DivAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.DIV_ASSIGN;
				}
				break;
			case ModAssign:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				match(ModAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.MOD_ASSIGN;
				}
				break;
			case PlusAssign:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				match(PlusAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.PLUS_ASSIGN;
				}
				break;
			case MinusAssign:
				enterOuterAlt(_localctx, 6);
				{
				setState(354);
				match(MinusAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.MINUS_ASSIGN;
				}
				break;
			case LeftShiftAssign:
				enterOuterAlt(_localctx, 7);
				{
				setState(356);
				match(LeftShiftAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.LEFT_SHIFT_ASSIGN;
				}
				break;
			case RightShiftAssign:
				enterOuterAlt(_localctx, 8);
				{
				setState(358);
				match(RightShiftAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.RIGHT_SHIFT_ASSIGN;
				}
				break;
			case AndAssign:
				enterOuterAlt(_localctx, 9);
				{
				setState(360);
				match(AndAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.AND_ASSIGN;
				}
				break;
			case XorAssign:
				enterOuterAlt(_localctx, 10);
				{
				setState(362);
				match(XorAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.XOR_ASSIGN;
				}
				break;
			case OrAssign:
				enterOuterAlt(_localctx, 11);
				{
				setState(364);
				match(OrAssign);
				 ((AssignmentOperatorContext)_localctx).assignmentOperatorRet =  AssignmentOperator.OR_ASSIGN;
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public Declaration declarationRet;
		public DeclarationSpecifiersContext ds;
		public InitDeclaratorListContext idl;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationContext)_localctx).declarationRet =  new Declaration(); 
			setState(369);
			((DeclarationContext)_localctx).ds = declarationSpecifiers();
			 _localctx.declarationRet.setDeclarationSpecifiers(((DeclarationContext)_localctx).ds.declarationSpecifiersRet); _localctx.declarationRet.setLine(_localctx.getStart().getLine()); 
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(371);
				((DeclarationContext)_localctx).idl = initDeclaratorList();
				 _localctx.declarationRet.setInitDeclaratorList(((DeclarationContext)_localctx).idl.initDeclaratorListRet); _localctx.declarationRet.setLine(_localctx.getStart().getLine());
				}
			}

			setState(376);
			match(Semi);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public DeclarationSpecifiers declarationSpecifiersRet;
		public DeclarationSpecifierContext d;
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclarationSpecifiersContext)_localctx).declarationSpecifiersRet =  new DeclarationSpecifiers(); 
			setState(382); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(379);
					((DeclarationSpecifiersContext)_localctx).d = declarationSpecifier();
					_localctx.declarationSpecifiersRet.addSpecifier(((DeclarationSpecifiersContext)_localctx).d.declarationSpecifierRet); _localctx.declarationSpecifiersRet.setLine(_localctx.getStart().getLine()); 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(384); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public DeclarationSpecifier declarationSpecifierRet;
		public TypeSpecifierContext t;
		public TerminalNode Typedef() { return getToken(SimpleLangParser.Typedef, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarationSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarationSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarationSpecifier);
		try {
			setState(393);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				match(Typedef);
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier("typedef"); 
				}
				break;
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(388);
				((DeclarationSpecifierContext)_localctx).t = typeSpecifier();
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier(((DeclarationSpecifierContext)_localctx).t.typeSpecifierRet); _localctx.declarationSpecifierRet.setLine(_localctx.getStart().getLine()); 
				}
				}
				break;
			case Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(391);
				match(Const);
				 ((DeclarationSpecifierContext)_localctx).declarationSpecifierRet =  new DeclarationSpecifier("const"); _localctx.declarationSpecifierRet.setLine(_localctx.getStart().getLine()); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorListContext extends ParserRuleContext {
		public InitDeclaratorList initDeclaratorListRet;
		public InitDeclaratorContext a;
		public InitDeclaratorContext b;
		public List<InitDeclaratorContext> initDeclarator() {
			return getRuleContexts(InitDeclaratorContext.class);
		}
		public InitDeclaratorContext initDeclarator(int i) {
			return getRuleContext(InitDeclaratorContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InitDeclaratorListContext)_localctx).initDeclaratorListRet =  new InitDeclaratorList(); 
			setState(396);
			((InitDeclaratorListContext)_localctx).a = initDeclarator();
			 _localctx.initDeclaratorListRet.addInitDeclarator(((InitDeclaratorListContext)_localctx).a.initDeclaratorRet); _localctx.initDeclaratorListRet.setLine(_localctx.getStart().getLine());
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(398);
				match(Comma);
				setState(399);
				((InitDeclaratorListContext)_localctx).b = initDeclarator();
				 _localctx.initDeclaratorListRet.addInitDeclarator(((InitDeclaratorListContext)_localctx).b.initDeclaratorRet); _localctx.initDeclaratorListRet.setLine(_localctx.getStart().getLine());
				}
				}
				setState(406);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclaratorContext extends ParserRuleContext {
		public InitDeclarator initDeclaratorRet;
		public DeclaratorContext d;
		public InitializerContext i;
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InitDeclaratorContext)_localctx).initDeclaratorRet =  new InitDeclarator();
			setState(408);
			((InitDeclaratorContext)_localctx).d = declarator();
			 _localctx.initDeclaratorRet.setDeclarator(((InitDeclaratorContext)_localctx).d.declaratorRet); _localctx.initDeclaratorRet.setLine(_localctx.getStart().getLine());
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(410);
				match(Assign);
				setState(411);
				((InitDeclaratorContext)_localctx).i = initializer();
				 _localctx.initDeclaratorRet.setInitializer(((InitDeclaratorContext)_localctx).i.initializerRet); _localctx.initDeclaratorRet.setLine(_localctx.getStart().getLine());
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecifierContext extends ParserRuleContext {
		public TypeSpecifier typeSpecifierRet;
		public Token Void;
		public Token Char;
		public Token Short;
		public Token Int;
		public Token Long;
		public Token Float;
		public Token Double;
		public Token Signed;
		public Token Unsigned;
		public Token Bool;
		public Token Identifier;
		public TerminalNode Void() { return getToken(SimpleLangParser.Void, 0); }
		public TerminalNode Char() { return getToken(SimpleLangParser.Char, 0); }
		public TerminalNode Short() { return getToken(SimpleLangParser.Short, 0); }
		public TerminalNode Int() { return getToken(SimpleLangParser.Int, 0); }
		public TerminalNode Long() { return getToken(SimpleLangParser.Long, 0); }
		public TerminalNode Float() { return getToken(SimpleLangParser.Float, 0); }
		public TerminalNode Double() { return getToken(SimpleLangParser.Double, 0); }
		public TerminalNode Signed() { return getToken(SimpleLangParser.Signed, 0); }
		public TerminalNode Unsigned() { return getToken(SimpleLangParser.Unsigned, 0); }
		public TerminalNode Bool() { return getToken(SimpleLangParser.Bool, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeSpecifier);
		try {
			setState(438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Void:
				enterOuterAlt(_localctx, 1);
				{
				setState(416);
				((TypeSpecifierContext)_localctx).Void = match(Void);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("void"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Void.getLine());
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				((TypeSpecifierContext)_localctx).Char = match(Char);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("char"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Char.getLine());
				}
				break;
			case Short:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				((TypeSpecifierContext)_localctx).Short = match(Short);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("short"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Short.getLine());
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				((TypeSpecifierContext)_localctx).Int = match(Int);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("int"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Int.getLine());
				}
				break;
			case Long:
				enterOuterAlt(_localctx, 5);
				{
				setState(424);
				((TypeSpecifierContext)_localctx).Long = match(Long);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("long"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Long.getLine());
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 6);
				{
				setState(426);
				((TypeSpecifierContext)_localctx).Float = match(Float);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("float"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Float.getLine());
				}
				break;
			case Double:
				enterOuterAlt(_localctx, 7);
				{
				setState(428);
				((TypeSpecifierContext)_localctx).Double = match(Double);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("double"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Double.getLine());
				}
				break;
			case Signed:
				enterOuterAlt(_localctx, 8);
				{
				setState(430);
				((TypeSpecifierContext)_localctx).Signed = match(Signed);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("signed"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Signed.getLine());
				}
				break;
			case Unsigned:
				enterOuterAlt(_localctx, 9);
				{
				setState(432);
				((TypeSpecifierContext)_localctx).Unsigned = match(Unsigned);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("unsigned"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Unsigned.getLine());
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 10);
				{
				setState(434);
				((TypeSpecifierContext)_localctx).Bool = match(Bool);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier("bool"); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Bool.getLine());
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 11);
				{
				setState(436);
				((TypeSpecifierContext)_localctx).Identifier = match(Identifier);
				((TypeSpecifierContext)_localctx).typeSpecifierRet =  new TypeSpecifier((((TypeSpecifierContext)_localctx).Identifier!=null?((TypeSpecifierContext)_localctx).Identifier.getText():null)); _localctx.typeSpecifierRet.setLine(((TypeSpecifierContext)_localctx).Identifier.getLine());
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

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public SpecifierQualifierList specifierQualifierListRet;
		public TypeSpecifierContext t;
		public SpecifierQualifierListContext s;
		public TerminalNode Const() { return getToken(SimpleLangParser.Const, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSpecifierQualifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSpecifierQualifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_specifierQualifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((SpecifierQualifierListContext)_localctx).specifierQualifierListRet =  new SpecifierQualifierList(); 
			setState(445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Char:
			case Double:
			case Float:
			case Int:
			case Long:
			case Short:
			case Signed:
			case Unsigned:
			case Void:
			case Bool:
			case Identifier:
				{
				setState(441);
				((SpecifierQualifierListContext)_localctx).t = typeSpecifier();
				_localctx.specifierQualifierListRet.setTypeSpecifier(((SpecifierQualifierListContext)_localctx).t.typeSpecifierRet); _localctx.specifierQualifierListRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case Const:
				{
				setState(444);
				match(Const);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5822796L) != 0) || _la==Identifier) {
				{
				setState(447);
				((SpecifierQualifierListContext)_localctx).s = specifierQualifierList();
				 _localctx.specifierQualifierListRet.setSpecifierQualifierList(((SpecifierQualifierListContext)_localctx).s.specifierQualifierListRet); _localctx.specifierQualifierListRet.setLine(_localctx.getStart().getLine()); 
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaratorContext extends ParserRuleContext {
		public Declarator declaratorRet;
		public PointerContext p;
		public DirectDeclaratorContext d;
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DeclaratorContext)_localctx).declaratorRet =  new Declarator(); 
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Star) {
				{
				setState(453);
				((DeclaratorContext)_localctx).p = pointer();
				_localctx.declaratorRet.setPointer(((DeclaratorContext)_localctx).p.pointerTypeRet); _localctx.declaratorRet.setLine(_localctx.getStart().getLine());
				}
			}

			setState(458);
			((DeclaratorContext)_localctx).d = directDeclarator(0);
			 _localctx.declaratorRet.setDirectDeclarator(((DeclaratorContext)_localctx).d.directDeclaratorRet); _localctx.declaratorRet.setLine(_localctx.getStart().getLine()); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class DirectDeclaratorContext extends ParserRuleContext {
		public DirectDeclarator directDeclaratorRet;
		public DirectDeclaratorContext t;
		public Token id;
		public DeclaratorContext d;
		public ExpressionContext e;
		public ParameterListContext p;
		public IdentifierListContext ii;
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(462);
				((DirectDeclaratorContext)_localctx).id = match(Identifier);
				 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new DirectDeclarator(); _localctx.directDeclaratorRet.setIdentifier((((DirectDeclaratorContext)_localctx).id!=null?((DirectDeclaratorContext)_localctx).id.getText():null)); _localctx.directDeclaratorRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			case LeftParen:
				{
				setState(464);
				match(LeftParen);
				setState(465);
				((DirectDeclaratorContext)_localctx).d = declarator();
				setState(466);
				match(RightParen);
				 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new DirectDeclarator(); _localctx.directDeclaratorRet.setDeclarator(((DirectDeclaratorContext)_localctx).d.declaratorRet); _localctx.directDeclaratorRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(488);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.t = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(471);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(472);
						match(LeftBracket);
						setState(474);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(473);
							((DirectDeclaratorContext)_localctx).e = expression(0);
							}
						}

						setState(476);
						match(RightBracket);
						 ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new DirectDeclarator(); _localctx.directDeclaratorRet.setDirectDeclarator(((DirectDeclaratorContext)_localctx).t.directDeclaratorRet);
						                  if (((DirectDeclaratorContext)_localctx).e != null)
						                      _localctx.directDeclaratorRet.setExpression(((DirectDeclaratorContext)_localctx).e.expressionRet); _localctx.directDeclaratorRet.setLine(_localctx.getStart().getLine());
						                
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						_localctx.t = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(478);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(479);
						match(LeftParen);
						setState(484);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(480);
							((DirectDeclaratorContext)_localctx).p = parameterList();
							}
							break;
						case 2:
							{
							setState(482);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==Identifier) {
								{
								setState(481);
								((DirectDeclaratorContext)_localctx).ii = identifierList();
								}
							}

							}
							break;
						}
						setState(486);
						match(RightParen);

						                  ((DirectDeclaratorContext)_localctx).directDeclaratorRet =  new DirectDeclarator(); _localctx.directDeclaratorRet.setDirectDeclarator(((DirectDeclaratorContext)_localctx).t.directDeclaratorRet);
						                  if (((DirectDeclaratorContext)_localctx).p != null)
						                      _localctx.directDeclaratorRet.setParameterList(((DirectDeclaratorContext)_localctx).p.parameterListRet);
						                  if (((DirectDeclaratorContext)_localctx).ii != null)
						                      _localctx.directDeclaratorRet.setIdentifierList(((DirectDeclaratorContext)_localctx).ii.identifierListRet);
						                  _localctx.directDeclaratorRet.setLine(_localctx.getStart().getLine());
						                
						}
						break;
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PointerContext extends ParserRuleContext {
		public PointerType pointerTypeRet;
		public List<TerminalNode> Star() { return getTokens(SimpleLangParser.Star); }
		public TerminalNode Star(int i) {
			return getToken(SimpleLangParser.Star, i);
		}
		public List<TerminalNode> Const() { return getTokens(SimpleLangParser.Const); }
		public TerminalNode Const(int i) {
			return getToken(SimpleLangParser.Const, i);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pointer);

		    int level = 0;
		    boolean hasConst = false;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(493);
				match(Star);
				 level++; 
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Const) {
					{
					setState(495);
					match(Const);
					 hasConst = true; 
					}
				}

				}
				}
				setState(501); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Star );
			 ((PointerContext)_localctx).pointerTypeRet =  new PointerType(level, hasConst); _localctx.pointerTypeRet.setLine(_localctx.getStart().getLine());
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public ParameterList parameterListRet;
		public ParameterDeclarationContext p;
		public ParameterDeclarationContext pp;
		public List<ParameterDeclarationContext> parameterDeclaration() {
			return getRuleContexts(ParameterDeclarationContext.class);
		}
		public ParameterDeclarationContext parameterDeclaration(int i) {
			return getRuleContext(ParameterDeclarationContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParameterListContext)_localctx).parameterListRet =  new ParameterList(); 
			setState(506);
			((ParameterListContext)_localctx).p = parameterDeclaration();
			_localctx.parameterListRet.addParameterDeclaration(((ParameterListContext)_localctx).p.parameterDeclarationRet); _localctx.parameterListRet.setLine(_localctx.getStart().getLine());
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(508);
				match(Comma);
				setState(509);
				((ParameterListContext)_localctx).pp = parameterDeclaration();
				_localctx.parameterListRet.addParameterDeclaration(((ParameterListContext)_localctx).pp.parameterDeclarationRet); _localctx.parameterListRet.setLine(_localctx.getStart().getLine());
				}
				}
				setState(516);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterDeclarationContext extends ParserRuleContext {
		public ParameterDeclaration parameterDeclarationRet;
		public DeclarationSpecifiersContext d;
		public DeclaratorContext de;
		public AbstractDeclaratorContext a;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameterDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameterDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameterDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ParameterDeclarationContext)_localctx).parameterDeclarationRet =  new ParameterDeclaration(); 
			{
			setState(518);
			((ParameterDeclarationContext)_localctx).d = declarationSpecifiers();
			 _localctx.parameterDeclarationRet.setDeclarationSpecifiers(((ParameterDeclarationContext)_localctx).d.declarationSpecifiersRet); _localctx.parameterDeclarationRet.setLine(_localctx.getStart().getLine());
			}
			setState(529);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(521);
				((ParameterDeclarationContext)_localctx).de = declarator();
				 _localctx.parameterDeclarationRet.setDeclarator(((ParameterDeclarationContext)_localctx).de.declaratorRet); _localctx.parameterDeclarationRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case 2:
				{
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
					{
					setState(524);
					((ParameterDeclarationContext)_localctx).a = abstractDeclarator();
					 _localctx.parameterDeclarationRet.setAbstractDeclarator(((ParameterDeclarationContext)_localctx).a.abstractDeclaratorRet); _localctx.parameterDeclarationRet.setLine(_localctx.getStart().getLine());
					}
				}

				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public IdentifierList identifierListRet;
		public Token id1;
		public Token id2;
		public List<TerminalNode> Identifier() { return getTokens(SimpleLangParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SimpleLangParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((IdentifierListContext)_localctx).identifierListRet =  new IdentifierList(); 
			setState(532);
			((IdentifierListContext)_localctx).id1 = match(Identifier);
			 _localctx.identifierListRet.addIdentifier((((IdentifierListContext)_localctx).id1!=null?((IdentifierListContext)_localctx).id1.getText():null)); 
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(534);
				match(Comma);
				setState(535);
				((IdentifierListContext)_localctx).id2 = match(Identifier);
				 _localctx.identifierListRet.addIdentifier((((IdentifierListContext)_localctx).id2!=null?((IdentifierListContext)_localctx).id2.getText():null)); 
				}
				}
				setState(541);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public TypeName typeNameRet;
		public SpecifierQualifierListContext s;
		public AbstractDeclaratorContext a;
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TypeNameContext)_localctx).typeNameRet =  new TypeName(); 
			setState(543);
			((TypeNameContext)_localctx).s = specifierQualifierList();
			_localctx.typeNameRet.setSpecifierQualifierList(((TypeNameContext)_localctx).s.specifierQualifierListRet); _localctx.typeNameRet.setLine(_localctx.getStart().getLine());
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549797756928L) != 0)) {
				{
				setState(545);
				((TypeNameContext)_localctx).a = abstractDeclarator();
				_localctx.typeNameRet.setAbstractDeclarator(((TypeNameContext)_localctx).a.abstractDeclaratorRet); _localctx.typeNameRet.setLine(_localctx.getStart().getLine());
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public AbstractDeclarator abstractDeclaratorRet;
		public PointerContext p;
		public PointerContext pp;
		public DirectAbstractDeclaratorContext d;
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_abstractDeclarator);
		int _la;
		try {
			setState(562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(550);
				((AbstractDeclaratorContext)_localctx).p = pointer();
				 ((AbstractDeclaratorContext)_localctx).abstractDeclaratorRet =  new AbstractDeclarator(); _localctx.abstractDeclaratorRet.addPointerType(((AbstractDeclaratorContext)_localctx).p.pointerTypeRet); _localctx.abstractDeclaratorRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				((AbstractDeclaratorContext)_localctx).abstractDeclaratorRet =  new AbstractDeclarator();
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Star) {
					{
					setState(554);
					((AbstractDeclaratorContext)_localctx).pp = pointer();
					 _localctx.abstractDeclaratorRet.addPointerType(((AbstractDeclaratorContext)_localctx).pp.pointerTypeRet); _localctx.abstractDeclaratorRet.setLine(_localctx.getStart().getLine());
					}
				}

				setState(559);
				((AbstractDeclaratorContext)_localctx).d = directAbstractDeclarator(0);
				_localctx.abstractDeclaratorRet.setDirectAbstractDeclarator(((AbstractDeclaratorContext)_localctx).d.directAbstractDeclaratorRet); _localctx.abstractDeclaratorRet.setLine(_localctx.getStart().getLine());
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

	@SuppressWarnings("CheckReturnValue")
	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public DirectAbstractDeclarator directAbstractDeclaratorRet;
		public DirectAbstractDeclaratorContext d;
		public DirectAbstractDeclaratorContext dd;
		public ExpressionContext e;
		public ExpressionContext expression;
		public AbstractDeclaratorContext a;
		public ParameterListContext p;
		public ExpressionContext e2;
		public ParameterListContext pp;
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDirectAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDirectAbstractDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDirectAbstractDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_directAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				{
				setState(565);
				match(LeftBracket);
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(566);
					((DirectAbstractDeclaratorContext)_localctx).e = ((DirectAbstractDeclaratorContext)_localctx).expression = expression(0);
					}
				}

				setState(569);
				match(RightBracket);

				        ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new DirectAbstractDeclarator();
				        if (((DirectAbstractDeclaratorContext)_localctx).expression != null) {
				            _localctx.directAbstractDeclaratorRet.setExpression(((DirectAbstractDeclaratorContext)_localctx).e.expressionRet);
				        }
				        _localctx.directAbstractDeclaratorRet.setLine(_localctx.getStart().getLine());
				      
				}
				break;
			case LeftParen:
				{
				setState(571);
				match(LeftParen);
				setState(576);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LeftParen:
				case LeftBracket:
				case Star:
					{
					setState(572);
					((DirectAbstractDeclaratorContext)_localctx).a = abstractDeclarator();
					}
					break;
				case Char:
				case Const:
				case Double:
				case Float:
				case Int:
				case Long:
				case Short:
				case Signed:
				case Typedef:
				case Unsigned:
				case Void:
				case Bool:
				case RightParen:
				case Identifier:
					{
					setState(574);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
						{
						setState(573);
						((DirectAbstractDeclaratorContext)_localctx).p = parameterList();
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(578);
				match(RightParen);

				        ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new DirectAbstractDeclarator();
				        if (((DirectAbstractDeclaratorContext)_localctx).a != null) {
				            _localctx.directAbstractDeclaratorRet.setAbstractDeclarator(((DirectAbstractDeclaratorContext)_localctx).a.abstractDeclaratorRet);
				        } else if (((DirectAbstractDeclaratorContext)_localctx).p != null) {
				            _localctx.directAbstractDeclaratorRet.setParameterList(((DirectAbstractDeclaratorContext)_localctx).p.parameterListRet);
				        }
				        _localctx.directAbstractDeclaratorRet.setLine(_localctx.getStart().getLine());
				      
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(598);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(596);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.d = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(582);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(583);
						match(LeftBracket);
						setState(585);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
							{
							setState(584);
							((DirectAbstractDeclaratorContext)_localctx).e2 = ((DirectAbstractDeclaratorContext)_localctx).expression = expression(0);
							}
						}

						setState(587);
						match(RightBracket);

						                  ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new DirectAbstractDeclarator(); _localctx.directAbstractDeclaratorRet.setDirectAbstractDeclarator(((DirectAbstractDeclaratorContext)_localctx).d.directAbstractDeclaratorRet);
						                  if (((DirectAbstractDeclaratorContext)_localctx).e2 != null)
						                      _localctx.directAbstractDeclaratorRet.setExpression(((DirectAbstractDeclaratorContext)_localctx).e2.expressionRet);
						                  _localctx.directAbstractDeclaratorRet.setLine(_localctx.getStart().getLine());
						                
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						_localctx.dd = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(589);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(590);
						match(LeftParen);
						setState(592);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6084940L) != 0) || _la==Identifier) {
							{
							setState(591);
							((DirectAbstractDeclaratorContext)_localctx).pp = parameterList();
							}
						}

						setState(594);
						match(RightParen);

						                  ((DirectAbstractDeclaratorContext)_localctx).directAbstractDeclaratorRet =  new DirectAbstractDeclarator(); _localctx.directAbstractDeclaratorRet.setDirectAbstractDeclarator(((DirectAbstractDeclaratorContext)_localctx).dd.directAbstractDeclaratorRet);
						                  if (((DirectAbstractDeclaratorContext)_localctx).pp != null)
						                      _localctx.directAbstractDeclaratorRet.setParameterList(((DirectAbstractDeclaratorContext)_localctx).pp.parameterListRet);
						                  _localctx.directAbstractDeclaratorRet.setLine(_localctx.getStart().getLine());
						                
						}
						break;
					}
					} 
				}
				setState(600);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerContext extends ParserRuleContext {
		public Initializer initializerRet;
		public ExpressionContext e;
		public InitializerListContext i;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(SimpleLangParser.Comma, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_initializer);
		int _la;
		try {
			setState(612);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(601);
				((InitializerContext)_localctx).e = expression(0);
				((InitializerContext)_localctx).initializerRet =  new Initializer(); _localctx.initializerRet.setExpression(((InitializerContext)_localctx).e.expressionRet); _localctx.initializerRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case LeftBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(604);
				match(LeftBrace);
				setState(605);
				((InitializerContext)_localctx).i = initializerList();
				setState(607);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(606);
					match(Comma);
					}
				}

				setState(609);
				match(RightBrace);
				((InitializerContext)_localctx).initializerRet =  new Initializer(); _localctx.initializerRet.setInitializerList(((InitializerContext)_localctx).i.initializerListRet); _localctx.initializerRet.setLine(_localctx.getStart().getLine());
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitializerListContext extends ParserRuleContext {
		public InitializerList initializerListRet;
		public DesignationContext d;
		public InitializerContext i;
		public DesignationContext dd;
		public InitializerContext ii;
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public List<DesignationContext> designation() {
			return getRuleContexts(DesignationContext.class);
		}
		public DesignationContext designation(int i) {
			return getRuleContext(DesignationContext.class,i);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		InitializerListContext _localctx = new InitializerListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_initializerList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 ((InitializerListContext)_localctx).initializerListRet =  new InitializerList();
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(615);
				((InitializerListContext)_localctx).d = designation();
				_localctx.initializerListRet.addDesignation(((InitializerListContext)_localctx).d.designationRet); _localctx.initializerListRet.setLine(_localctx.getStart().getLine());
				}
			}

			setState(620);
			((InitializerListContext)_localctx).i = initializer();
			_localctx.initializerListRet.addInitializer(((InitializerListContext)_localctx).i.initializerRet); _localctx.initializerListRet.setLine(_localctx.getStart().getLine());
			setState(633);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(622);
					match(Comma);
					setState(626);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(623);
						((InitializerListContext)_localctx).dd = designation();
						_localctx.initializerListRet.addDesignation(((InitializerListContext)_localctx).d.designationRet);
						}
					}

					setState(628);
					((InitializerListContext)_localctx).ii = initializer();
					_localctx.initializerListRet.addInitializer(((InitializerListContext)_localctx).i.initializerRet); _localctx.initializerListRet.setLine(_localctx.getStart().getLine());
					}
					} 
				}
				setState(635);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DesignationContext extends ParserRuleContext {
		public Designation designationRet;
		public DesignatorContext d;
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public List<DesignatorContext> designator() {
			return getRuleContexts(DesignatorContext.class);
		}
		public DesignatorContext designator(int i) {
			return getRuleContext(DesignatorContext.class,i);
		}
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_designation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((DesignationContext)_localctx).designationRet =  new Designation(); 
			setState(640); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(637);
				((DesignationContext)_localctx).d = designator();
				_localctx.designationRet.addDesignator(((DesignationContext)_localctx).d.designatorRet); _localctx.designationRet.setLine(_localctx.getStart().getLine());
				}
				}
				setState(642); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LeftBracket || _la==Dot );
			setState(644);
			match(Assign);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public Designator designatorRet;
		public ExpressionContext e;
		public TerminalNode LeftBracket() { return getToken(SimpleLangParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(SimpleLangParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Dot() { return getToken(SimpleLangParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(SimpleLangParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_designator);
		try {
			setState(654);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				 ((DesignatorContext)_localctx).designatorRet =  new Designator(); 
				setState(647);
				match(LeftBracket);
				setState(648);
				((DesignatorContext)_localctx).e = expression(0);
				_localctx.designatorRet.setExpression(((DesignatorContext)_localctx).e.expressionRet); _localctx.designatorRet.setLine(_localctx.getStart().getLine());
				setState(650);
				match(RightBracket);
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(652);
				match(Dot);
				setState(653);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement statementRet;
		public CompoundStatementContext c;
		public ExpressionStatementContext e;
		public SelectionStatementContext s;
		public IterationStatementContext i;
		public JumpStatementContext j;
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_statement);
		try {
			setState(671);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				enterOuterAlt(_localctx, 1);
				{
				setState(656);
				((StatementContext)_localctx).c = compoundStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).c.compoundStatementRet; _localctx.statementRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case Sizeof:
			case LeftParen:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case And:
			case Not:
			case Tilde:
			case Semi:
			case Identifier:
			case Constant:
			case StringLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(659);
				((StatementContext)_localctx).e = expressionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).e.expressionStatementRet; _localctx.statementRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case If:
				enterOuterAlt(_localctx, 3);
				{
				setState(662);
				((StatementContext)_localctx).s = selectionStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).s.selectionStatementRet; _localctx.statementRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case Do:
			case For:
			case While:
				enterOuterAlt(_localctx, 4);
				{
				setState(665);
				((StatementContext)_localctx).i = iterationStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).i.iterationStatementRet; _localctx.statementRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case Break:
			case Continue:
			case Return:
				enterOuterAlt(_localctx, 5);
				{
				setState(668);
				((StatementContext)_localctx).j = jumpStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).j.jumpStatementRet; _localctx.statementRet.setLine(_localctx.getStart().getLine());
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public CompoundStatement compoundStatementRet;
		public BlockItemContext b;
		public TerminalNode LeftBrace() { return getToken(SimpleLangParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(SimpleLangParser.RightBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CompoundStatementContext)_localctx).compoundStatementRet =  new CompoundStatement();
			setState(674);
			match(LeftBrace);
			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0)) {
				{
				setState(678); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(675);
					((CompoundStatementContext)_localctx).b = blockItem();
					_localctx.compoundStatementRet.addBlockItem(((CompoundStatementContext)_localctx).b.blockItemRet); _localctx.compoundStatementRet.setLine(_localctx.getStart().getLine());
					}
					}
					setState(680); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2679475628015486L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 11L) != 0) );
				}
			}

			setState(684);
			match(RightBrace);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemContext extends ParserRuleContext {
		public BlockItem blockItemRet;
		public StatementContext s;
		public DeclarationContext d;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_blockItem);
		try {
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				((BlockItemContext)_localctx).s = statement();
				((BlockItemContext)_localctx).blockItemRet =  new BlockItem(); _localctx.blockItemRet.setStatement(((BlockItemContext)_localctx).s.statementRet); _localctx.blockItemRet.setLine(_localctx.getStart().getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(689);
				((BlockItemContext)_localctx).d = declaration();
				((BlockItemContext)_localctx).blockItemRet =  new BlockItem(); _localctx.blockItemRet.setDeclaration(((BlockItemContext)_localctx).d.declarationRet); _localctx.blockItemRet.setLine(_localctx.getStart().getLine()); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionStatement expressionStatementRet;
		public ExpressionContext e;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ExpressionStatementContext)_localctx).expressionStatementRet =  new ExpressionStatement();
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(695);
				((ExpressionStatementContext)_localctx).e = expression(0);
				_localctx.expressionStatementRet.setExpression(((ExpressionStatementContext)_localctx).e.expressionRet); _localctx.expressionStatementRet.setLine(_localctx.getStart().getLine());
				}
			}

			setState(700);
			match(Semi);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectionStatementContext extends ParserRuleContext {
		public SelectionStatement selectionStatementRet;
		public ExpressionContext e;
		public StatementContext s;
		public ExpressionContext ee;
		public StatementContext sss;
		public StatementContext ss;
		public List<TerminalNode> If() { return getTokens(SimpleLangParser.If); }
		public TerminalNode If(int i) {
			return getToken(SimpleLangParser.If, i);
		}
		public List<TerminalNode> LeftParen() { return getTokens(SimpleLangParser.LeftParen); }
		public TerminalNode LeftParen(int i) {
			return getToken(SimpleLangParser.LeftParen, i);
		}
		public List<TerminalNode> RightParen() { return getTokens(SimpleLangParser.RightParen); }
		public TerminalNode RightParen(int i) {
			return getToken(SimpleLangParser.RightParen, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> Else() { return getTokens(SimpleLangParser.Else); }
		public TerminalNode Else(int i) {
			return getToken(SimpleLangParser.Else, i);
		}
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_selectionStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((SelectionStatementContext)_localctx).selectionStatementRet =  new SelectionStatement();
			setState(703);
			match(If);
			setState(704);
			match(LeftParen);
			setState(705);
			((SelectionStatementContext)_localctx).e = expression(0);
			_localctx.selectionStatementRet.addExpression(((SelectionStatementContext)_localctx).e.expressionRet); _localctx.selectionStatementRet.setLine(_localctx.getStart().getLine());
			setState(707);
			match(RightParen);
			setState(708);
			((SelectionStatementContext)_localctx).s = statement();
			_localctx.selectionStatementRet.addStatement(((SelectionStatementContext)_localctx).s.statementRet); _localctx.selectionStatementRet.setLine(_localctx.getStart().getLine());
			setState(721);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(710);
					match(Else);
					setState(711);
					match(If);
					setState(712);
					match(LeftParen);
					setState(713);
					((SelectionStatementContext)_localctx).ee = expression(0);
					 _localctx.selectionStatementRet.addExpression(((SelectionStatementContext)_localctx).ee.expressionRet);  _localctx.selectionStatementRet.setLine(_localctx.getStart().getLine()); 
					setState(715);
					match(RightParen);
					setState(716);
					((SelectionStatementContext)_localctx).sss = statement();
					_localctx.selectionStatementRet.addStatement(((SelectionStatementContext)_localctx).sss.statementRet); _localctx.selectionStatementRet.setLine(_localctx.getStart().getLine());
					}
					} 
				}
				setState(723);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			}
			setState(728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(724);
				match(Else);
				{
				setState(725);
				((SelectionStatementContext)_localctx).ss = statement();
				}
				_localctx.selectionStatementRet.addStatement(((SelectionStatementContext)_localctx).ss.statementRet); _localctx.selectionStatementRet.setLine(_localctx.getStart().getLine());
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IterationStatementContext extends ParserRuleContext {
		public IterationStatement iterationStatementRet;
		public ExpressionContext e;
		public StatementContext s;
		public StatementContext ss;
		public ExpressionContext ee;
		public ForConditionContext f;
		public StatementContext sss;
		public TerminalNode While() { return getToken(SimpleLangParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(SimpleLangParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(SimpleLangParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Do() { return getToken(SimpleLangParser.Do, 0); }
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode For() { return getToken(SimpleLangParser.For, 0); }
		public ForConditionContext forCondition() {
			return getRuleContext(ForConditionContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_iterationStatement);
		try {
			setState(756);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(730);
				match(While);
				setState(731);
				match(LeftParen);
				setState(732);
				((IterationStatementContext)_localctx).e = expression(0);
				((IterationStatementContext)_localctx).iterationStatementRet =  new IterationStatement(); _localctx.iterationStatementRet.setExpression(((IterationStatementContext)_localctx).e.expressionRet); _localctx.iterationStatementRet.setLine(_localctx.getStart().getLine()); _localctx.iterationStatementRet.setLoopType("while");
				setState(734);
				match(RightParen);
				setState(735);
				((IterationStatementContext)_localctx).s = statement();
				_localctx.iterationStatementRet.setStatement(((IterationStatementContext)_localctx).s.statementRet); _localctx.iterationStatementRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case Do:
				enterOuterAlt(_localctx, 2);
				{
				setState(738);
				match(Do);
				setState(739);
				((IterationStatementContext)_localctx).ss = statement();
				((IterationStatementContext)_localctx).iterationStatementRet =  new IterationStatement(); _localctx.iterationStatementRet.setStatement(((IterationStatementContext)_localctx).ss.statementRet); _localctx.iterationStatementRet.setLine(_localctx.getStart().getLine());
				setState(741);
				match(While);
				setState(742);
				match(LeftParen);
				setState(743);
				((IterationStatementContext)_localctx).ee = expression(0);
				_localctx.iterationStatementRet.setExpression(((IterationStatementContext)_localctx).ee.expressionRet); _localctx.iterationStatementRet.setLine(_localctx.getStart().getLine());
				setState(745);
				match(RightParen);
				setState(746);
				match(Semi);
				}
				break;
			case For:
				enterOuterAlt(_localctx, 3);
				{
				setState(748);
				match(For);
				setState(749);
				match(LeftParen);
				setState(750);
				((IterationStatementContext)_localctx).f = forCondition();
				((IterationStatementContext)_localctx).iterationStatementRet =  new IterationStatement() ;_localctx.iterationStatementRet.setForCondition(((IterationStatementContext)_localctx).f.forConditionRet); _localctx.iterationStatementRet.setLine(_localctx.getStart().getLine()); _localctx.iterationStatementRet.setLoopType("for");
				setState(752);
				match(RightParen);
				setState(753);
				((IterationStatementContext)_localctx).sss = statement();
				_localctx.iterationStatementRet.setStatement(((IterationStatementContext)_localctx).sss.statementRet); _localctx.iterationStatementRet.setLine(_localctx.getStart().getLine());
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForConditionContext extends ParserRuleContext {
		public ForCondition forConditionRet;
		public ForDeclarationContext f;
		public ExpressionContext e;
		public ForExpressionContext ff;
		public ForExpressionContext fff;
		public List<TerminalNode> Semi() { return getTokens(SimpleLangParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(SimpleLangParser.Semi, i);
		}
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public List<ForExpressionContext> forExpression() {
			return getRuleContexts(ForExpressionContext.class);
		}
		public ForExpressionContext forExpression(int i) {
			return getRuleContext(ForExpressionContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForConditionContext forCondition() throws RecognitionException {
		ForConditionContext _localctx = new ForConditionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_forCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForConditionContext)_localctx).forConditionRet =  new ForCondition();
			setState(767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				{
				setState(759);
				((ForConditionContext)_localctx).f = forDeclaration();
				_localctx.forConditionRet.setForDeclaration(((ForConditionContext)_localctx).f.forDeclarationRet); _localctx.forConditionRet.setLine(_localctx.getStart().getLine());
				}
				break;
			case 2:
				{
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
					{
					setState(762);
					((ForConditionContext)_localctx).e = expression(0);
					_localctx.forConditionRet.setExpression(((ForConditionContext)_localctx).e.expressionRet); _localctx.forConditionRet.setLine(_localctx.getStart().getLine());
					}
				}

				}
				break;
			}
			setState(769);
			match(Semi);
			setState(773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(770);
				((ForConditionContext)_localctx).ff = forExpression();
				_localctx.forConditionRet.addForExpression(((ForConditionContext)_localctx).ff.forExpressionRet); _localctx.forConditionRet.setLine(_localctx.getStart().getLine());
				}
			}

			setState(775);
			match(Semi);
			setState(779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(776);
				((ForConditionContext)_localctx).fff = forExpression();
				_localctx.forConditionRet.addForExpression(((ForConditionContext)_localctx).fff.forExpressionRet); _localctx.forConditionRet.setLine(_localctx.getStart().getLine());
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForDeclarationContext extends ParserRuleContext {
		public ForDeclaration forDeclarationRet;
		public DeclarationSpecifiersContext d;
		public InitDeclaratorListContext i;
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_forDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForDeclarationContext)_localctx).forDeclarationRet =  new ForDeclaration();
			setState(782);
			((ForDeclarationContext)_localctx).d = declarationSpecifiers();
			_localctx.forDeclarationRet.setDeclarationSpecifiers(((ForDeclarationContext)_localctx).d.declarationSpecifiersRet); _localctx.forDeclarationRet.setLine(_localctx.getStart().getLine());
			setState(787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 35184372154369L) != 0)) {
				{
				setState(784);
				((ForDeclarationContext)_localctx).i = initDeclaratorList();
				_localctx.forDeclarationRet.setInitDeclaratorList(((ForDeclarationContext)_localctx).i.initDeclaratorListRet); _localctx.forDeclarationRet.setLine(_localctx.getStart().getLine());
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForExpressionContext extends ParserRuleContext {
		public ForExpression forExpressionRet;
		public ExpressionContext e;
		public ExpressionContext ee;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public ForExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForExpressionContext forExpression() throws RecognitionException {
		ForExpressionContext _localctx = new ForExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_forExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ForExpressionContext)_localctx).forExpressionRet =  new ForExpression();
			setState(790);
			((ForExpressionContext)_localctx).e = expression(0);
			_localctx.forExpressionRet.addExpression(((ForExpressionContext)_localctx).e.expressionRet); _localctx.forExpressionRet.setLine(_localctx.getStart().getLine());
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(792);
				match(Comma);
				{
				setState(793);
				((ForExpressionContext)_localctx).ee = expression(0);
				_localctx.forExpressionRet.addExpression(((ForExpressionContext)_localctx).ee.expressionRet); _localctx.forExpressionRet.setLine(_localctx.getStart().getLine());
				}
				}
				}
				setState(800);
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

	@SuppressWarnings("CheckReturnValue")
	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatement jumpStatementRet;
		public Token key;
		public ExpressionContext e;
		public TerminalNode Semi() { return getToken(SimpleLangParser.Semi, 0); }
		public TerminalNode Continue() { return getToken(SimpleLangParser.Continue, 0); }
		public TerminalNode Break() { return getToken(SimpleLangParser.Break, 0); }
		public TerminalNode Return() { return getToken(SimpleLangParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((JumpStatementContext)_localctx).jumpStatementRet =  new JumpStatement(); 
			{
			setState(802);
			((JumpStatementContext)_localctx).key = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8210L) != 0)) ) {
				((JumpStatementContext)_localctx).key = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 16)) & ~0x3f) == 0 && ((1L << (_la - 16)) & 49539602426888321L) != 0)) {
				{
				setState(803);
				((JumpStatementContext)_localctx).e = expression(0);
				_localctx.jumpStatementRet.setExpression(((JumpStatementContext)_localctx).e.expressionRet); _localctx.jumpStatementRet.setKeyword((((JumpStatementContext)_localctx).key!=null?((JumpStatementContext)_localctx).key.getText():null)); _localctx.jumpStatementRet.setLine(_localctx.getStart().getLine());
				}
			}

			}
			setState(808);
			match(Semi);
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
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 18:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 25:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 18);
		case 13:
			return precpred(_ctx, 17);
		case 14:
			return precpred(_ctx, 16);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001M\u032b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000U\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0004"+
		"\u0001]\b\u0001\u000b\u0001\f\u0001^\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"i\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"o\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003v\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u007f\b\u0004\u000b\u0004"+
		"\f\u0004\u0080\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u008b\b\u0005\u000b\u0005"+
		"\f\u0005\u008c\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u009d\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00a2\b\u0005\n\u0005\f\u0005\u00a5"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u00ae\b\u0005\u000b\u0005\f\u0005\u00af"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00bf\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00cd\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00d5\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0121\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u012d\b\u0005\n\u0005"+
		"\f\u0005\u0130\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0139\b\u0006\n\u0006"+
		"\f\u0006\u013c\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u014a\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u0157\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u016f\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0177\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u017f\b\u000b\u000b"+
		"\u000b\f\u000b\u0180\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u018a\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0193\b\r\n\r\f\r\u0196\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u019f\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01b7\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u01be\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01c3\b"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01c9"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u01d6\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u01db"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u01e3\b\u0012\u0003\u0012\u01e5\b\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u01e9\b\u0012\n\u0012\f\u0012\u01ec\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01f2\b\u0013\u0004"+
		"\u0013\u01f4\b\u0013\u000b\u0013\f\u0013\u01f5\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u0201\b\u0014\n\u0014\f\u0014\u0204\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0210\b\u0015\u0003"+
		"\u0015\u0212\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u021a\b\u0016\n\u0016\f\u0016\u021d\t\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0225\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u022e\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0233\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0238\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u023f\b\u0019\u0003\u0019\u0241\b"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0245\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u024a\b\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0251\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u0255\b\u0019\n\u0019\f\u0019\u0258\t\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0260\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0265\b"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u026b"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u0273\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u0278\b\u001b\n\u001b\f\u001b\u027b\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0004\u001c\u0281\b\u001c\u000b\u001c\f\u001c"+
		"\u0282\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u028f"+
		"\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u02a0\b\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0004\u001f\u02a7"+
		"\b\u001f\u000b\u001f\f\u001f\u02a8\u0003\u001f\u02ab\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u02b5\b"+
		" \u0001!\u0001!\u0001!\u0001!\u0003!\u02bb\b!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u02d0\b\"\n"+
		"\"\f\"\u02d3\t\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u02d9\b\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u02f5\b#\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u02fe\b$\u0003$\u0300\b$\u0001$\u0001"+
		"$\u0001$\u0001$\u0003$\u0306\b$\u0001$\u0001$\u0001$\u0001$\u0003$\u030c"+
		"\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u0314\b%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u031d\b&\n&\f&\u0320\t&\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0327\b\'\u0001\'\u0001\'\u0001"+
		"\'\u0000\u0003\n$2(\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLN\u0000\u0007\u0003"+
		"\u0000\u0010\u0010$$&&\u0001\u0000\')\u0002\u0000##%%\u0001\u0000!\"\u0001"+
		"\u0000\u001d \u0001\u0000@A\u0003\u0000\u0001\u0001\u0004\u0004\r\r\u0381"+
		"\u0000P\u0001\u0000\u0000\u0000\u0002X\u0001\u0000\u0000\u0000\u0004h"+
		"\u0001\u0000\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\bz\u0001\u0000"+
		"\u0000\u0000\n\u00d4\u0001\u0000\u0000\u0000\f\u0131\u0001\u0000\u0000"+
		"\u0000\u000e\u0149\u0001\u0000\u0000\u0000\u0010\u0156\u0001\u0000\u0000"+
		"\u0000\u0012\u016e\u0001\u0000\u0000\u0000\u0014\u0170\u0001\u0000\u0000"+
		"\u0000\u0016\u017a\u0001\u0000\u0000\u0000\u0018\u0189\u0001\u0000\u0000"+
		"\u0000\u001a\u018b\u0001\u0000\u0000\u0000\u001c\u0197\u0001\u0000\u0000"+
		"\u0000\u001e\u01b6\u0001\u0000\u0000\u0000 \u01b8\u0001\u0000\u0000\u0000"+
		"\"\u01c4\u0001\u0000\u0000\u0000$\u01d5\u0001\u0000\u0000\u0000&\u01f3"+
		"\u0001\u0000\u0000\u0000(\u01f9\u0001\u0000\u0000\u0000*\u0205\u0001\u0000"+
		"\u0000\u0000,\u0213\u0001\u0000\u0000\u0000.\u021e\u0001\u0000\u0000\u0000"+
		"0\u0232\u0001\u0000\u0000\u00002\u0244\u0001\u0000\u0000\u00004\u0264"+
		"\u0001\u0000\u0000\u00006\u0266\u0001\u0000\u0000\u00008\u027c\u0001\u0000"+
		"\u0000\u0000:\u028e\u0001\u0000\u0000\u0000<\u029f\u0001\u0000\u0000\u0000"+
		">\u02a1\u0001\u0000\u0000\u0000@\u02b4\u0001\u0000\u0000\u0000B\u02b6"+
		"\u0001\u0000\u0000\u0000D\u02be\u0001\u0000\u0000\u0000F\u02f4\u0001\u0000"+
		"\u0000\u0000H\u02f6\u0001\u0000\u0000\u0000J\u030d\u0001\u0000\u0000\u0000"+
		"L\u0315\u0001\u0000\u0000\u0000N\u0321\u0001\u0000\u0000\u0000PT\u0006"+
		"\u0000\uffff\uffff\u0000QR\u0003\u0002\u0001\u0000RS\u0006\u0000\uffff"+
		"\uffff\u0000SU\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0005\u0000\u0000\u0001"+
		"W\u0001\u0001\u0000\u0000\u0000X\\\u0006\u0001\uffff\uffff\u0000YZ\u0003"+
		"\u0004\u0002\u0000Z[\u0006\u0001\uffff\uffff\u0000[]\u0001\u0000\u0000"+
		"\u0000\\Y\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0003\u0001\u0000\u0000\u0000"+
		"`a\u0006\u0002\uffff\uffff\u0000ab\u0003\u0006\u0003\u0000bc\u0006\u0002"+
		"\uffff\uffff\u0000ci\u0001\u0000\u0000\u0000de\u0003\u0014\n\u0000ef\u0006"+
		"\u0002\uffff\uffff\u0000fi\u0001\u0000\u0000\u0000gi\u00053\u0000\u0000"+
		"h`\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000"+
		"\u0000i\u0005\u0001\u0000\u0000\u0000jn\u0006\u0003\uffff\uffff\u0000"+
		"kl\u0003\u0016\u000b\u0000lm\u0006\u0003\uffff\uffff\u0000mo\u0001\u0000"+
		"\u0000\u0000nk\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pq\u0003\"\u0011\u0000qu\u0006\u0003\uffff\uffff\u0000"+
		"rs\u0003\b\u0004\u0000st\u0006\u0003\uffff\uffff\u0000tv\u0001\u0000\u0000"+
		"\u0000ur\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wx\u0003>\u001f\u0000xy\u0006\u0003\uffff\uffff\u0000y\u0007"+
		"\u0001\u0000\u0000\u0000z~\u0006\u0004\uffff\uffff\u0000{|\u0003\u0014"+
		"\n\u0000|}\u0006\u0004\uffff\uffff\u0000}\u007f\u0001\u0000\u0000\u0000"+
		"~{\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\t\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0006\u0005\uffff\uffff\u0000\u0083\u0084"+
		"\u0005D\u0000\u0000\u0084\u00d5\u0006\u0005\uffff\uffff\u0000\u0085\u0086"+
		"\u0005E\u0000\u0000\u0086\u00d5\u0006\u0005\uffff\uffff\u0000\u0087\u008a"+
		"\u0006\u0005\uffff\uffff\u0000\u0088\u0089\u0005G\u0000\u0000\u0089\u008b"+
		"\u0006\u0005\uffff\uffff\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0001\u0000\u0000\u0000\u008d\u00d5\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0005\u0017\u0000\u0000\u008f\u0090\u0003\n\u0005\u0000\u0090\u0091"+
		"\u0006\u0005\uffff\uffff\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0005\u0018\u0000\u0000\u0093\u00d5\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0005\u0017\u0000\u0000\u0095\u0096\u0003.\u0017\u0000\u0096\u0097"+
		"\u0006\u0005\uffff\uffff\u0000\u0097\u0098\u0005\u0018\u0000\u0000\u0098"+
		"\u0099\u0005\u001b\u0000\u0000\u0099\u009a\u00036\u001b\u0000\u009a\u009c"+
		"\u0006\u0005\uffff\uffff\u0000\u009b\u009d\u00054\u0000\u0000\u009c\u009b"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u001c\u0000\u0000\u009f\u00d5"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a2\u0007\u0000\u0000\u0000\u00a1\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00cc"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005D\u0000\u0000\u00a7\u00cd\u0006\u0005\uffff\uffff\u0000\u00a8\u00a9"+
		"\u0005E\u0000\u0000\u00a9\u00cd\u0006\u0005\uffff\uffff\u0000\u00aa\u00ad"+
		"\u0006\u0005\uffff\uffff\u0000\u00ab\u00ac\u0005G\u0000\u0000\u00ac\u00ae"+
		"\u0006\u0005\uffff\uffff\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ae"+
		"\u00af\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00cd\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005\u0017\u0000\u0000\u00b2\u00b3\u0003\n\u0005\u0000\u00b3\u00b4"+
		"\u0006\u0005\uffff\uffff\u0000\u00b4\u00b5\u0005\u0018\u0000\u0000\u00b5"+
		"\u00cd\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0017\u0000\u0000\u00b7"+
		"\u00b8\u0003.\u0017\u0000\u00b8\u00b9\u0006\u0005\uffff\uffff\u0000\u00b9"+
		"\u00ba\u0005\u0018\u0000\u0000\u00ba\u00bb\u0005\u001b\u0000\u0000\u00bb"+
		"\u00bc\u00036\u001b\u0000\u00bc\u00be\u0006\u0005\uffff\uffff\u0000\u00bd"+
		"\u00bf\u00054\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0005\u001c\u0000\u0000\u00c1\u00cd\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0003\u000e\u0007\u0000\u00c3\u00c4\u0003\u0010\b\u0000\u00c4\u00c5\u0006"+
		"\u0005\uffff\uffff\u0000\u00c5\u00cd\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0005\u0010\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8\u00c9"+
		"\u0003.\u0017\u0000\u00c9\u00ca\u0006\u0005\uffff\uffff\u0000\u00ca\u00cb"+
		"\u0005\u0018\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00a6"+
		"\u0001\u0000\u0000\u0000\u00cc\u00a8\u0001\u0000\u0000\u0000\u00cc\u00aa"+
		"\u0001\u0000\u0000\u0000\u00cc\u00b1\u0001\u0000\u0000\u0000\u00cc\u00b6"+
		"\u0001\u0000\u0000\u0000\u00cc\u00c2\u0001\u0000\u0000\u0000\u00cc\u00c6"+
		"\u0001\u0000\u0000\u0000\u00cd\u00d5\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0005\u0017\u0000\u0000\u00cf\u00d0\u0003.\u0017\u0000\u00d0\u00d1\u0005"+
		"\u0018\u0000\u0000\u00d1\u00d2\u0003\u0010\b\u0000\u00d2\u00d3\u0006\u0005"+
		"\uffff\uffff\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u0082\u0001"+
		"\u0000\u0000\u0000\u00d4\u0085\u0001\u0000\u0000\u0000\u00d4\u0087\u0001"+
		"\u0000\u0000\u0000\u00d4\u008e\u0001\u0000\u0000\u0000\u00d4\u0094\u0001"+
		"\u0000\u0000\u0000\u00d4\u00a3\u0001\u0000\u0000\u0000\u00d4\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d5\u012e\u0001\u0000\u0000\u0000\u00d6\u00d7\n\f"+
		"\u0000\u0000\u00d7\u00d8\u0007\u0001\u0000\u0000\u00d8\u00d9\u0003\n\u0005"+
		"\r\u00d9\u00da\u0006\u0005\uffff\uffff\u0000\u00da\u012d\u0001\u0000\u0000"+
		"\u0000\u00db\u00dc\n\u000b\u0000\u0000\u00dc\u00dd\u0007\u0002\u0000\u0000"+
		"\u00dd\u00de\u0003\n\u0005\f\u00de\u00df\u0006\u0005\uffff\uffff\u0000"+
		"\u00df\u012d\u0001\u0000\u0000\u0000\u00e0\u00e1\n\n\u0000\u0000\u00e1"+
		"\u00e2\u0007\u0003\u0000\u0000\u00e2\u00e3\u0003\n\u0005\u000b\u00e3\u00e4"+
		"\u0006\u0005\uffff\uffff\u0000\u00e4\u012d\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e6\n\t\u0000\u0000\u00e6\u00e7\u0007\u0004\u0000\u0000\u00e7\u00e8"+
		"\u0003\n\u0005\n\u00e8\u00e9\u0006\u0005\uffff\uffff\u0000\u00e9\u012d"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\n\b\u0000\u0000\u00eb\u00ec\u0007"+
		"\u0005\u0000\u0000\u00ec\u00ed\u0003\n\u0005\t\u00ed\u00ee\u0006\u0005"+
		"\uffff\uffff\u0000\u00ee\u012d\u0001\u0000\u0000\u0000\u00ef\u00f0\n\u0007"+
		"\u0000\u0000\u00f0\u00f1\u0005*\u0000\u0000\u00f1\u00f2\u0003\n\u0005"+
		"\b\u00f2\u00f3\u0006\u0005\uffff\uffff\u0000\u00f3\u012d\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\n\u0006\u0000\u0000\u00f5\u00f6\u0005.\u0000\u0000"+
		"\u00f6\u00f7\u0003\n\u0005\u0007\u00f7\u00f8\u0006\u0005\uffff\uffff\u0000"+
		"\u00f8\u012d\u0001\u0000\u0000\u0000\u00f9\u00fa\n\u0005\u0000\u0000\u00fa"+
		"\u00fb\u0005+\u0000\u0000\u00fb\u00fc\u0003\n\u0005\u0006\u00fc\u00fd"+
		"\u0006\u0005\uffff\uffff\u0000\u00fd\u012d\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\n\u0004\u0000\u0000\u00ff\u0100\u0005,\u0000\u0000\u0100\u0101"+
		"\u0003\n\u0005\u0005\u0101\u0102\u0006\u0005\uffff\uffff\u0000\u0102\u012d"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\n\u0003\u0000\u0000\u0104\u0105\u0005"+
		"-\u0000\u0000\u0105\u0106\u0003\n\u0005\u0004\u0106\u0107\u0006\u0005"+
		"\uffff\uffff\u0000\u0107\u012d\u0001\u0000\u0000\u0000\u0108\u0109\n\u0002"+
		"\u0000\u0000\u0109\u010a\u00051\u0000\u0000\u010a\u010b\u0003\n\u0005"+
		"\u0000\u010b\u010c\u00052\u0000\u0000\u010c\u010d\u0003\n\u0005\u0003"+
		"\u010d\u010e\u0006\u0005\uffff\uffff\u0000\u010e\u012d\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\n\u0001\u0000\u0000\u0110\u0111\u0003\u0012\t\u0000"+
		"\u0111\u0112\u0003\n\u0005\u0002\u0112\u0113\u0006\u0005\uffff\uffff\u0000"+
		"\u0113\u012d\u0001\u0000\u0000\u0000\u0114\u0115\n\u0012\u0000\u0000\u0115"+
		"\u0116\u0005\u0019\u0000\u0000\u0116\u0117\u0003\n\u0005\u0000\u0117\u0118"+
		"\u0005\u001a\u0000\u0000\u0118\u0119\u0006\u0005\uffff\uffff\u0000\u0119"+
		"\u012d\u0001\u0000\u0000\u0000\u011a\u011b\n\u0011\u0000\u0000\u011b\u011c"+
		"\u0006\u0005\uffff\uffff\u0000\u011c\u0120\u0005\u0017\u0000\u0000\u011d"+
		"\u011e\u0003\f\u0006\u0000\u011e\u011f\u0006\u0005\uffff\uffff\u0000\u011f"+
		"\u0121\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0005\u0018\u0000\u0000\u0123\u012d\u0006\u0005\uffff\uffff\u0000"+
		"\u0124\u0125\n\u0010\u0000\u0000\u0125\u0126\u0006\u0005\uffff\uffff\u0000"+
		"\u0126\u0127\u0005$\u0000\u0000\u0127\u012d\u0006\u0005\uffff\uffff\u0000"+
		"\u0128\u0129\n\u000f\u0000\u0000\u0129\u012a\u0006\u0005\uffff\uffff\u0000"+
		"\u012a\u012b\u0005&\u0000\u0000\u012b\u012d\u0006\u0005\uffff\uffff\u0000"+
		"\u012c\u00d6\u0001\u0000\u0000\u0000\u012c\u00db\u0001\u0000\u0000\u0000"+
		"\u012c\u00e0\u0001\u0000\u0000\u0000\u012c\u00e5\u0001\u0000\u0000\u0000"+
		"\u012c\u00ea\u0001\u0000\u0000\u0000\u012c\u00ef\u0001\u0000\u0000\u0000"+
		"\u012c\u00f4\u0001\u0000\u0000\u0000\u012c\u00f9\u0001\u0000\u0000\u0000"+
		"\u012c\u00fe\u0001\u0000\u0000\u0000\u012c\u0103\u0001\u0000\u0000\u0000"+
		"\u012c\u0108\u0001\u0000\u0000\u0000\u012c\u010f\u0001\u0000\u0000\u0000"+
		"\u012c\u0114\u0001\u0000\u0000\u0000\u012c\u011a\u0001\u0000\u0000\u0000"+
		"\u012c\u0124\u0001\u0000\u0000\u0000\u012c\u0128\u0001\u0000\u0000\u0000"+
		"\u012d\u0130\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000"+
		"\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u000b\u0001\u0000\u0000\u0000"+
		"\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0132\u0006\u0006\uffff\uffff"+
		"\u0000\u0132\u0133\u0003\n\u0005\u0000\u0133\u013a\u0006\u0006\uffff\uffff"+
		"\u0000\u0134\u0135\u00054\u0000\u0000\u0135\u0136\u0003\n\u0005\u0000"+
		"\u0136\u0137\u0006\u0006\uffff\uffff\u0000\u0137\u0139\u0001\u0000\u0000"+
		"\u0000\u0138\u0134\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000"+
		"\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000"+
		"\u0000\u013b\r\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000"+
		"\u013d\u013e\u0005*\u0000\u0000\u013e\u014a\u0006\u0007\uffff\uffff\u0000"+
		"\u013f\u0140\u0005\'\u0000\u0000\u0140\u014a\u0006\u0007\uffff\uffff\u0000"+
		"\u0141\u0142\u0005#\u0000\u0000\u0142\u014a\u0006\u0007\uffff\uffff\u0000"+
		"\u0143\u0144\u0005%\u0000\u0000\u0144\u014a\u0006\u0007\uffff\uffff\u0000"+
		"\u0145\u0146\u00050\u0000\u0000\u0146\u014a\u0006\u0007\uffff\uffff\u0000"+
		"\u0147\u0148\u0005/\u0000\u0000\u0148\u014a\u0006\u0007\uffff\uffff\u0000"+
		"\u0149\u013d\u0001\u0000\u0000\u0000\u0149\u013f\u0001\u0000\u0000\u0000"+
		"\u0149\u0141\u0001\u0000\u0000\u0000\u0149\u0143\u0001\u0000\u0000\u0000"+
		"\u0149\u0145\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000"+
		"\u014a\u000f\u0001\u0000\u0000\u0000\u014b\u014c\u0005\u0017\u0000\u0000"+
		"\u014c\u014d\u0003.\u0017\u0000\u014d\u014e\u0006\b\uffff\uffff\u0000"+
		"\u014e\u014f\u0005\u0018\u0000\u0000\u014f\u0150\u0003\u0010\b\u0000\u0150"+
		"\u0151\u0006\b\uffff\uffff\u0000\u0151\u0157\u0001\u0000\u0000\u0000\u0152"+
		"\u0153\u0003\n\u0005\u0000\u0153\u0154\u0006\b\uffff\uffff\u0000\u0154"+
		"\u0157\u0001\u0000\u0000\u0000\u0155\u0157\u0005F\u0000\u0000\u0156\u014b"+
		"\u0001\u0000\u0000\u0000\u0156\u0152\u0001\u0000\u0000\u0000\u0156\u0155"+
		"\u0001\u0000\u0000\u0000\u0157\u0011\u0001\u0000\u0000\u0000\u0158\u0159"+
		"\u00055\u0000\u0000\u0159\u016f\u0006\t\uffff\uffff\u0000\u015a\u015b"+
		"\u00056\u0000\u0000\u015b\u016f\u0006\t\uffff\uffff\u0000\u015c\u015d"+
		"\u00057\u0000\u0000\u015d\u016f\u0006\t\uffff\uffff\u0000\u015e\u015f"+
		"\u00058\u0000\u0000\u015f\u016f\u0006\t\uffff\uffff\u0000\u0160\u0161"+
		"\u00059\u0000\u0000\u0161\u016f\u0006\t\uffff\uffff\u0000\u0162\u0163"+
		"\u0005:\u0000\u0000\u0163\u016f\u0006\t\uffff\uffff\u0000\u0164\u0165"+
		"\u0005;\u0000\u0000\u0165\u016f\u0006\t\uffff\uffff\u0000\u0166\u0167"+
		"\u0005<\u0000\u0000\u0167\u016f\u0006\t\uffff\uffff\u0000\u0168\u0169"+
		"\u0005=\u0000\u0000\u0169\u016f\u0006\t\uffff\uffff\u0000\u016a\u016b"+
		"\u0005>\u0000\u0000\u016b\u016f\u0006\t\uffff\uffff\u0000\u016c\u016d"+
		"\u0005?\u0000\u0000\u016d\u016f\u0006\t\uffff\uffff\u0000\u016e\u0158"+
		"\u0001\u0000\u0000\u0000\u016e\u015a\u0001\u0000\u0000\u0000\u016e\u015c"+
		"\u0001\u0000\u0000\u0000\u016e\u015e\u0001\u0000\u0000\u0000\u016e\u0160"+
		"\u0001\u0000\u0000\u0000\u016e\u0162\u0001\u0000\u0000\u0000\u016e\u0164"+
		"\u0001\u0000\u0000\u0000\u016e\u0166\u0001\u0000\u0000\u0000\u016e\u0168"+
		"\u0001\u0000\u0000\u0000\u016e\u016a\u0001\u0000\u0000\u0000\u016e\u016c"+
		"\u0001\u0000\u0000\u0000\u016f\u0013\u0001\u0000\u0000\u0000\u0170\u0171"+
		"\u0006\n\uffff\uffff\u0000\u0171\u0172\u0003\u0016\u000b\u0000\u0172\u0176"+
		"\u0006\n\uffff\uffff\u0000\u0173\u0174\u0003\u001a\r\u0000\u0174\u0175"+
		"\u0006\n\uffff\uffff\u0000\u0175\u0177\u0001\u0000\u0000\u0000\u0176\u0173"+
		"\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178"+
		"\u0001\u0000\u0000\u0000\u0178\u0179\u00053\u0000\u0000\u0179\u0015\u0001"+
		"\u0000\u0000\u0000\u017a\u017e\u0006\u000b\uffff\uffff\u0000\u017b\u017c"+
		"\u0003\u0018\f\u0000\u017c\u017d\u0006\u000b\uffff\uffff\u0000\u017d\u017f"+
		"\u0001\u0000\u0000\u0000\u017e\u017b\u0001\u0000\u0000\u0000\u017f\u0180"+
		"\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181"+
		"\u0001\u0000\u0000\u0000\u0181\u0017\u0001\u0000\u0000\u0000\u0182\u0183"+
		"\u0005\u0012\u0000\u0000\u0183\u018a\u0006\f\uffff\uffff\u0000\u0184\u0185"+
		"\u0003\u001e\u000f\u0000\u0185\u0186\u0006\f\uffff\uffff\u0000\u0186\u018a"+
		"\u0001\u0000\u0000\u0000\u0187\u0188\u0005\u0003\u0000\u0000\u0188\u018a"+
		"\u0006\f\uffff\uffff\u0000\u0189\u0182\u0001\u0000\u0000\u0000\u0189\u0184"+
		"\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u018a\u0019"+
		"\u0001\u0000\u0000\u0000\u018b\u018c\u0006\r\uffff\uffff\u0000\u018c\u018d"+
		"\u0003\u001c\u000e\u0000\u018d\u0194\u0006\r\uffff\uffff\u0000\u018e\u018f"+
		"\u00054\u0000\u0000\u018f\u0190\u0003\u001c\u000e\u0000\u0190\u0191\u0006"+
		"\r\uffff\uffff\u0000\u0191\u0193\u0001\u0000\u0000\u0000\u0192\u018e\u0001"+
		"\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000\u0000\u0194\u0192\u0001"+
		"\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u001b\u0001"+
		"\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197\u0198\u0006"+
		"\u000e\uffff\uffff\u0000\u0198\u0199\u0003\"\u0011\u0000\u0199\u019e\u0006"+
		"\u000e\uffff\uffff\u0000\u019a\u019b\u00055\u0000\u0000\u019b\u019c\u0003"+
		"4\u001a\u0000\u019c\u019d\u0006\u000e\uffff\uffff\u0000\u019d\u019f\u0001"+
		"\u0000\u0000\u0000\u019e\u019a\u0001\u0000\u0000\u0000\u019e\u019f\u0001"+
		"\u0000\u0000\u0000\u019f\u001d\u0001\u0000\u0000\u0000\u01a0\u01a1\u0005"+
		"\u0014\u0000\u0000\u01a1\u01b7\u0006\u000f\uffff\uffff\u0000\u01a2\u01a3"+
		"\u0005\u0002\u0000\u0000\u01a3\u01b7\u0006\u000f\uffff\uffff\u0000\u01a4"+
		"\u01a5\u0005\u000e\u0000\u0000\u01a5\u01b7\u0006\u000f\uffff\uffff\u0000"+
		"\u01a6\u01a7\u0005\u000b\u0000\u0000\u01a7\u01b7\u0006\u000f\uffff\uffff"+
		"\u0000\u01a8\u01a9\u0005\f\u0000\u0000\u01a9\u01b7\u0006\u000f\uffff\uffff"+
		"\u0000\u01aa\u01ab\u0005\b\u0000\u0000\u01ab\u01b7\u0006\u000f\uffff\uffff"+
		"\u0000\u01ac\u01ad\u0005\u0006\u0000\u0000\u01ad\u01b7\u0006\u000f\uffff"+
		"\uffff\u0000\u01ae\u01af\u0005\u000f\u0000\u0000\u01af\u01b7\u0006\u000f"+
		"\uffff\uffff\u0000\u01b0\u01b1\u0005\u0013\u0000\u0000\u01b1\u01b7\u0006"+
		"\u000f\uffff\uffff\u0000\u01b2\u01b3\u0005\u0016\u0000\u0000\u01b3\u01b7"+
		"\u0006\u000f\uffff\uffff\u0000\u01b4\u01b5\u0005D\u0000\u0000\u01b5\u01b7"+
		"\u0006\u000f\uffff\uffff\u0000\u01b6\u01a0\u0001\u0000\u0000\u0000\u01b6"+
		"\u01a2\u0001\u0000\u0000\u0000\u01b6\u01a4\u0001\u0000\u0000\u0000\u01b6"+
		"\u01a6\u0001\u0000\u0000\u0000\u01b6\u01a8\u0001\u0000\u0000\u0000\u01b6"+
		"\u01aa\u0001\u0000\u0000\u0000\u01b6\u01ac\u0001\u0000\u0000\u0000\u01b6"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b6\u01b0\u0001\u0000\u0000\u0000\u01b6"+
		"\u01b2\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7"+
		"\u001f\u0001\u0000\u0000\u0000\u01b8\u01bd\u0006\u0010\uffff\uffff\u0000"+
		"\u01b9\u01ba\u0003\u001e\u000f\u0000\u01ba\u01bb\u0006\u0010\uffff\uffff"+
		"\u0000\u01bb\u01be\u0001\u0000\u0000\u0000\u01bc\u01be\u0005\u0003\u0000"+
		"\u0000\u01bd\u01b9\u0001\u0000\u0000\u0000\u01bd\u01bc\u0001\u0000\u0000"+
		"\u0000\u01be\u01c2\u0001\u0000\u0000\u0000\u01bf\u01c0\u0003 \u0010\u0000"+
		"\u01c0\u01c1\u0006\u0010\uffff\uffff\u0000\u01c1\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c2\u01bf\u0001\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c3!\u0001\u0000\u0000\u0000\u01c4\u01c8\u0006\u0011\uffff\uffff"+
		"\u0000\u01c5\u01c6\u0003&\u0013\u0000\u01c6\u01c7\u0006\u0011\uffff\uffff"+
		"\u0000\u01c7\u01c9\u0001\u0000\u0000\u0000\u01c8\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000"+
		"\u0000\u01ca\u01cb\u0003$\u0012\u0000\u01cb\u01cc\u0006\u0011\uffff\uffff"+
		"\u0000\u01cc#\u0001\u0000\u0000\u0000\u01cd\u01ce\u0006\u0012\uffff\uffff"+
		"\u0000\u01ce\u01cf\u0005D\u0000\u0000\u01cf\u01d6\u0006\u0012\uffff\uffff"+
		"\u0000\u01d0\u01d1\u0005\u0017\u0000\u0000\u01d1\u01d2\u0003\"\u0011\u0000"+
		"\u01d2\u01d3\u0005\u0018\u0000\u0000\u01d3\u01d4\u0006\u0012\uffff\uffff"+
		"\u0000\u01d4\u01d6\u0001\u0000\u0000\u0000\u01d5\u01cd\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d0\u0001\u0000\u0000\u0000\u01d6\u01ea\u0001\u0000\u0000"+
		"\u0000\u01d7\u01d8\n\u0002\u0000\u0000\u01d8\u01da\u0005\u0019\u0000\u0000"+
		"\u01d9\u01db\u0003\n\u0005\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da"+
		"\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0005\u001a\u0000\u0000\u01dd\u01e9\u0006\u0012\uffff\uffff\u0000"+
		"\u01de\u01df\n\u0001\u0000\u0000\u01df\u01e4\u0005\u0017\u0000\u0000\u01e0"+
		"\u01e5\u0003(\u0014\u0000\u01e1\u01e3\u0003,\u0016\u0000\u01e2\u01e1\u0001"+
		"\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000\u0000\u01e3\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e4\u01e0\u0001\u0000\u0000\u0000\u01e4\u01e2\u0001"+
		"\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e7\u0005"+
		"\u0018\u0000\u0000\u01e7\u01e9\u0006\u0012\uffff\uffff\u0000\u01e8\u01d7"+
		"\u0001\u0000\u0000\u0000\u01e8\u01de\u0001\u0000\u0000\u0000\u01e9\u01ec"+
		"\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000\u01ea\u01eb"+
		"\u0001\u0000\u0000\u0000\u01eb%\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001"+
		"\u0000\u0000\u0000\u01ed\u01ee\u0005\'\u0000\u0000\u01ee\u01f1\u0006\u0013"+
		"\uffff\uffff\u0000\u01ef\u01f0\u0005\u0003\u0000\u0000\u01f0\u01f2\u0006"+
		"\u0013\uffff\uffff\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f1\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f2\u01f4\u0001\u0000\u0000\u0000\u01f3\u01ed"+
		"\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6\u01f7"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f8\u0006\u0013\uffff\uffff\u0000\u01f8"+
		"\'\u0001\u0000\u0000\u0000\u01f9\u01fa\u0006\u0014\uffff\uffff\u0000\u01fa"+
		"\u01fb\u0003*\u0015\u0000\u01fb\u0202\u0006\u0014\uffff\uffff\u0000\u01fc"+
		"\u01fd\u00054\u0000\u0000\u01fd\u01fe\u0003*\u0015\u0000\u01fe\u01ff\u0006"+
		"\u0014\uffff\uffff\u0000\u01ff\u0201\u0001\u0000\u0000\u0000\u0200\u01fc"+
		"\u0001\u0000\u0000\u0000\u0201\u0204\u0001\u0000\u0000\u0000\u0202\u0200"+
		"\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203)\u0001"+
		"\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000\u0205\u0206\u0006"+
		"\u0015\uffff\uffff\u0000\u0206\u0207\u0003\u0016\u000b\u0000\u0207\u0208"+
		"\u0006\u0015\uffff\uffff\u0000\u0208\u0211\u0001\u0000\u0000\u0000\u0209"+
		"\u020a\u0003\"\u0011\u0000\u020a\u020b\u0006\u0015\uffff\uffff\u0000\u020b"+
		"\u0212\u0001\u0000\u0000\u0000\u020c\u020d\u00030\u0018\u0000\u020d\u020e"+
		"\u0006\u0015\uffff\uffff\u0000\u020e\u0210\u0001\u0000\u0000\u0000\u020f"+
		"\u020c\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000\u0210"+
		"\u0212\u0001\u0000\u0000\u0000\u0211\u0209\u0001\u0000\u0000\u0000\u0211"+
		"\u020f\u0001\u0000\u0000\u0000\u0212+\u0001\u0000\u0000\u0000\u0213\u0214"+
		"\u0006\u0016\uffff\uffff\u0000\u0214\u0215\u0005D\u0000\u0000\u0215\u021b"+
		"\u0006\u0016\uffff\uffff\u0000\u0216\u0217\u00054\u0000\u0000\u0217\u0218"+
		"\u0005D\u0000\u0000\u0218\u021a\u0006\u0016\uffff\uffff\u0000\u0219\u0216"+
		"\u0001\u0000\u0000\u0000\u021a\u021d\u0001\u0000\u0000\u0000\u021b\u0219"+
		"\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c-\u0001"+
		"\u0000\u0000\u0000\u021d\u021b\u0001\u0000\u0000\u0000\u021e\u021f\u0006"+
		"\u0017\uffff\uffff\u0000\u021f\u0220\u0003 \u0010\u0000\u0220\u0224\u0006"+
		"\u0017\uffff\uffff\u0000\u0221\u0222\u00030\u0018\u0000\u0222\u0223\u0006"+
		"\u0017\uffff\uffff\u0000\u0223\u0225\u0001\u0000\u0000\u0000\u0224\u0221"+
		"\u0001\u0000\u0000\u0000\u0224\u0225\u0001\u0000\u0000\u0000\u0225/\u0001"+
		"\u0000\u0000\u0000\u0226\u0227\u0003&\u0013\u0000\u0227\u0228\u0006\u0018"+
		"\uffff\uffff\u0000\u0228\u0233\u0001\u0000\u0000\u0000\u0229\u022d\u0006"+
		"\u0018\uffff\uffff\u0000\u022a\u022b\u0003&\u0013\u0000\u022b\u022c\u0006"+
		"\u0018\uffff\uffff\u0000\u022c\u022e\u0001\u0000\u0000\u0000\u022d\u022a"+
		"\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u022f"+
		"\u0001\u0000\u0000\u0000\u022f\u0230\u00032\u0019\u0000\u0230\u0231\u0006"+
		"\u0018\uffff\uffff\u0000\u0231\u0233\u0001\u0000\u0000\u0000\u0232\u0226"+
		"\u0001\u0000\u0000\u0000\u0232\u0229\u0001\u0000\u0000\u0000\u02331\u0001"+
		"\u0000\u0000\u0000\u0234\u0235\u0006\u0019\uffff\uffff\u0000\u0235\u0237"+
		"\u0005\u0019\u0000\u0000\u0236\u0238\u0003\n\u0005\u0000\u0237\u0236\u0001"+
		"\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238\u0239\u0001"+
		"\u0000\u0000\u0000\u0239\u023a\u0005\u001a\u0000\u0000\u023a\u0245\u0006"+
		"\u0019\uffff\uffff\u0000\u023b\u0240\u0005\u0017\u0000\u0000\u023c\u0241"+
		"\u00030\u0018\u0000\u023d\u023f\u0003(\u0014\u0000\u023e\u023d\u0001\u0000"+
		"\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0241\u0001\u0000"+
		"\u0000\u0000\u0240\u023c\u0001\u0000\u0000\u0000\u0240\u023e\u0001\u0000"+
		"\u0000\u0000\u0241\u0242\u0001\u0000\u0000\u0000\u0242\u0243\u0005\u0018"+
		"\u0000\u0000\u0243\u0245\u0006\u0019\uffff\uffff\u0000\u0244\u0234\u0001"+
		"\u0000\u0000\u0000\u0244\u023b\u0001\u0000\u0000\u0000\u0245\u0256\u0001"+
		"\u0000\u0000\u0000\u0246\u0247\n\u0002\u0000\u0000\u0247\u0249\u0005\u0019"+
		"\u0000\u0000\u0248\u024a\u0003\n\u0005\u0000\u0249\u0248\u0001\u0000\u0000"+
		"\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024b\u0001\u0000\u0000"+
		"\u0000\u024b\u024c\u0005\u001a\u0000\u0000\u024c\u0255\u0006\u0019\uffff"+
		"\uffff\u0000\u024d\u024e\n\u0001\u0000\u0000\u024e\u0250\u0005\u0017\u0000"+
		"\u0000\u024f\u0251\u0003(\u0014\u0000\u0250\u024f\u0001\u0000\u0000\u0000"+
		"\u0250\u0251\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000"+
		"\u0252\u0253\u0005\u0018\u0000\u0000\u0253\u0255\u0006\u0019\uffff\uffff"+
		"\u0000\u0254\u0246\u0001\u0000\u0000\u0000\u0254\u024d\u0001\u0000\u0000"+
		"\u0000\u0255\u0258\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000"+
		"\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u02573\u0001\u0000\u0000\u0000"+
		"\u0258\u0256\u0001\u0000\u0000\u0000\u0259\u025a\u0003\n\u0005\u0000\u025a"+
		"\u025b\u0006\u001a\uffff\uffff\u0000\u025b\u0265\u0001\u0000\u0000\u0000"+
		"\u025c\u025d\u0005\u001b\u0000\u0000\u025d\u025f\u00036\u001b\u0000\u025e"+
		"\u0260\u00054\u0000\u0000\u025f\u025e\u0001\u0000\u0000\u0000\u025f\u0260"+
		"\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u0262"+
		"\u0005\u001c\u0000\u0000\u0262\u0263\u0006\u001a\uffff\uffff\u0000\u0263"+
		"\u0265\u0001\u0000\u0000\u0000\u0264\u0259\u0001\u0000\u0000\u0000\u0264"+
		"\u025c\u0001\u0000\u0000\u0000\u02655\u0001\u0000\u0000\u0000\u0266\u026a"+
		"\u0006\u001b\uffff\uffff\u0000\u0267\u0268\u00038\u001c\u0000\u0268\u0269"+
		"\u0006\u001b\uffff\uffff\u0000\u0269\u026b\u0001\u0000\u0000\u0000\u026a"+
		"\u0267\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b"+
		"\u026c\u0001\u0000\u0000\u0000\u026c\u026d\u00034\u001a\u0000\u026d\u0279"+
		"\u0006\u001b\uffff\uffff\u0000\u026e\u0272\u00054\u0000\u0000\u026f\u0270"+
		"\u00038\u001c\u0000\u0270\u0271\u0006\u001b\uffff\uffff\u0000\u0271\u0273"+
		"\u0001\u0000\u0000\u0000\u0272\u026f\u0001\u0000\u0000\u0000\u0272\u0273"+
		"\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000\u0000\u0000\u0274\u0275"+
		"\u00034\u001a\u0000\u0275\u0276\u0006\u001b\uffff\uffff\u0000\u0276\u0278"+
		"\u0001\u0000\u0000\u0000\u0277\u026e\u0001\u0000\u0000\u0000\u0278\u027b"+
		"\u0001\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u0279\u027a"+
		"\u0001\u0000\u0000\u0000\u027a7\u0001\u0000\u0000\u0000\u027b\u0279\u0001"+
		"\u0000\u0000\u0000\u027c\u0280\u0006\u001c\uffff\uffff\u0000\u027d\u027e"+
		"\u0003:\u001d\u0000\u027e\u027f\u0006\u001c\uffff\uffff\u0000\u027f\u0281"+
		"\u0001\u0000\u0000\u0000\u0280\u027d\u0001\u0000\u0000\u0000\u0281\u0282"+
		"\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283"+
		"\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000\u0284\u0285"+
		"\u00055\u0000\u0000\u02859\u0001\u0000\u0000\u0000\u0286\u0287\u0006\u001d"+
		"\uffff\uffff\u0000\u0287\u0288\u0005\u0019\u0000\u0000\u0288\u0289\u0003"+
		"\n\u0005\u0000\u0289\u028a\u0006\u001d\uffff\uffff\u0000\u028a\u028b\u0005"+
		"\u001a\u0000\u0000\u028b\u028f\u0001\u0000\u0000\u0000\u028c\u028d\u0005"+
		"C\u0000\u0000\u028d\u028f\u0005D\u0000\u0000\u028e\u0286\u0001\u0000\u0000"+
		"\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028f;\u0001\u0000\u0000\u0000"+
		"\u0290\u0291\u0003>\u001f\u0000\u0291\u0292\u0006\u001e\uffff\uffff\u0000"+
		"\u0292\u02a0\u0001\u0000\u0000\u0000\u0293\u0294\u0003B!\u0000\u0294\u0295"+
		"\u0006\u001e\uffff\uffff\u0000\u0295\u02a0\u0001\u0000\u0000\u0000\u0296"+
		"\u0297\u0003D\"\u0000\u0297\u0298\u0006\u001e\uffff\uffff\u0000\u0298"+
		"\u02a0\u0001\u0000\u0000\u0000\u0299\u029a\u0003F#\u0000\u029a\u029b\u0006"+
		"\u001e\uffff\uffff\u0000\u029b\u02a0\u0001\u0000\u0000\u0000\u029c\u029d"+
		"\u0003N\'\u0000\u029d\u029e\u0006\u001e\uffff\uffff\u0000\u029e\u02a0"+
		"\u0001\u0000\u0000\u0000\u029f\u0290\u0001\u0000\u0000\u0000\u029f\u0293"+
		"\u0001\u0000\u0000\u0000\u029f\u0296\u0001\u0000\u0000\u0000\u029f\u0299"+
		"\u0001\u0000\u0000\u0000\u029f\u029c\u0001\u0000\u0000\u0000\u02a0=\u0001"+
		"\u0000\u0000\u0000\u02a1\u02a2\u0006\u001f\uffff\uffff\u0000\u02a2\u02aa"+
		"\u0005\u001b\u0000\u0000\u02a3\u02a4\u0003@ \u0000\u02a4\u02a5\u0006\u001f"+
		"\uffff\uffff\u0000\u02a5\u02a7\u0001\u0000\u0000\u0000\u02a6\u02a3\u0001"+
		"\u0000\u0000\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000\u0000\u02a9\u02ab\u0001"+
		"\u0000\u0000\u0000\u02aa\u02a6\u0001\u0000\u0000\u0000\u02aa\u02ab\u0001"+
		"\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02ad\u0005"+
		"\u001c\u0000\u0000\u02ad?\u0001\u0000\u0000\u0000\u02ae\u02af\u0003<\u001e"+
		"\u0000\u02af\u02b0\u0006 \uffff\uffff\u0000\u02b0\u02b5\u0001\u0000\u0000"+
		"\u0000\u02b1\u02b2\u0003\u0014\n\u0000\u02b2\u02b3\u0006 \uffff\uffff"+
		"\u0000\u02b3\u02b5\u0001\u0000\u0000\u0000\u02b4\u02ae\u0001\u0000\u0000"+
		"\u0000\u02b4\u02b1\u0001\u0000\u0000\u0000\u02b5A\u0001\u0000\u0000\u0000"+
		"\u02b6\u02ba\u0006!\uffff\uffff\u0000\u02b7\u02b8\u0003\n\u0005\u0000"+
		"\u02b8\u02b9\u0006!\uffff\uffff\u0000\u02b9\u02bb\u0001\u0000\u0000\u0000"+
		"\u02ba\u02b7\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000"+
		"\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc\u02bd\u00053\u0000\u0000\u02bd"+
		"C\u0001\u0000\u0000\u0000\u02be\u02bf\u0006\"\uffff\uffff\u0000\u02bf"+
		"\u02c0\u0005\n\u0000\u0000\u02c0\u02c1\u0005\u0017\u0000\u0000\u02c1\u02c2"+
		"\u0003\n\u0005\u0000\u02c2\u02c3\u0006\"\uffff\uffff\u0000\u02c3\u02c4"+
		"\u0005\u0018\u0000\u0000\u02c4\u02c5\u0003<\u001e\u0000\u02c5\u02d1\u0006"+
		"\"\uffff\uffff\u0000\u02c6\u02c7\u0005\u0007\u0000\u0000\u02c7\u02c8\u0005"+
		"\n\u0000\u0000\u02c8\u02c9\u0005\u0017\u0000\u0000\u02c9\u02ca\u0003\n"+
		"\u0005\u0000\u02ca\u02cb\u0006\"\uffff\uffff\u0000\u02cb\u02cc\u0005\u0018"+
		"\u0000\u0000\u02cc\u02cd\u0003<\u001e\u0000\u02cd\u02ce\u0006\"\uffff"+
		"\uffff\u0000\u02ce\u02d0\u0001\u0000\u0000\u0000\u02cf\u02c6\u0001\u0000"+
		"\u0000\u0000\u02d0\u02d3\u0001\u0000\u0000\u0000\u02d1\u02cf\u0001\u0000"+
		"\u0000\u0000\u02d1\u02d2\u0001\u0000\u0000\u0000\u02d2\u02d8\u0001\u0000"+
		"\u0000\u0000\u02d3\u02d1\u0001\u0000\u0000\u0000\u02d4\u02d5\u0005\u0007"+
		"\u0000\u0000\u02d5\u02d6\u0003<\u001e\u0000\u02d6\u02d7\u0006\"\uffff"+
		"\uffff\u0000\u02d7\u02d9\u0001\u0000\u0000\u0000\u02d8\u02d4\u0001\u0000"+
		"\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000\u02d9E\u0001\u0000\u0000"+
		"\u0000\u02da\u02db\u0005\u0015\u0000\u0000\u02db\u02dc\u0005\u0017\u0000"+
		"\u0000\u02dc\u02dd\u0003\n\u0005\u0000\u02dd\u02de\u0006#\uffff\uffff"+
		"\u0000\u02de\u02df\u0005\u0018\u0000\u0000\u02df\u02e0\u0003<\u001e\u0000"+
		"\u02e0\u02e1\u0006#\uffff\uffff\u0000\u02e1\u02f5\u0001\u0000\u0000\u0000"+
		"\u02e2\u02e3\u0005\u0005\u0000\u0000\u02e3\u02e4\u0003<\u001e\u0000\u02e4"+
		"\u02e5\u0006#\uffff\uffff\u0000\u02e5\u02e6\u0005\u0015\u0000\u0000\u02e6"+
		"\u02e7\u0005\u0017\u0000\u0000\u02e7\u02e8\u0003\n\u0005\u0000\u02e8\u02e9"+
		"\u0006#\uffff\uffff\u0000\u02e9\u02ea\u0005\u0018\u0000\u0000\u02ea\u02eb"+
		"\u00053\u0000\u0000\u02eb\u02f5\u0001\u0000\u0000\u0000\u02ec\u02ed\u0005"+
		"\t\u0000\u0000\u02ed\u02ee\u0005\u0017\u0000\u0000\u02ee\u02ef\u0003H"+
		"$\u0000\u02ef\u02f0\u0006#\uffff\uffff\u0000\u02f0\u02f1\u0005\u0018\u0000"+
		"\u0000\u02f1\u02f2\u0003<\u001e\u0000\u02f2\u02f3\u0006#\uffff\uffff\u0000"+
		"\u02f3\u02f5\u0001\u0000\u0000\u0000\u02f4\u02da\u0001\u0000\u0000\u0000"+
		"\u02f4\u02e2\u0001\u0000\u0000\u0000\u02f4\u02ec\u0001\u0000\u0000\u0000"+
		"\u02f5G\u0001\u0000\u0000\u0000\u02f6\u02ff\u0006$\uffff\uffff\u0000\u02f7"+
		"\u02f8\u0003J%\u0000\u02f8\u02f9\u0006$\uffff\uffff\u0000\u02f9\u0300"+
		"\u0001\u0000\u0000\u0000\u02fa\u02fb\u0003\n\u0005\u0000\u02fb\u02fc\u0006"+
		"$\uffff\uffff\u0000\u02fc\u02fe\u0001\u0000\u0000\u0000\u02fd\u02fa\u0001"+
		"\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000\u0000\u0000\u02fe\u0300\u0001"+
		"\u0000\u0000\u0000\u02ff\u02f7\u0001\u0000\u0000\u0000\u02ff\u02fd\u0001"+
		"\u0000\u0000\u0000\u0300\u0301\u0001\u0000\u0000\u0000\u0301\u0305\u0005"+
		"3\u0000\u0000\u0302\u0303\u0003L&\u0000\u0303\u0304\u0006$\uffff\uffff"+
		"\u0000\u0304\u0306\u0001\u0000\u0000\u0000\u0305\u0302\u0001\u0000\u0000"+
		"\u0000\u0305\u0306\u0001\u0000\u0000\u0000\u0306\u0307\u0001\u0000\u0000"+
		"\u0000\u0307\u030b\u00053\u0000\u0000\u0308\u0309\u0003L&\u0000\u0309"+
		"\u030a\u0006$\uffff\uffff\u0000\u030a\u030c\u0001\u0000\u0000\u0000\u030b"+
		"\u0308\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000\u0000\u030c"+
		"I\u0001\u0000\u0000\u0000\u030d\u030e\u0006%\uffff\uffff\u0000\u030e\u030f"+
		"\u0003\u0016\u000b\u0000\u030f\u0313\u0006%\uffff\uffff\u0000\u0310\u0311"+
		"\u0003\u001a\r\u0000\u0311\u0312\u0006%\uffff\uffff\u0000\u0312\u0314"+
		"\u0001\u0000\u0000\u0000\u0313\u0310\u0001\u0000\u0000\u0000\u0313\u0314"+
		"\u0001\u0000\u0000\u0000\u0314K\u0001\u0000\u0000\u0000\u0315\u0316\u0006"+
		"&\uffff\uffff\u0000\u0316\u0317\u0003\n\u0005\u0000\u0317\u031e\u0006"+
		"&\uffff\uffff\u0000\u0318\u0319\u00054\u0000\u0000\u0319\u031a\u0003\n"+
		"\u0005\u0000\u031a\u031b\u0006&\uffff\uffff\u0000\u031b\u031d\u0001\u0000"+
		"\u0000\u0000\u031c\u0318\u0001\u0000\u0000\u0000\u031d\u0320\u0001\u0000"+
		"\u0000\u0000\u031e\u031c\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000"+
		"\u0000\u0000\u031fM\u0001\u0000\u0000\u0000\u0320\u031e\u0001\u0000\u0000"+
		"\u0000\u0321\u0322\u0006\'\uffff\uffff\u0000\u0322\u0326\u0007\u0006\u0000"+
		"\u0000\u0323\u0324\u0003\n\u0005\u0000\u0324\u0325\u0006\'\uffff\uffff"+
		"\u0000\u0325\u0327\u0001\u0000\u0000\u0000\u0326\u0323\u0001\u0000\u0000"+
		"\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327\u0328\u0001\u0000\u0000"+
		"\u0000\u0328\u0329\u00053\u0000\u0000\u0329O\u0001\u0000\u0000\u0000J"+
		"T^hnu\u0080\u008c\u009c\u00a3\u00af\u00be\u00cc\u00d4\u0120\u012c\u012e"+
		"\u013a\u0149\u0156\u016e\u0176\u0180\u0189\u0194\u019e\u01b6\u01bd\u01c2"+
		"\u01c8\u01d5\u01da\u01e2\u01e4\u01e8\u01ea\u01f1\u01f5\u0202\u020f\u0211"+
		"\u021b\u0224\u022d\u0232\u0237\u023e\u0240\u0244\u0249\u0250\u0254\u0256"+
		"\u025f\u0264\u026a\u0272\u0279\u0282\u028e\u029f\u02a8\u02aa\u02b4\u02ba"+
		"\u02d1\u02d8\u02f4\u02fd\u02ff\u0305\u030b\u0313\u031e\u0326";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}