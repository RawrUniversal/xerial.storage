// $ANTLR 3.0.1 F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g 2008-04-21 11:13:06

package org.xerial.amoeba.query.impl;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AmoebaQueryTreeParser extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMBER", "STRING", "SELECTION", "CONDITION", "PROJECTION", "PROJECT_ALL", "ORDER_BY", "REF_ALL", "TARGET", "FUNCTION", "AND", "OR", "INPUT", "OUTPUT", "ASSIGN_LABEL", "COMPARE", "ATTRIBUTE", "REF", "VALUE", "CONTAINED_IN", "RELATION", "INSERT", "VALUE_SET", "NEW_VALUE", "NEW_RELATION", "UPDATE", "ATTRIBUTE_DEF", "SORT_TARGET", "ONE_TO_MANY", "ONE_TO_ONE", "OBJECT_DEF", "OBJECT", "LANG", "ML_COMMENT", "LINE_COMMENT", "Dot", "Colon", "Comma", "RParen", "LParen", "Quot", "Apos", "At", "Wildcard", "EQUAL", "NOT_EQUAL", "LESS", "LEQ", "GREATER", "GEQ", "SPLIT", "Select", "From", "Where", "In", "Insert", "Into", "Object", "Relationship", "HasMany", "HasOne", "DIVIDE", "DISTINCT", "RANGE", "DataType", "Letter", "Digit", "Digits", "NameChar", "WhiteSpaceChar", "StringLiteral", "Name", "QName", "'by'", "'auto'", "'AUTO'", "'update'", "'set'", "'{'", "'}'", "'as'", "'order'", "'or'", "'and'", "'like'"
    };
    public static final int DataType=68;
    public static final int OUTPUT=17;
    public static final int INPUT=16;
    public static final int LANG=36;
    public static final int Apos=45;
    public static final int Digit=70;
    public static final int Relationship=62;
    public static final int NUMBER=4;
    public static final int TARGET=12;
    public static final int LEQ=51;
    public static final int VALUE_SET=26;
    public static final int REF=21;
    public static final int PROJECT_ALL=9;
    public static final int GEQ=53;
    public static final int VALUE=22;
    public static final int OR=15;
    public static final int Letter=69;
    public static final int DIVIDE=65;
    public static final int AND=14;
    public static final int Insert=59;
    public static final int LESS=50;
    public static final int Comma=41;
    public static final int FUNCTION=13;
    public static final int Dot=39;
    public static final int Into=60;
    public static final int Object=61;
    public static final int CONDITION=7;
    public static final int ATTRIBUTE_DEF=30;
    public static final int ONE_TO_ONE=33;
    public static final int OBJECT_DEF=34;
    public static final int GREATER=52;
    public static final int HasMany=63;
    public static final int ML_COMMENT=37;
    public static final int Colon=40;
    public static final int NEW_VALUE=27;
    public static final int At=46;
    public static final int NOT_EQUAL=49;
    public static final int DISTINCT=66;
    public static final int OBJECT=35;
    public static final int RANGE=67;
    public static final int NameChar=72;
    public static final int CONTAINED_IN=23;
    public static final int SPLIT=54;
    public static final int ORDER_BY=10;
    public static final int Wildcard=47;
    public static final int STRING=5;
    public static final int NEW_RELATION=28;
    public static final int Where=57;
    public static final int RELATION=24;
    public static final int UPDATE=29;
    public static final int RParen=42;
    public static final int StringLiteral=74;
    public static final int LINE_COMMENT=38;
    public static final int In=58;
    public static final int Name=75;
    public static final int LParen=43;
    public static final int From=56;
    public static final int HasOne=64;
    public static final int Select=55;
    public static final int EQUAL=48;
    public static final int COMPARE=19;
    public static final int REF_ALL=11;
    public static final int ONE_TO_MANY=32;
    public static final int QName=76;
    public static final int SELECTION=6;
    public static final int WhiteSpaceChar=73;
    public static final int EOF=-1;
    public static final int PROJECTION=8;
    public static final int ATTRIBUTE=20;
    public static final int Quot=44;
    public static final int SORT_TARGET=31;
    public static final int INSERT=25;
    public static final int Digits=71;
    public static final int ASSIGN_LABEL=18;

        public AmoebaQueryTreeParser(TreeNodeStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g"; }



    // $ANTLR start query
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:21:1: query : selectClause ;
    public final void query() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:22:2: ( selectClause )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:22:4: selectClause
            {
            pushFollow(FOLLOW_selectClause_in_query44);
            selectClause();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end query


    // $ANTLR start selectClause
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:26:1: selectClause : ^( Select expr ) ;
    public final void selectClause() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:27:2: ( ^( Select expr ) )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:27:4: ^( Select expr )
            {
            match(input,Select,FOLLOW_Select_in_selectClause58); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expr_in_selectClause60);
            expr();
            _fsp--;


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end selectClause


    // $ANTLR start expr
    // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:31:1: expr : QName ;
    public final void expr() throws RecognitionException {
        try {
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:31:5: ( QName )
            // F:\\cygwin\\home\\leo\\work\\eclipse\\workspace\\xerial\\xerial-storage\\src\\main\\java\\org\\xerial\\amoeba\\query\\impl\\AmoebaQueryTreeParser.g:31:7: QName
            {
            match(input,QName,FOLLOW_QName_in_expr73); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end expr


 

    public static final BitSet FOLLOW_selectClause_in_query44 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Select_in_selectClause58 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_selectClause60 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QName_in_expr73 = new BitSet(new long[]{0x0000000000000002L});

}