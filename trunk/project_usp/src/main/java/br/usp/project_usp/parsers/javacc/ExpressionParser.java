/* Generated By:JavaCC: Do not edit this line. ExpressionParser.java */
package br.usp.project_usp.parsers.javacc;
import br.*;
import java.util.*;
import javax.swing.*;
import java.io.StringReader;
import java.io.Reader;

public class ExpressionParser implements ExpressionParserConstants {
  public ExpressionParser(String expression)
  {
    this ((Reader) (new StringReader(expression)));
  }

  public static void main(String args []) throws ParseException, Error, Exception
  {
    String expression = args [0];
    ExpressionParser parser = new ExpressionParser(expression);
//    try
//    }

  final public void expression() throws ParseException {
    trace_call("expression");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POST:
      case PUT:
      case DELETE:
      case LBRACKET:
        event();
        break;
      case NOT:
      case OK:
      case NOT_FOUND:
      case LPAREN:
        invariant();
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("expression");
    }
  }

  final public void event() throws ParseException {
    trace_call("event");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACKET:
        guard();
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
      httpMethod();
      httpMethodData();
    } finally {
      trace_return("event");
    }
  }

  final public void guard() throws ParseException {
    trace_call("guard");
    try {
      jj_consume_token(LBRACKET);
      booleanExpression();
      jj_consume_token(RBRACKET);
    } finally {
      trace_return("guard");
    }
  }

