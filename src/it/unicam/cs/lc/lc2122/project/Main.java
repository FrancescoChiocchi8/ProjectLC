package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

    public static void main(String[] args) throws Exception {
        Gedcom3Lexer lexer = new Gedcom3Lexer(CharStreams.fromFileName("Sample.ged"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Gedcom3Parser parser = new Gedcom3Parser(tokens);
        ParseTree tree = parser.gedcom(); // parse; start at prog <label id="code.tour.main.6"/>
        System.out.println(tree.toStringTree(parser));
        //Gedcom3Visitor g = new Gedcom3Visitor();
        //g.visit(tree);*/
    }

}
