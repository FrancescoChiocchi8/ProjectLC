package it.unicam.cs.lc.lc2122.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GedcomBaseListener2 extends GedcomBaseListener{

    private FamilyTree familyTree;
    private String requestCode;
    private List<Individual> childs;
    private Individual husb;
    private Individual wife;

    public GedcomBaseListener2() {
        this.familyTree = new FamilyTree();
        this.childs= new ArrayList<>();
        //this.childs = new ArrayList<>();
        //this.f = new HashMap<AFamily, String>();
    }

    @Override public void enterGedcom(GedcomParser.GedcomContext ctx) {
        List<GedcomParser.RecordContext> l = ctx.record();
        Individual lastIndividual = null;
        AFamily lastFamily = null;
        for(GedcomParser.RecordContext r : l) {
            if (Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("INDI")) {
                String codeIndividual = '@' + r.optCodeIndividual().codeString().getText() + '@';
                Individual individual = new Individual(codeIndividual);
                familyTree.addIndividual(individual);
                lastIndividual = individual;
            }
            setCharateristicOfIndividual(r, lastIndividual);
            if(Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("FAM")){
                this.childs.clear();
                this.husb = null;
                this.wife = null;
                String codeFamily = '@' + r.optCodeIndividual().codeString().getText() + '@';
                AFamily aFamily = new AFamily(codeFamily);
                familyTree.addFamily(aFamily);
                lastFamily = aFamily;
            }
            if(Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("HUSB")){
                lastFamily.setHusb(r.record_value().record_item(0).getText());
                Individual husb = familyTree.getIndividual(lastFamily.getHusb());
                this.husb= husb;
                System.out.println("HUSB Family: " + husb.getCode());
            }
            if(Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("WIFE")){
                lastFamily.setWife(r.record_value().record_item(0).getText());
                Individual wife = familyTree.getIndividual(lastFamily.getWife());
                this.wife= wife;
                System.out.println("WIFE Family: " + wife.getCode());
            }
            if(Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("CHIL")){
                lastFamily.setChild(r.record_value().record_item(0).getText());
                Individual child = familyTree.getIndividual(lastFamily.getChild());
                this.childs.add(child);
                if(this.husb != null){
                    child.setFather(this.husb);
                    this.husb.addChild(child);
                }
                if(this.wife != null) {
                    child.setMother(this.wife);
                    this.wife.addChild(child);
                }

                /*Individual father = child.getFather();
                System.out.println("cyifi "+child.getFather().getCode());
                System.out.println("njvnvi "+father.getCode());
                Individual mother = child.getMother();
                System.out.println("fycghvu "+child.getMother().getCode());
                System.out.println("CHIL Family: " + child.getCode());
                /*if(father.getCode() != null)
                    father.addChild(child);
                if(mother.getCode() != null)
                    mother.addChild(child);*/

            }
        }
    }

    @Override public void exitGedcom(GedcomParser.GedcomContext ctx) {

    }
    @Override public void enterRequest(GedcomParser.RequestContext ctx) {
        if(ctx == null)
            throw new NullPointerException("Il parse tree passato è null");
        String code = ctx.record_value().record_item(0).getText();
        this.requestCode = code;
        System.out.println("Codice di cui ricercare gli antenati/discendenti: " + requestCode);
        if(ctx.tag().getText().equals("DESC") && familyTree.isPresent(code)) familyTree.getDescendantsOf(code);
        else if(ctx.tag().getText().equals("ANCE") && familyTree.isPresent(code)) familyTree.getAncestorsOf(code);
        else throw new IllegalArgumentException("Il codice non è presente nella mappa o alla" +
                " fine del file è presente un tag di richiesta non valido");
        //exitRequest(ctx);
    }
    @Override public void exitRequest(GedcomParser.RequestContext ctx) {
        //System.exit(0);
    }

    private void setCharateristicOfIndividual(GedcomParser.RecordContext r, Individual lastIndividual) {
        if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMS"))){
            //lastIndividual = '@'+ r.record_value().record_item(0).codeString().getText() +'@';
        }
        if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMC"))){
            /*AFamily aFamily = this.familyTree.getFamily(r.record_value().record_item(0).getText());
            Individual husb = familyTree.getIndividual(aFamily.getHusb());
            addChild(husb);*/
        }
        if((Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("GIVN")))
            lastIndividual.setGivenName(r.record_value().record_item(0).anystring().getText());
        if((Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("SURN")))
            lastIndividual.setSurname(r.record_value().record_item(0).anystring().getText());
    }
    /* scorro la lista
    * for(String code: familyTree.getCodes())
    *       System.out.println("Code " + code);
    *
    * for(Individual i : childs){
            System.out.println("child" + i.getCode());
        }
    * */

   
}