// this needs to be tested, not sure if works properly
  final public void booleanExpression() throws ParseException {
    trace_call("booleanExpression");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SLASH:
        path();
        jj_consume_token(DOT);
        jj_consume_token(IDENTIFIER);
        arithmeticOperator();
        value();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          booleanOperator();
          booleanExpression();
          break;
        default:
          jj_la1[2] = jj_gen;
          ;
        }
        break;
      case NOT:
      case LPAREN:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NOT:
          jj_consume_token(NOT);
          break;
        default:
          jj_la1[3] = jj_gen;
          ;
        }
        jj_consume_token(LPAREN);
        path();
        jj_consume_token(DOT);
        jj_consume_token(IDENTIFIER);
        arithmeticOperator();
        value();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          booleanOperator();
          booleanExpression();
          break;
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        jj_consume_token(RPAREN);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          booleanOperator();
          booleanExpression();
          break;
        default:
          jj_la1[5] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("booleanExpression");
    }
  }

  final public void arithmeticOperator() throws ParseException {
    trace_call("arithmeticOperator");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQUALS:
        jj_consume_token(EQUALS);
        break;
      case GT:
        jj_consume_token(GT);
        break;
      case LT:
        jj_consume_token(LT);
        break;
      case GE:
        jj_consume_token(GE);
        break;
      case LE:
        jj_consume_token(LE);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("arithmeticOperator");
    }
  }

  final public void value() throws ParseException {
    trace_call("value");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONSTANT:
        jj_consume_token(CONSTANT);
        break;
      case TRUE:
        jj_consume_token(TRUE);
        break;
      case FALSE:
        jj_consume_token(FALSE);
        break;
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("value");
    }
  }

  final public void booleanOperator() throws ParseException {
    trace_call("booleanOperator");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        jj_consume_token(AND);
        break;
      case OR:
        jj_consume_token(OR);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("booleanOperator");
    }
  }

  final public void httpMethod() throws ParseException {
    trace_call("httpMethod");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POST:
        jj_consume_token(POST);
        break;
      case PUT:
        jj_consume_token(PUT);
        break;
      case DELETE:
        jj_consume_token(DELETE);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("httpMethod");
    }
  }

  final public void httpMethodData() throws ParseException {
    trace_call("httpMethodData");
    try {
      jj_consume_token(LPAREN);
      path();
      args();
      jj_consume_token(RPAREN);
    } finally {
      trace_return("httpMethodData");
    }
  }

  final public void path() throws ParseException {
    trace_call("path");
    try {
      label_1:
      while (true) {
        jj_consume_token(SLASH);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          jj_consume_token(IDENTIFIER);
          break;
        case VARIABLE:
          jj_consume_token(VARIABLE);
          break;
        default:
          jj_la1[11] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SLASH:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_1;
        }
      }
    } finally {
      trace_return("path");
    }
  }

  final public void args() throws ParseException {
    trace_call("args");
    try {
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[13] = jj_gen;
          break label_2;
        }
        jj_consume_token(COMMA);
        jj_consume_token(IDENTIFIER);
      }
    } finally {
      trace_return("args");
    }
  }

  final public void invariant() throws ParseException {
    trace_call("invariant");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OK:
      case NOT_FOUND:
        getMethod();
        getMethodData();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          booleanOperator();
          invariant();
          break;
        default:
          jj_la1[14] = jj_gen;
          ;
        }
        break;
      case NOT:
      case LPAREN:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NOT:
          jj_consume_token(NOT);
          break;
        default:
          jj_la1[15] = jj_gen;
          ;
        }
        jj_consume_token(LPAREN);
        getMethod();
        getMethodData();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          booleanOperator();
          invariant();
          break;
        default:
          jj_la1[16] = jj_gen;
          ;
        }
        jj_consume_token(RPAREN);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
        case OR:
          booleanOperator();
          invariant();
          break;
        default:
          jj_la1[17] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("invariant");
    }
  }

  final public void getMethod() throws ParseException {
    trace_call("getMethod");
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OK:
        jj_consume_token(OK);
        break;
      case NOT_FOUND:
        jj_consume_token(NOT_FOUND);
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      trace_return("getMethod");
    }
  }

  final public void getMethodData() throws ParseException {
    trace_call("getMethodData");
    try {
      jj_consume_token(LPAREN);
      path();
      jj_consume_token(RPAREN);
    } finally {
      trace_return("getMethodData");
    }
  }

  /** Generated Token Manager. */
  public ExpressionParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[20];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x53e080,0x400000,0x60,0x80,0x60,0x60,0x4100080,0x1f00,0xe0000000,0x60,0x38000,0x0,0x4000000,0x40000,0x60,0x80,0x60,0x60,0x106080,0x6000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x3,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public ExpressionParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ExpressionParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ExpressionParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ExpressionParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ExpressionParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ExpressionParser(ExpressionParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ExpressionParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      trace_token(token, "");
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
      trace_token(token, " (in getNextToken)");
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[35];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 20; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 35; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled = true;

/** Enable tracing. */
  final public void enable_tracing() {
    trace_enabled = true;
  }

/** Disable tracing. */
  final public void disable_tracing() {
    trace_enabled = false;
  }

  private void trace_call(String s) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.println("Call:   " + s);
    }
    trace_indent = trace_indent + 2;
  }

  private void trace_return(String s) {
    trace_indent = trace_indent - 2;
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.println("Return: " + s);
    }
  }

  private void trace_token(Token t, String where) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.print("Consumed token: <" + tokenImage[t.kind]);
      if (t.kind != 0 && !tokenImage[t.kind].equals("\"" + t.image + "\"")) {
        System.out.print(": \"" + t.image + "\"");
      }
      System.out.println(" at line " + t.beginLine + " column " + t.beginColumn + ">" + where);
    }
  }

  private void trace_scan(Token t1, int t2) {
    if (trace_enabled) {
      for (int i = 0; i < trace_indent; i++) { System.out.print(" "); }
      System.out.print("Visited token: <" + tokenImage[t1.kind]);
      if (t1.kind != 0 && !tokenImage[t1.kind].equals("\"" + t1.image + "\"")) {
        System.out.print(": \"" + t1.image + "\"");
      }
      System.out.println(" at line " + t1.beginLine + " column " + t1.beginColumn + ">; Expected token: <" + tokenImage[t2] + ">");
    }
  }

}