package it.unicam.cs.lc.lc2122.project;

import java.util.*;

public class GedcomBaseVisitor2 extends GedcomBaseVisitor<Individual>{

    private FamilyTree familyTree;

    private List<String> childs;

    private String requestCode;

    private String husb, wife;

    private AFamily lastFamily;

    private Map<AFamily, String> f;

    public GedcomBaseVisitor2() {
        this.familyTree = new FamilyTree();
        this.childs = new ArrayList<>();
        this.f = new HashMap<AFamily, String>();
    }
    /**
     * Metodo accessorio che restituisce l'ultimo codice del file gedcom relativo a un individuo.
     * @return l'ultimo codice del file gedcom relativo a un individuo.
     */
    public String getRequestCode(){
        return this.requestCode;
    }

    @Override public Individual visitGedcom(GedcomParser.GedcomContext ctx) {
        List<GedcomParser.RecordContext> l = ctx.record();
        Individual lastIndividual = null;
        AFamily lastFamily2 = null;
        boolean check = false;
        for(GedcomParser.RecordContext r : l) {
            if (Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("INDI")) {
                String code = '@' + r.optCodeIndividual().codeString().getText() + '@';
                Individual individual = new Individual(code);
                familyTree.addIndividual(individual);
                lastIndividual = individual;
                System.out.println("Last Individual.code " + lastIndividual.getCode());
            }
            setCharateristicOfIndividual(r, lastIndividual);
            if (Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("FAM")) {
                String famCode = '@' + r.optCodeIndividual().codeString().getText() + '@';
                AFamily family = new AFamily(famCode);
                familyTree.addFamily(family);
                lastFamily2 = family;
                System.out.println("F: " + famCode);
            }
            if(Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("HUSB")){
                String husb = r.record_value().record_item(0).getText();
                List<String> child;
                /*for(String code: familyTree.getCodes())
                    if(code.equals(child))
                        child.add(code);*/
                for(String code: familyTree.getCodes())
                    if(familyTree.isPresent(husb)){
                        Individual i = familyTree.getIndividual(husb);
                        //lastFamily2.setHusb(i);
                        System.out.println("Code " + lastFamily2.getHusb());}

            }

            if ((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("BIRT")))
                check = true;
           // if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("DATE") && check == true)
             //   check = setDateOfIndividual(r, lastIndividual);


            //if ((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMC")) || r.tag().getText().equals("FAMS")) {

              //  return visitChildren(ctx);
            //}
        }return visitChildren(ctx);
    }

    private boolean setDateOfIndividual(GedcomParser.RecordContext r, Individual lastIndividual){
        int day = Integer.valueOf(r.record_value().record_item(0).anystring().getText());
        String s = r.record_value().record_item(1).anystring().getText();
        int month;
        if (s.matches("0?1?2?3?4?5?6?7?8?9?")) month = Integer.valueOf(s);
        else month = getMonth(s);
        int year = Integer.valueOf(r.record_value().record_item(2).anystring().DIGIT().getText());
        GregorianCalendar c = new GregorianCalendar();
        c.set(day, month, year);
        lastIndividual.setBirthDate(c);
        return false;
    }

    private int getMonth(java.lang.String s) {
        switch (s){
            case "Jen","Gen ": return 1;
            case "Feb": return 2;
            case "Mar": return 3;
            case "Apr": return 4;
            case "May", "Mag": return 5;
            case "Jun", "Giu": return 6;
            case "Jul", "Lug": return 7;
            case "Aug", "Ago": return 8;
            case "Sep", "Set": return 9;
            case "Oct", "Ott": return 10;
            case "Nov": return 11;
            case "Dec", "Dic": return 12;
        }
        return 0;
    }

    private void setCharateristicOfIndividual(GedcomParser.RecordContext r, Individual lastIndividual) {
        /*if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMS"))){
            lastIndividual f = '@'+ r.record_value().record_item(0).codeString().getText() +'@';}
        if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMC"))){
            lastIndividual f = '@'+ r.record_value().record_item(0).codeString().getText() +'@';}*/
        if((Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("GIVN")))
            lastIndividual.setGivenName(r.record_value().record_item(0).anystring().getText());
        if((Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("SURN")))
            lastIndividual.setSurname(r.record_value().record_item(0).anystring().getText());
    }

