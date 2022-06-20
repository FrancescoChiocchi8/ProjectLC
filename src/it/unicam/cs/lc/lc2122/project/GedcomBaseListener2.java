package it.unicam.cs.lc.lc2122.project;

import java.util.List;
import java.util.ArrayList;

public class GedcomBaseListener2 extends GedcomBaseListener {

    private final FamilyTree familyTree;
    private String requestCode;
    private final List<Individual> childs;
    private Individual husb;
    private Individual wife;

    /**
     * Inizializzazione delle variabili del costruttore.
     */
    public GedcomBaseListener2() {
        this.familyTree = new FamilyTree();
        this.childs = new ArrayList<>();
    }

    /**
     * Metodo che aggiunge gli individui e le famiglie alle mappe appartenenti alla classe FamilyTree e poi "setta" le
     * caratteristiche di ciascuno.
     * @param ctx the parse tree
     */
    @Override
    public void enterGedcom(GedcomParser.GedcomContext ctx) {
        //Uso di un lista che contiene tutti i records della grammatica.
        List<GedcomParser.RecordContext> l = ctx.record();
        Individual lastIndividual = null;
        AFamily lastFamily = null;
        boolean birthDay = false;
        boolean birthPlace = false;
        boolean deathDate = false;
        boolean deathPlace = false;
        boolean buriPlace = false;
        boolean marrDate = false;
        boolean marrPlace = false;
        //Scorro la lista e aggiungo caratteristiche agli individui/famiglie.
        for (GedcomParser.RecordContext r : l) {
            if (Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("INDI")) {
                String codeIndividual = '@' + r.optCodeIndividual().codeString().getText() + '@';
                Individual individual = new Individual(codeIndividual);
                familyTree.addIndividual(individual);
                lastIndividual = individual;
            }
            setCharateristicOfIndividual(r, lastIndividual);
            if (Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("FAM")) {
                this.childs.clear();
                this.husb = null;
                this.wife = null;
                String codeFamily = '@' + r.optCodeIndividual().codeString().getText() + '@';
                AFamily aFamily = new AFamily(codeFamily);
                familyTree.addFamily(aFamily);
                lastFamily = aFamily;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("HUSB")) {
                lastFamily.setHusb(r.record_value().record_item(0).getText());
                Individual husb = familyTree.getIndividual(lastFamily.getHusb());
                this.husb = husb;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("WIFE")) {
                lastFamily.setWife(r.record_value().record_item(0).getText());
                Individual wife = familyTree.getIndividual(lastFamily.getWife());
                this.wife = wife;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("CHIL")) {
                lastFamily.setChild(r.record_value().record_item(0).getText());
                Individual child = familyTree.getIndividual(lastFamily.getChild());
                this.childs.add(child);
                if (this.husb != null) {
                    child.setFather(this.husb);
                    this.husb.addChild(child);
                }
                if (this.wife != null) {
                    child.setMother(this.wife);
                    this.wife.addChild(child);
                }
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("BIRT"))
                birthDay = true;
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("DATE") && birthDay){
                String birthStringDate = setDate(r);
                birthDay = false;
                birthPlace = true;
                lastIndividual.setBirthDate2(birthStringDate);
            }
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && birthPlace){
                String bP = setPlace(r);
                lastIndividual.setBirthPlace(bP);
                birthPlace = false;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("DEAT"))
                deathDate = true;
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("DATE") && deathDate){
                String deathStringDate = setDate(r);
                deathDate = false;
                deathPlace = true;
                lastIndividual.setDeathDate2(deathStringDate);
            }
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && deathPlace){
                String dP = setPlace(r);
                lastIndividual.setDeathPlace(dP);
                deathPlace = false;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("BURI"))
                buriPlace = true;
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && buriPlace){
                String buP = setPlace(r);
                lastIndividual.setBuryPlace(buP);
                buriPlace = false;
                if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("MARR"))
                    marrDate = true;
                if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("DATE") && marrDate){
                    String marrStringDate = setDate(r);
                    marrDate = false;
                    marrPlace = true;
                    lastFamily.setDateMarr(marrStringDate);
                }
                if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && marrPlace){
                    String mP = setPlace(r);
                    lastFamily.setPlaceMarr(mP);
                    marrPlace = false;
                }
            }
        }
    }

    /**
     * Restituisce i codici di tutti gli individui antenati/discendenti della request.
     * @param ctx the parse tree
     */
    @Override
    public void exitGedcom(GedcomParser.GedcomContext ctx) {
        familyTree.getCode();
    }

    /**
     * Aggiunge all'insieme code di tipo Set gli individui a seconda del tag(desc-ance).
     * @param ctx the parse tree
     */
    @Override
    public void enterRequest(GedcomParser.RequestContext ctx) {
        if (ctx == null)
            throw new NullPointerException("Il parse tree passato è null");
        String code = ctx.record_value().record_item(0).getText();
        this.requestCode = code;
        System.out.println("\u001B[32m" +"Codice di cui ricercare gli antenati/discendenti: " + requestCode);
        if (ctx.tag().getText().equals("DESC") && familyTree.isPresent(code)) familyTree.getDescendantsOf(code);
        else if (ctx.tag().getText().equals("ANCE") && familyTree.isPresent(code)) familyTree.getAncestorsOf(code);
        else throw new IllegalArgumentException("Il codice non è presente nella mappa o alla" +
                    " fine del file è presente un tag di richiesta non valido");
    }

    /**
     * Set del nome e cognome dell' individuo.
     * @param r il record corrispondente.
     * @param lastIndividual l'ultimo individuo trovato.
     */
    private void setCharateristicOfIndividual(GedcomParser.RecordContext r, Individual lastIndividual){
        if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("GIVN"))
            lastIndividual.setGivenName(r.record_value().record_item(0).anystring().getText());
        if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("SURN"))
            lastIndividual.setSurname(r.record_value().record_item(0).anystring().getText());
    }

    /**
     * Set delle date (birth-death) dell'individuo, per comodità sotto forma di oggetto di tipo String.
     * @param r il record corrispondente.
     * @return the date.
     */
    private String setDate(GedcomParser.RecordContext r){
        if(r.record_value().record_item(0) != null && r.record_value().record_item(1) != null
                && r.record_value().record_item(2) != null){
            String date = r.record_value().record_item(0).getText() + " " + r.record_value().record_item(1).getText()
                    + " "+ r.record_value().record_item(2).getText();
            return date;
        }
        else if(r.record_value().record_item(0).getText() != null && r.record_value().record_item(1).getText() != null
        && r.record_value().record_item(2) == null){
            String date = r.record_value().record_item(0).getText() + r.record_value().record_item(1).getText();
            return date;
        }
        return null;
    }

    /**
     * Set del place (buri-deat-birt) dell'individuo.
     *
     * @param r il record corrispondente.
     * @return the place.
     */
    private String setPlace(GedcomParser.RecordContext r){
        String place = r.record_value().getText();
        return place;
    }
}

