package it.unicam.cs.lc.lc2122.project;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Rappresenta un albero genealogico semplificato.
 *
 * @author Template: Luca Tesei
 * //TODO extends it.unicam.cs.lc.lc2122.project.GedcomBaseListener
 */
public class FamilyTree extends it.unicam.cs.lc.lc2122.project.Gedcom3BaseVisitor {
    // mappa che contiene tutti gli individui presenti, recuperabili attraverso il
    // loro codice univoco.
    private Map<String, Individual> elements;

    /**
     * Costruisce un albero genealogico semplificato vuoto.
     */
    public FamilyTree() {
        this.elements = new HashMap<String, Individual>();
    }

    /**
     * Restituisce un individuo nell'albero.
     *
     * @param code codice univoco dell'individuo da cercare
     * @return l'individuo con il codice indicato, altrimenti null se l'individuo
     *         non è presente
     */
    public Individual getIndividual(String code) {
        return this.elements.get(code);
    }

    /**
     * Determina se c'è un certo individuo nell'albero genealogico
     *
     * @param i individuo da ricercare
     * @return true se l'individuo passato è presente nell'albero genealogico, false
     *         altrimenti
     */
    public boolean isPresent(Individual i) {
        return this.elements.containsKey(i.getCode());
    }

    /**
     * Determina se c'è un certo individuo nell'albero genealogico
     *
     * @param code il codice dell'individuo da ricercare
     * @return true se l'individuo passato è presente nell'albero genealogico, false
     *         altrimenti
     */
    public boolean isPresent(String code) {
        return this.elements.containsKey(code);
    }

    /**
     * Restituisce tutti i codici degli individui presenti nell'albero genealogico
     *
     * @return l'insieme dei codici degli individui presenti
     */
    public Set<String> getCodes() {
        return this.elements.keySet();
    }

    /**
     * Aggiunge un individuo all'albero.
     *
     * @param newIndividual nuovo individuo da aggiungere
     * @return true se l'individuo è stato aggiunto, false se era già presente
     */
    public boolean addIndividual(Individual newIndividual) {
        if (this.elements.containsKey(newIndividual.getCode()))
            return false;
        this.elements.put(newIndividual.getCode(), newIndividual);
        return true;
    }

    /**
     * Restituisce l'insieme degli indici che sono antenati di un individuo
     * dell'albero, compreso l'individuo stesso.
     *
     * @param code il codice dell'individuo di partenza
     * @return l'insieme degli antenati dell'individuo di partenza
     * @throws IllegalArgumentException se code non è presente nell'albero
     */
    public Set<String> getAncestorsOf(String code) {
        // TODO implementare
        Set<String> s = new HashSet<>();
        if(!isPresent(code))
            throw new IllegalArgumentException("Il codice associato all'individuo non è presente");
        return null;
    }

    /**
     * Restituisce l'insieme degli indici che sono discendenti di un individuo
     * dell'albero, compreso l'individuo stesso.
     *
     * @param code il codice dell'individuo di partenza
     * @return l'insieme dei discendenti dell'individuo di partenza
     * @throws IllegalArgumentException se code non è presente nell'albero
     */
    public Set<String> getDescendantsOf(String code) {

        // TODO implementare
        Set<String> s = new HashSet<>();

        if(!isPresent(code))
            throw new IllegalArgumentException("Il codice associato all'individuo non è presente");
        return null;
    }

}