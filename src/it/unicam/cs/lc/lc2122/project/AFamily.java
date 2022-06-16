package it.unicam.cs.lc.lc2122.project;

import java.util.ArrayList;
import java.util.List;

public class AFamily {

    private String codeFamily;
    //private List<Individual> child;
    //private FamilyTree familyTree;
    private String husb;
    private String wife;
    private String child;

    public AFamily(String codeFamily) {
        this.codeFamily = codeFamily;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getCodeFamily() {
        return codeFamily;
    }

    public void setCodeFamily(String codeFamily) {
        this.codeFamily = codeFamily;
    }

    public String getHusb() {
        return husb;
    }

    public void setHusb(String husb) {
        this.husb = husb;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }
}
