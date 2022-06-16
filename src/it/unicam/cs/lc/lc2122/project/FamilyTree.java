package it.unicam.cs.lc.lc2122.project;
import java.util.*;


/**
 * Rappresenta un albero genealogico semplificato.
 *
 * @author Template: Luca Tesei
 * @author Francesco Chiocchi
 */
public class FamilyTree {
    // mappa che contiene tutti gli individui presenti, recuperabili attraverso il
    // loro codice univoco.
    private Map<String, Individual> elements;

    private Map<String, AFamily> families;

    /**
     * Costruisce un albero genealogico semplificato vuoto.
     */
    public FamilyTree() {
        this.elements = new HashMap<String, Individual>();
        this.families = new HashMap<String, AFamily>();
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

    public Set<String> getCodesFamily(){
        return this.families.keySet();
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

    public AFamily getFamily(String codeFamily){
        if(families.containsKey(codeFamily)){
            return families.get(codeFamily);
        }
        return null;
    }

    public boolean addFamily(AFamily aFamily) {
        if (this.families.containsKey(aFamily.getCodeFamily()))
            return false;
        this.families.put(aFamily.getCodeFamily(), aFamily);
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
        if(!isPresent(code))
            throw new IllegalArgumentException("Il codice associato all'individuo non è presente");
        Set<String> s = new HashSet<>();
        Individual i0 = this.getIndividual(code);
        s.add(code);
        if (i0.getFather() != null)
            s.addAll(this.getAncestorsOf(i0.getFather().getCode()));
        if (i0.getMother() != null)
            s.addAll(this.getAncestorsOf(i0.getMother().getCode()));
        System.out.println("sono negli antenati");
        for(String string : s)
            System.out.println("Antenati di "+ i0.getCode() + " " + string);
        return s;
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
        if(!isPresent(code))
            throw new IllegalArgumentException("Il codice associato all'individuo non è presente");
        Set<String> s = new HashSet<>();
        Individual i0 = this.getIndividual(code);
        s.add(code);
        for (Individual i : i0.getChilds()) {
            s.addAll(this.getDescendantsOf(i.getCode()));
        }
        for(String string : s)
            System.out.println("Discendenti di "+ i0.getCode() + " " + string);
        System.out.println("sono nei discendenti");
        getAll();
        return s;
    }

    public AFamily getFamily(AFamily codeFamily){
        if(families.containsKey(codeFamily))
            return families.get(codeFamily);
        return null;
    }

    public void getAll(){
        for(Individual i : elements.values()){
            //System.out.println("Nome: "+ i.getGivenName() + "Cognome: "+ i.getSurname());
            System.out.println(i.toString());
        }
        /*for(String code: families.keySet())
            System.out.println("CodeFamily: " + code);*/
    }


    /* COSE UTILI
    map.entrySet().forEach(entry->{
			System.out.println(entry.getKey() + " = " + entry.getValue());
		});
     */

}