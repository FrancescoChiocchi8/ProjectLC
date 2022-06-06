// Generated from C:/Users/fchio/Desktop/ProjectLC\Gedcom3.g4 by ANTLR 4.10.1

	package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Gedcom3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Gedcom3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#gedcom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGedcom(Gedcom3Parser.GedcomContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#record}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord(Gedcom3Parser.RecordContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel(Gedcom3Parser.LevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#optCodeIndividual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptCodeIndividual(Gedcom3Parser.OptCodeIndividualContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(Gedcom3Parser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#record_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord_value(Gedcom3Parser.Record_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#record_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord_item(Gedcom3Parser.Record_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#codeString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeString(Gedcom3Parser.CodeStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(Gedcom3Parser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#anystring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnystring(Gedcom3Parser.AnystringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Gedcom3Parser#specialChar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialChar(Gedcom3Parser.SpecialCharContext ctx);
}