// Generated from C:/Users/fchio/Desktop/ProjectLC\Gedcom3.g4 by ANTLR 4.10.1

	package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Gedcom3Parser}.
 */
public interface Gedcom3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#gedcom}.
	 * @param ctx the parse tree
	 */
	void enterGedcom(Gedcom3Parser.GedcomContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#gedcom}.
	 * @param ctx the parse tree
	 */
	void exitGedcom(Gedcom3Parser.GedcomContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(Gedcom3Parser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(Gedcom3Parser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#level}.
	 * @param ctx the parse tree
	 */
	void enterLevel(Gedcom3Parser.LevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#level}.
	 * @param ctx the parse tree
	 */
	void exitLevel(Gedcom3Parser.LevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#optCodeIndividual}.
	 * @param ctx the parse tree
	 */
	void enterOptCodeIndividual(Gedcom3Parser.OptCodeIndividualContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#optCodeIndividual}.
	 * @param ctx the parse tree
	 */
	void exitOptCodeIndividual(Gedcom3Parser.OptCodeIndividualContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(Gedcom3Parser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(Gedcom3Parser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#record_value}.
	 * @param ctx the parse tree
	 */
	void enterRecord_value(Gedcom3Parser.Record_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#record_value}.
	 * @param ctx the parse tree
	 */
	void exitRecord_value(Gedcom3Parser.Record_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#record_item}.
	 * @param ctx the parse tree
	 */
	void enterRecord_item(Gedcom3Parser.Record_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#record_item}.
	 * @param ctx the parse tree
	 */
	void exitRecord_item(Gedcom3Parser.Record_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#codeString}.
	 * @param ctx the parse tree
	 */
	void enterCodeString(Gedcom3Parser.CodeStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#codeString}.
	 * @param ctx the parse tree
	 */
	void exitCodeString(Gedcom3Parser.CodeStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(Gedcom3Parser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(Gedcom3Parser.PointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#anystring}.
	 * @param ctx the parse tree
	 */
	void enterAnystring(Gedcom3Parser.AnystringContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#anystring}.
	 * @param ctx the parse tree
	 */
	void exitAnystring(Gedcom3Parser.AnystringContext ctx);
	/**
	 * Enter a parse tree produced by {@link Gedcom3Parser#specialChar}.
	 * @param ctx the parse tree
	 */
	void enterSpecialChar(Gedcom3Parser.SpecialCharContext ctx);
	/**
	 * Exit a parse tree produced by {@link Gedcom3Parser#specialChar}.
	 * @param ctx the parse tree
	 */
	void exitSpecialChar(Gedcom3Parser.SpecialCharContext ctx);
}