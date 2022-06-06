// Generated from C:/Users/fchio/Desktop/ProjectLC\Gedcom.g4 by ANTLR 4.10.1

	package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GedcomParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GedcomVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GedcomParser#gedcom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGedcom(GedcomParser.GedcomContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#record}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord(GedcomParser.RecordContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#level}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLevel(GedcomParser.LevelContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#code_individual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode_individual(GedcomParser.Code_individualContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(GedcomParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(GedcomParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#record_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord_value(GedcomParser.Record_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#record_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecord_item(GedcomParser.Record_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#anystring}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnystring(GedcomParser.AnystringContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#anychar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnychar(GedcomParser.AnycharContext ctx);
	/**
	 * Visit a parse tree produced by {@link GedcomParser#special_char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecial_char(GedcomParser.Special_charContext ctx);
}