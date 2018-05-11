package grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarAFDParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, TRANSICAO=7, ESTADO=8, 
		SIMB=9, WS=10;
	public static final int
		RULE_parse = 0, RULE_expression = 1, RULE_alfabeto = 2, RULE_estados = 3, 
		RULE_transicoes = 4, RULE_inicial = 5, RULE_finais = 6;
	public static final String[] ruleNames = {
		"parse", "expression", "alfabeto", "estados", "transicoes", "inicial", 
		"finais"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{{'", "'},{'", "'},'", "',{'", "'}}'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "TRANSICAO", "ESTADO", "SIMB", 
		"WS"
	};
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
	public String getGrammarFileName() { return "GrammarAFD.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarAFDParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarAFDParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			expression();
			setState(15);
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

	public static class ExpressionContext extends ParserRuleContext {
		public AlfabetoContext alfabeto() {
			return getRuleContext(AlfabetoContext.class,0);
		}
		public EstadosContext estados() {
			return getRuleContext(EstadosContext.class,0);
		}
		public TransicoesContext transicoes() {
			return getRuleContext(TransicoesContext.class,0);
		}
		public InicialContext inicial() {
			return getRuleContext(InicialContext.class,0);
		}
		public FinaisContext finais() {
			return getRuleContext(FinaisContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(T__0);
			setState(18);
			alfabeto();
			setState(19);
			match(T__1);
			setState(20);
			estados();
			setState(21);
			match(T__1);
			setState(22);
			transicoes();
			setState(23);
			match(T__2);
			setState(24);
			inicial();
			setState(25);
			match(T__3);
			setState(26);
			finais();
			setState(27);
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

	public static class AlfabetoContext extends ParserRuleContext {
		public TerminalNode SIMB() { return getToken(GrammarAFDParser.SIMB, 0); }
		public AlfabetoContext alfabeto() {
			return getRuleContext(AlfabetoContext.class,0);
		}
		public AlfabetoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alfabeto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterAlfabeto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitAlfabeto(this);
		}
	}

	public final AlfabetoContext alfabeto() throws RecognitionException {
		AlfabetoContext _localctx = new AlfabetoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alfabeto);
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(SIMB);
				setState(30);
				match(T__5);
				setState(31);
				alfabeto();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				match(SIMB);
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

	public static class EstadosContext extends ParserRuleContext {
		public TerminalNode ESTADO() { return getToken(GrammarAFDParser.ESTADO, 0); }
		public EstadosContext estados() {
			return getRuleContext(EstadosContext.class,0);
		}
		public EstadosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estados; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterEstados(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitEstados(this);
		}
	}

	public final EstadosContext estados() throws RecognitionException {
		EstadosContext _localctx = new EstadosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_estados);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(ESTADO);
				setState(36);
				match(T__5);
				setState(37);
				estados();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(ESTADO);
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

	public static class TransicoesContext extends ParserRuleContext {
		public TerminalNode TRANSICAO() { return getToken(GrammarAFDParser.TRANSICAO, 0); }
		public TransicoesContext transicoes() {
			return getRuleContext(TransicoesContext.class,0);
		}
		public TransicoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transicoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterTransicoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitTransicoes(this);
		}
	}

	public final TransicoesContext transicoes() throws RecognitionException {
		TransicoesContext _localctx = new TransicoesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_transicoes);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(TRANSICAO);
				setState(42);
				match(T__5);
				setState(43);
				transicoes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(TRANSICAO);
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

	public static class InicialContext extends ParserRuleContext {
		public TerminalNode ESTADO() { return getToken(GrammarAFDParser.ESTADO, 0); }
		public InicialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inicial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterInicial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitInicial(this);
		}
	}

	public final InicialContext inicial() throws RecognitionException {
		InicialContext _localctx = new InicialContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inicial);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(ESTADO);
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

	public static class FinaisContext extends ParserRuleContext {
		public List<TerminalNode> ESTADO() { return getTokens(GrammarAFDParser.ESTADO); }
		public TerminalNode ESTADO(int i) {
			return getToken(GrammarAFDParser.ESTADO, i);
		}
		public FinaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).enterFinais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarAFDListener ) ((GrammarAFDListener)listener).exitFinais(this);
		}
	}

	public final FinaisContext finais() throws RecognitionException {
		FinaisContext _localctx = new FinaisContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_finais);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(ESTADO);
				setState(50);
				match(T__5);
				setState(51);
				match(ESTADO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(ESTADO);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f:\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4$\n\4\3\5\3\5\3\5"+
		"\3\5\5\5*\n\5\3\6\3\6\3\6\3\6\5\6\60\n\6\3\7\3\7\3\b\3\b\3\b\3\b\5\b8"+
		"\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\66\2\20\3\2\2\2\4\23\3\2\2\2\6#\3"+
		"\2\2\2\b)\3\2\2\2\n/\3\2\2\2\f\61\3\2\2\2\16\67\3\2\2\2\20\21\5\4\3\2"+
		"\21\22\7\2\2\3\22\3\3\2\2\2\23\24\7\3\2\2\24\25\5\6\4\2\25\26\7\4\2\2"+
		"\26\27\5\b\5\2\27\30\7\4\2\2\30\31\5\n\6\2\31\32\7\5\2\2\32\33\5\f\7\2"+
		"\33\34\7\6\2\2\34\35\5\16\b\2\35\36\7\7\2\2\36\5\3\2\2\2\37 \7\13\2\2"+
		" !\7\b\2\2!$\5\6\4\2\"$\7\13\2\2#\37\3\2\2\2#\"\3\2\2\2$\7\3\2\2\2%&\7"+
		"\n\2\2&\'\7\b\2\2\'*\5\b\5\2(*\7\n\2\2)%\3\2\2\2)(\3\2\2\2*\t\3\2\2\2"+
		"+,\7\t\2\2,-\7\b\2\2-\60\5\n\6\2.\60\7\t\2\2/+\3\2\2\2/.\3\2\2\2\60\13"+
		"\3\2\2\2\61\62\7\n\2\2\62\r\3\2\2\2\63\64\7\n\2\2\64\65\7\b\2\2\658\7"+
		"\n\2\2\668\7\n\2\2\67\63\3\2\2\2\67\66\3\2\2\28\17\3\2\2\2\6#)/\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}