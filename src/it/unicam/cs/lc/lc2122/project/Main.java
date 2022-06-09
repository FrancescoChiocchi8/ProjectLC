package it.unicam.cs.lc.lc2122.project;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {
        GedcomLexer lexer = new GedcomLexer(CharStreams.fromFileName("EsempioRossi.ged"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GedcomParser parser = new GedcomParser(tokens);
        ParseTree tree = parser.gedcom(); // parse; start at prog <label id="code.tour.main.6"/>
        System.out.println(tree.toStringTree(parser));
        //System.out.println(tree.toStringTree());
        //System.out.println(tree.getChild(3));

        FamilyTree f = new FamilyTree();
        f.visit(tree);
    }

}
