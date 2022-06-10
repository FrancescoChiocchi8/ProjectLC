package it.unicam.cs.lc.lc2122.project;

import java.util.Set;

public class AFamily<Individual> {

    private Set<Individual> s ;

    public AFamily(Set<Individual> s) {
        this.s = s;
    }

    public Set<Individual> getS() {
        return s;
    }

    public void setS(Set<Individual> s) {
        this.s = s;
    }
}
