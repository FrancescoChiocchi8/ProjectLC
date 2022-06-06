// Generated from C:/Users/fchio/Desktop/ProjectLC\Gedcom.g4 by ANTLR 4.10.1

	package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GedcomParser}.
 */
public interface GedcomListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GedcomParser#gedcom}.
	 * @param ctx the parse tree
	 */
	void enterGedcom(GedcomParser.GedcomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#gedcom}.
	 * @param ctx the parse tree
	 */
	void exitGedcom(GedcomParser.GedcomContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(GedcomParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(GedcomParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#level}.
	 * @param ctx the parse tree
	 */
	void enterLevel(GedcomParser.LevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#level}.
	 * @param ctx the parse tree
	 */
	void exitLevel(GedcomParser.LevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#code_individual}.
	 * @param ctx the parse tree
	 */
	void enterCode_individual(GedcomParser.Code_individualContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#code_individual}.
	 * @param ctx the parse tree
	 */
	void exitCode_individual(GedcomParser.Code_individualContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(GedcomParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(GedcomParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(GedcomParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(GedcomParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#record_value}.
	 * @param ctx the parse tree
	 */
	void enterRecord_value(GedcomParser.Record_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#record_value}.
	 * @param ctx the parse tree
	 */
	void exitRecord_value(GedcomParser.Record_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#record_item}.
	 * @param ctx the parse tree
	 */
	void enterRecord_item(GedcomParser.Record_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#record_item}.
	 * @param ctx the parse tree
	 */
	void exitRecord_item(GedcomParser.Record_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#anystring}.
	 * @param ctx the parse tree
	 */
	void enterAnystring(GedcomParser.AnystringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#anystring}.
	 * @param ctx the parse tree
	 */
	void exitAnystring(GedcomParser.AnystringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#anychar}.
	 * @param ctx the parse tree
	 */
	void enterAnychar(GedcomParser.AnycharContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#anychar}.
	 * @param ctx the parse tree
	 */
	void exitAnychar(GedcomParser.AnycharContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#special_char}.
	 * @param ctx the parse tree
	 */
	void enterSpecial_char(GedcomParser.Special_charContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#special_char}.
	 * @param ctx the parse tree
	 */
	void exitSpecial_char(GedcomParser.Special_charContext ctx);
}