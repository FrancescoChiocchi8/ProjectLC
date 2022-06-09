package it.unicam.cs.lc.lc2122.project;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Rappresenta un albero genealogico semplificato.
 *
 * @author Template: Luca Tesei
 */
public class FamilyTree extends GedcomBaseVisitor<Individual> {
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

        System.out.println("sono negli antenati");
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
        System.out.println("sono nei discendenti");

        if(!isPresent(code))
            throw new IllegalArgumentException("Il codice associato all'individuo non è presente");
        return null;
    }

    /**
     * Il metodo aggiunge alla mappa tutti i nuovi individui associandogli i codici letti nel file.
     * @param ctx the parse tree.
     * @return
     */
    @Override
    public Individual visitRecord(GedcomParser.RecordContext ctx){
        if(ctx.optCodeIndividual()!= null) {
            String code = ctx.optCodeIndividual().getText();
            if (Integer.valueOf(ctx.level().DIGIT().getText()) == 0 && code.startsWith("@I"))
                elements.put(code, new Individual(code));
            else if(Integer.valueOf(ctx.level().DIGIT().getText()) == 0 && code.startsWith("@F"))
                System.out.println("ciao " + code);
        }
        return null;
    }

    @Override public Individual visitLevel(GedcomParser.LevelContext ctx) {
        if(Integer.valueOf(ctx.getText()) == 0) {
            System.out.println("ciao");
            return visitChildren(ctx);}
        return null;
    }
    /* metodi per scorrere elementi nella mappa
    for(String code: getCodes())
            System.out.println("Code " + code);*/

    /**
     * Il metodo prende il codeString dell'ultimo record del file relativo a un individuo e richiama uno dei
     * due metodi per cercare gli antenati o i discendenti per quell'individuo.
     * @param ctx the parse tree.
     * @return l'individuo di cui si vogliono cercare gli antenati/discendenti.
     * @NullPointerException il parse tree passato è null.
     * @IllegalArgumentException il codice non è presente nella mappa o alla fine del file è presente un tag
     * di richiesta non valido.
     */
    @Override public Individual visitRequest(GedcomParser.RequestContext ctx) {
        if(ctx == null)
            throw new NullPointerException("Il parse tree passato è null");
        String code =ctx.record_value().record_item(0).getText();
        System.out.println("Last Code: " + code);
        Individual i = new Individual(code);
        if(ctx.tag().getText().equals("ANCE") && isPresent(code))
            getAncestorsOf(code);
        else if (ctx.tag().getText().equals("DISC") && isPresent(code))
            getDescendantsOf(code);
        else throw new IllegalArgumentException("Il codice non è presente nella mappa o alla" +
                    " fine del file è presente un tag di richiesta non valido");
        return i;
    }

    /* COSE UTILI
    //String code = ctx.optCodeIndividual().codeString().getText();
    //String code = ctx.record_value().record_item(0).codeString().getText();
    //ctx.optCodeIndividual().codeString().getText().startsWith("@I")
     */

}