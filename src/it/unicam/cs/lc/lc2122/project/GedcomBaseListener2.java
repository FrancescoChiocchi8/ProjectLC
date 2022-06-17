package it.unicam.cs.lc.lc2122.project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GedcomBaseListener2 extends GedcomBaseListener {

    private FamilyTree familyTree;
    private String requestCode;
    private List<Individual> childs;
    private Individual husb;
    private Individual wife;

    public GedcomBaseListener2() {
        this.familyTree = new FamilyTree();
        this.childs = new ArrayList<>();
    }

    @Override
    public void enterGedcom(GedcomParser.GedcomContext ctx) {
        List<GedcomParser.RecordContext> l = ctx.record();
        Individual lastIndividual = null;
        AFamily lastFamily = null;
        boolean birthDay = false;
        for (GedcomParser.RecordContext r : l) {
            if (Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("INDI")) {
                String codeIndividual = '@' + r.optCodeIndividual().codeString().getText() + '@';
                Individual individual = new Individual(codeIndividual);
                familyTree.addIndividual(individual);
                lastIndividual = individual;
            }
            setCharateristicOfIndividual(r, lastIndividual);
            if (Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("BIRT"))
                birthDay = true;
            if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("DATE") && birthDay){
                setDateIndividual(r, lastIndividual);
                birthDay = false;
            }
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
        }
    }

    @Override
    public void exitGedcom(GedcomParser.GedcomContext ctx) {
        familyTree.getCode();
    }

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

    private void setCharateristicOfIndividual(GedcomParser.RecordContext r, Individual lastIndividual){
        if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("GIVN"))
            lastIndividual.setGivenName(r.record_value().record_item(0).anystring().getText());
        if (Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("SURN"))
            lastIndividual.setSurname(r.record_value().record_item(0).anystring().getText());
    }

    public boolean setDateIndividual(GedcomParser.RecordContext r, Individual lastIndividual){
        GregorianCalendar g = new GregorianCalendar();
        String s = r.record_value().getText();
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        /*try {
            Date d = dateFormat.parse(s);
            g.set(d);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        lastIndividual.setBirthDate(g);*/
        return false;
    }
}
    /* scorro la lista
    * for(String code: familyTree.getCodes())
    *       System.out.println("Code " + code);
    *
    * for(Individual i : childs){
            System.out.println("child" + i.getCode());
        }
    * */

