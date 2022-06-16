package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) throws Exception {
        //Leggo il file Gedcom specificato e genero il suo corrispondente albero di parsing
        GedcomLexer lexer = new GedcomLexer(CharStreams.fromFileName("EsempioRossi.ged"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GedcomParser parser = new GedcomParser(tokens);
        ParseTree tree = parser.gedcom();
        ParseTreeWalker walker = new ParseTreeWalker();
        System.out.println(tree.toStringTree(parser));
        GedcomBaseListener2 gedcomBaseListener2 = new GedcomBaseListener2();
        walker.walk(gedcomBaseListener2, tree);

       /// String s = tree.getRequestCode();
        //System.out.println("Individuo di cui ricercare gli antenati/discendenti: " + s);
        //GedcomBaseListener gedcomBaseListener = new GedcomBaseListener2();
        //GedcomBaseVisitor2 g = new GedcomBaseVisitor2();
        //g.visit(tree);
        //prendo il codice della richiesta di calcolo degli ascendenti/discendenti dell'ultimo individuo nel file .ged
    }

}
