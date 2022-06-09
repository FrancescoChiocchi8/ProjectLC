// Generated from C:/Users/fchio/Desktop/ProjectLC\Gedcom.g4 by ANTLR 4.10.1

package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GedcomParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, WORD=7, DIGIT=8, EOL=9, 
		WS=10;
	public static final int
		RULE_gedcom = 0, RULE_record = 1, RULE_level = 2, RULE_optCodeIndividual = 3, 
		RULE_tag = 4, RULE_record_value = 5, RULE_request = 6, RULE_record_item = 7, 
		RULE_codeString = 8, RULE_pointer = 9, RULE_anystring = 10, RULE_specialChar = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"gedcom", "record", "level", "optCodeIndividual", "tag", "record_value", 
			"request", "record_item", "codeString", "pointer", "anystring", "specialChar"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'-'", "','", "'.'", "'/'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "WORD", "DIGIT", "EOL", "WS"
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
	public String getGrammarFileName() { return "Gedcom.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GedcomParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GedcomContext extends ParserRuleContext {
		public RequestContext request() {
			return getRuleContext(RequestContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GedcomParser.EOF, 0); }
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
		}
		public GedcomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gedcom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterGedcom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitGedcom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitGedcom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GedcomContext gedcom() throws RecognitionException {
		GedcomContext _localctx = new GedcomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gedcom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(24);
					record();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(27); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(29);
			request();
			setState(30);
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

	public static class RecordContext extends ParserRuleContext {
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public TerminalNode EOL() { return getToken(GedcomParser.EOL, 0); }
		public OptCodeIndividualContext optCodeIndividual() {
			return getRuleContext(OptCodeIndividualContext.class,0);
		}
		public Record_valueContext record_value() {
			return getRuleContext(Record_valueContext.class,0);
		}
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitRecord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitRecord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_record);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			level();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(33);
				optCodeIndividual();
				}
			}

			setState(36);
			tag();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << WORD) | (1L << DIGIT))) != 0)) {
				{
				setState(37);
				record_value();
				}
			}

			setState(40);
			match(EOL);
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

	public static class LevelContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(GedcomParser.DIGIT, 0); }
		public LevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitLevel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LevelContext level() throws RecognitionException {
		LevelContext _localctx = new LevelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(DIGIT);
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

	public static class OptCodeIndividualContext extends ParserRuleContext {
		public CodeStringContext codeString() {
			return getRuleContext(CodeStringContext.class,0);
		}
		public OptCodeIndividualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optCodeIndividual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterOptCodeIndividual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitOptCodeIndividual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitOptCodeIndividual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptCodeIndividualContext optCodeIndividual() throws RecognitionException {
		OptCodeIndividualContext _localctx = new OptCodeIndividualContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_optCodeIndividual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(45);
			codeString();
			setState(46);
			match(T__0);
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

	public static class TagContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GedcomParser.WORD, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(WORD);
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

	public static class Record_valueContext extends ParserRuleContext {
		public List<Record_itemContext> record_item() {
			return getRuleContexts(Record_itemContext.class);
		}
		public Record_itemContext record_item(int i) {
			return getRuleContext(Record_itemContext.class,i);
		}
		public Record_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterRecord_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitRecord_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitRecord_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Record_valueContext record_value() throws RecognitionException {
		Record_valueContext _localctx = new Record_valueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_record_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				record_item();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << WORD) | (1L << DIGIT))) != 0) );
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

	public static class RequestContext extends ParserRuleContext {
		public LevelContext level() {
			return getRuleContext(LevelContext.class,0);
		}
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public Record_valueContext record_value() {
			return getRuleContext(Record_valueContext.class,0);
		}
		public TerminalNode EOL() { return getToken(GedcomParser.EOL, 0); }
		public RequestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_request; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterRequest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitRequest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitRequest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequestContext request() throws RecognitionException {
		RequestContext _localctx = new RequestContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_request);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			level();
			setState(56);
			tag();
			setState(57);
			record_value();
			setState(58);
			match(EOL);
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

	public static class Record_itemContext extends ParserRuleContext {
		public CodeStringContext codeString() {
			return getRuleContext(CodeStringContext.class,0);
		}
		public AnystringContext anystring() {
			return getRuleContext(AnystringContext.class,0);
		}
		public Record_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterRecord_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitRecord_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitRecord_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Record_itemContext record_item() throws RecognitionException {
		Record_itemContext _localctx = new Record_itemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_record_item);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(T__0);
				setState(61);
				codeString();
				setState(62);
				match(T__0);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case WORD:
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				anystring();
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

	public static class CodeStringContext extends ParserRuleContext {
		public List<PointerContext> pointer() {
			return getRuleContexts(PointerContext.class);
		}
		public PointerContext pointer(int i) {
			return getRuleContext(PointerContext.class,i);
		}
		public CodeStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterCodeString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitCodeString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitCodeString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeStringContext codeString() throws RecognitionException {
		CodeStringContext _localctx = new CodeStringContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_codeString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				pointer();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << WORD) | (1L << DIGIT))) != 0) );
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

	public static class PointerContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GedcomParser.WORD, 0); }
		public TerminalNode DIGIT() { return getToken(GedcomParser.DIGIT, 0); }
		public SpecialCharContext specialChar() {
			return getRuleContext(SpecialCharContext.class,0);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pointer);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(WORD);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(DIGIT);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				specialChar();
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

	public static class AnystringContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(GedcomParser.WORD, 0); }
		public TerminalNode DIGIT() { return getToken(GedcomParser.DIGIT, 0); }
		public SpecialCharContext specialChar() {
			return getRuleContext(SpecialCharContext.class,0);
		}
		public AnystringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anystring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterAnystring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitAnystring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitAnystring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnystringContext anystring() throws RecognitionException {
		AnystringContext _localctx = new AnystringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_anystring);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(WORD);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(DIGIT);
				}
				break;
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				specialChar();
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

	public static class SpecialCharContext extends ParserRuleContext {
		public SpecialCharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialChar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).enterSpecialChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GedcomListener ) ((GedcomListener)listener).exitSpecialChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GedcomVisitor ) return ((GedcomVisitor<? extends T>)visitor).visitSpecialChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialCharContext specialChar() throws RecognitionException {
		SpecialCharContext _localctx = new SpecialCharContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_specialChar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\nU\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u00054\b\u0005\u000b\u0005"+
		"\f\u00055\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"B\b\u0007\u0001\b\u0004\bE\b\b\u000b\b\f\bF\u0001\t\u0001\t\u0001\t\u0003"+
		"\tL\b\t\u0001\n\u0001\n\u0001\n\u0003\nQ\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0000\u0001\u0001\u0000\u0002\u0006R\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0002 \u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0006"+
		",\u0001\u0000\u0000\u0000\b0\u0001\u0000\u0000\u0000\n3\u0001\u0000\u0000"+
		"\u0000\f7\u0001\u0000\u0000\u0000\u000eA\u0001\u0000\u0000\u0000\u0010"+
		"D\u0001\u0000\u0000\u0000\u0012K\u0001\u0000\u0000\u0000\u0014P\u0001"+
		"\u0000\u0000\u0000\u0016R\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002"+
		"\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000"+
		"\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e\u0003\f\u0006"+
		"\u0000\u001e\u001f\u0005\u0000\u0000\u0001\u001f\u0001\u0001\u0000\u0000"+
		"\u0000 \"\u0003\u0004\u0002\u0000!#\u0003\u0006\u0003\u0000\"!\u0001\u0000"+
		"\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0003"+
		"\b\u0004\u0000%\'\u0003\n\u0005\u0000&%\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0005\t\u0000\u0000)\u0003"+
		"\u0001\u0000\u0000\u0000*+\u0005\b\u0000\u0000+\u0005\u0001\u0000\u0000"+
		"\u0000,-\u0005\u0001\u0000\u0000-.\u0003\u0010\b\u0000./\u0005\u0001\u0000"+
		"\u0000/\u0007\u0001\u0000\u0000\u000001\u0005\u0007\u0000\u00001\t\u0001"+
		"\u0000\u0000\u000024\u0003\u000e\u0007\u000032\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u00006\u000b\u0001\u0000\u0000\u000078\u0003\u0004\u0002\u000089\u0003"+
		"\b\u0004\u00009:\u0003\n\u0005\u0000:;\u0005\t\u0000\u0000;\r\u0001\u0000"+
		"\u0000\u0000<=\u0005\u0001\u0000\u0000=>\u0003\u0010\b\u0000>?\u0005\u0001"+
		"\u0000\u0000?B\u0001\u0000\u0000\u0000@B\u0003\u0014\n\u0000A<\u0001\u0000"+
		"\u0000\u0000A@\u0001\u0000\u0000\u0000B\u000f\u0001\u0000\u0000\u0000"+
		"CE\u0003\u0012\t\u0000DC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0011\u0001\u0000"+
		"\u0000\u0000HL\u0005\u0007\u0000\u0000IL\u0005\b\u0000\u0000JL\u0003\u0016"+
		"\u000b\u0000KH\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001"+
		"\u0000\u0000\u0000L\u0013\u0001\u0000\u0000\u0000MQ\u0005\u0007\u0000"+
		"\u0000NQ\u0005\b\u0000\u0000OQ\u0003\u0016\u000b\u0000PM\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000Q\u0015\u0001"+
		"\u0000\u0000\u0000RS\u0007\u0000\u0000\u0000S\u0017\u0001\u0000\u0000"+
		"\u0000\b\u001b\"&5AFKP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}