package it.unicam.cs.lc.lc2122.project;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class GedcomBaseListener2 extends GedcomBaseListener {

    private FamilyTree familyTree;
    private String requestCode;
    private List<Individual> childs;
    private Individual husb;
    private Individual wife;

    /**
     * Inizializzazione del costruttore.
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
        List<GedcomParser.RecordContext> l = ctx.record();
        Individual lastIndividual = null;
        AFamily lastFamily = null;
        boolean birthDay = false;
        boolean birthPlace = false;
        boolean deathDate = false;
        boolean deathPlace = false;
        boolean buriPlace = false;
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
                setBirthDate(r, lastIndividual);
                birthDay = false;
                birthPlace = true;
            }
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && birthPlace){
                String bP = setPlace(r, lastIndividual);
                lastIndividual.setBirthPlace(bP);
                birthPlace = false;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("DEAT"))
                deathDate = true;
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("DATE") && deathDate){
                setDeathDate(r, lastIndividual);
                deathDate = false;
                deathPlace = true;
            }
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && deathPlace){
                String dP = setPlace(r, lastIndividual);
                lastIndividual.setDeathPlace(dP);
                deathPlace = false;
            }
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("BURI"))
                buriPlace = true;
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("PLAC") && buriPlace){
                String buP = setPlace(r, lastIndividual);
                lastIndividual.setBuryPlace(buP);
                buriPlace = false;
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
     * Set del compleanno dell'individuo.
     * @param r il record corrispondente.
     * @param lastIndividual l'ultimo individuo trovato.
     * @return the date.
     */
    private int[] setBirthDate(GedcomParser.RecordContext r, Individual lastIndividual){
        if(r.record_value().record_item(0) != null && r.record_value().record_item(1) != null
                && r.record_value().record_item(2) != null){
            String s = r.record_value().getText();
            String s0 = r.record_value().record_item(0).getText();
            String s1 = r.record_value().record_item(1).getText();
            String s2 = r.record_value().record_item(2).getText();
            int[] date = convertStringToInt(s0, s1, s2);
            lastIndividual.setBirthDate(new GregorianCalendar(date[0], date[1], date[2]));
            return date;
        }
        return null;
    }

    /**
     * Set del place (buri-deat-birt) dell'individuo.
     * @param r il record corrispondente.
     * @param lastIndividual l'ultimo individuo trovato.
     * @return the place.
     */
    private String setPlace(GedcomParser.RecordContext r, Individual lastIndividual){
        String place = r.record_value().getText();
        return place;
    }

    /**
     * Set della data di morte dell'individuo.
     * @param r il record corrispondente.
     * @param lastIndividual l'ultimo individuo trovato.
     */
    private int[] setDeathDate(GedcomParser.RecordContext r, Individual lastIndividual) {
        if(r.record_value().record_item(0) != null && r.record_value().record_item(1) != null
                && r.record_value().record_item(2) != null){
            String s = r.record_value().getText();
            String s0 = r.record_value().record_item(0).getText();
            String s1 = r.record_value().record_item(1).getText();
            String s2 = r.record_value().record_item(2).getText();
            int[] date = convertStringToInt(s0, s1, s2);
            lastIndividual.setDeathDate(new GregorianCalendar(date[0], date[1], date[2]));
            return date;
        }
        return null;
    }

    /**
     * Converte la stringa trovata in un array di tipo int[].
     * @param day il giorno.
     * @param month il mese.
     * @param year l'anno.
     * @return l'array di tipo intero.
     */
    private int[] convertStringToInt(String day, String month, String year) {
        if (day.equals(null) || month.equals(null) || year.equals(null))
            throw new NullPointerException("Errore nel passare la data");
        int[] date = new int[3];
        date[0] = Integer.parseInt(day.trim());
        date[2] = Integer.parseInt(year.trim());
        switch (month.trim()) {
            case "Gen", "Jan": { date[1] = 0; break; }
            case "Feb": { date[1] = 1; break; }
            case "Mar": { date[1] = 2; break; }
            case "Apr": { date[1] = 3; break; }
            case "Mag", "May": { date[1] = 4; break; }
            case "Giu", "Jun": { date[1] = 5; break; }
            case "Lug", "July": { date[1] = 6; break; }
            case "Ago", "Aug": { date[1] = 7; break; }
            case "Set", "Sept": { date[1] = 8; break; }
            case "Ott", "Oct": { date[1] = 9; break; }
            case "Nov": { date[1] = 10; break; }
            case "Dic", "Dec": { date[1] = 11; break; }
        }
        return date;
    }


}

