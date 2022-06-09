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
	 * Enter a parse tree produced by {@link GedcomParser#optCodeIndividual}.
	 * @param ctx the parse tree
	 */
	void enterOptCodeIndividual(GedcomParser.OptCodeIndividualContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#optCodeIndividual}.
	 * @param ctx the parse tree
	 */
	void exitOptCodeIndividual(GedcomParser.OptCodeIndividualContext ctx);
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
	 * Enter a parse tree produced by {@link GedcomParser#request}.
	 * @param ctx the parse tree
	 */
	void enterRequest(GedcomParser.RequestContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#request}.
	 * @param ctx the parse tree
	 */
	void exitRequest(GedcomParser.RequestContext ctx);
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
	 * Enter a parse tree produced by {@link GedcomParser#codeString}.
	 * @param ctx the parse tree
	 */
	void enterCodeString(GedcomParser.CodeStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#codeString}.
	 * @param ctx the parse tree
	 */
	void exitCodeString(GedcomParser.CodeStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GedcomParser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(GedcomParser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(GedcomParser.PointerContext ctx);
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
	 * Enter a parse tree produced by {@link GedcomParser#specialChar}.
	 * @param ctx the parse tree
	 */
	void enterSpecialChar(GedcomParser.SpecialCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link GedcomParser#specialChar}.
	 * @param ctx the parse tree
	 */
	void exitSpecialChar(GedcomParser.SpecialCharContext ctx);
}