    /**
     * Il metodo controlla se il codice opzionale di un individuo o di una famiglia sia valido. Per esserlo deve cominciare
     * o per "@I" o per "@F".
     * @param ctx the parse tree.
     * @return visita del nodo figlio.
     * @IllegalArgumentException se nel file è presente un tipo di codice non gestito.
     */
    @Override public Individual visitOptCodeIndividual(GedcomParser.OptCodeIndividualContext ctx) {
        String s = '@' + ctx.codeString().getText() + '@';
        if(!s.startsWith("@I") && !s.startsWith("@F"))
            throw new IllegalArgumentException("Tipo di codice opzionale non gestito");
        return visitChildren(ctx);
    }

    /**
     * Il metodo aggiunge alla mappa tutti i nuovi individui associandogli i codici letti nel file.
     * @param ctx the parse tree.
     * @return visita del nodo figlio.
     */
    @Override
    public Individual visitRecord(GedcomParser.RecordContext ctx){
        if(ctx.optCodeIndividual() != null && ctx.optCodeIndividual().codeString().getText().startsWith("@I")) {
            String code = '@'+ctx.optCodeIndividual().codeString().getText()+'@';
            System.out.println("c: "+ code);
        }
        else if(ctx.optCodeIndividual() != null && ctx.optCodeIndividual().codeString().getText().startsWith("@F")) {
            String code = '@'+ctx.optCodeIndividual().codeString().getText()+'@';
            System.out.println("f: "+ code);
        }
        return visitChildren(ctx);
    }

    @Override
    public Individual visitLevel(GedcomParser.LevelContext ctx) {
        int i = Integer.valueOf(ctx.DIGIT().getText());
        if(i < 0 || i > 2)
            throw new IllegalArgumentException("Tipi di livelli non gestiti dalla grammatica");
        return visitChildren(ctx);
    }
    /* metodi per scorrere elementi nella mappa
    for(String code: getCodes())
            System.out.println("Code " + code);*/

    @Override
    public Individual visitTag(GedcomParser.TagContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Il metodo prende il codeString dell'ultimo record del file relativo a un individuo e richiama uno dei
     * due metodi per cercare gli antenati o i discendenti per quell'individuo.
     * @param ctx the parse tree.
     * @return visita del nodo figlio.
     * @NullPointerException il parse tree passato è null.
     * @IllegalArgumentException il codice non è presente nella mappa o alla fine del file è presente un tag
     * di richiesta non valido.
     */
    @Override public Individual visitRequest(GedcomParser.RequestContext ctx) {
        if(ctx == null)
            throw new NullPointerException("Il parse tree passato è null");
        String code = ctx.record_value().record_item(0).getText();
        this.requestCode = code;
        if(ctx.tag().getText().equals("ANCE") && familyTree.isPresent(code)) familyTree.getAncestorsOf(code);
        else if (ctx.tag().getText().equals("DISC") && familyTree.isPresent(code)) familyTree.getDescendantsOf(code);
        else throw new IllegalArgumentException("Il codice non è presente nella mappa o alla" +
                    " fine del file è presente un tag di richiesta non valido");
        return visitChildren(ctx);
    }

                    /*String iHusb = this.initParentFamily(this.husb);
                String iWife = this.initParentFamily(this.wife);
                if (!this.childs.isEmpty())
                    this.childs.forEach(c -> {
                        String in;
                        if (this.familyTree.isPresent(c))
                            in = this.familyTree.getIndividual(c);
                        else {
                            this.familyTree.addIndividual(new String(c));
                            in = this.familyTree.getIndividual(c);
                        }
                        if (iHusb != null)
                            in.setFather(this.familyTree.getIndividual(this.husb));
                        if (iWife != null)
                            in.setMother(this.familyTree.getIndividual(this.wife));
                    });
            }
            /*if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMS"))){

            }
           */



    /*private String initParentFamily(Individual parent) {
        String ind = null;
        if (parent != null) {
            if (this.familyTree.isPresent(parent))
                ind = this.familyTree.getIndividual(parent);
            else {
                this.familyTree.addIndividual(new String(parent));
                ind = this.familyTree.getIndividual(parent);
            }
            if (!this.childs.isEmpty())
                this.addChilds(ind, this.childs);
        }
        return ind;
    }
/*
    private void addChilds(Individual i, List<Individual> childs) {
        childs.forEach(c -> {
            if (this.familyTree.isPresent(c)) {
                i.addChild(this.familyTree.getIndividual(c));
            }
        });

    }

/*
    private Individual initParentFamily(String parent) {
        Individual ind = null;
        if (parent != null) {
            if (this.familyTree.containsKey(parent))
                ind = this.elements.getIndividual(parent);
            else {
                this.elements.addIndividual(new Individual(parent));
                ind = this.elements.getIndividual(parent);
            }
            if (!this.families.isEmpty())
                this.families(ind, this.families);
        }
        return ind;
    }
*/
}
