package it.unicam.cs.lc.lc2122.project;
import java.util.*;

/**
 * Rappresenta un albero genealogico semplificato.
 *
 * @author Template: Luca Tesei
 * @author Francesco Chiocchi
 */
public class FamilyTree extends GedcomBaseVisitor<Individual> {
    // mappa che contiene tutti gli individui presenti, recuperabili attraverso il
    // loro codice univoco.
    private Map<String, Individual> elements;



    //Può non servire
    private String requestCode;
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
        if(!isPresent(code))
            throw new IllegalArgumentException("Il codice associato all'individuo non è presente");
        Set<String> s = new HashSet<>();
        s.add(code);
        System.out.println("sono negli antenati");

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
        s.add(code);
        System.out.println("sono nei discendenti");

        return s;
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
        for(GedcomParser.RecordContext r : l){
            if(Integer.valueOf(r.level().getText()).equals(0) && r.tag().getText().equals("INDI")){
                String code = '@' + r.optCodeIndividual().codeString().getText() + '@';
                Individual i = new Individual(code);
                addIndividual(i); lastIndividual = i;
                System.out.println("Last Individual.code "+ lastIndividual.getCode());
            }
            if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMS"))) {
                String f = '@'+ r.record_value().record_item(0).codeString().getText() +'@';
                System.out.println("FamigliaSposi.code: "+f);
            }
            //forse è meglio fare un metodo setCaratteristiche(GedcomParser.GedcomContext ctx)
            if((Integer.valueOf(r.level().getText()).equals(2) && r.tag().getText().equals("GIVN"))) {
                lastIndividual.setGivenName(r.record_value().record_item(0).anystring().getText());
                System.out.println(lastIndividual.getGivenName());
            }
            if((Integer.valueOf(r.level().getText()).equals(1) && r.tag().getText().equals("FAMC"))) {
                String f = '@'+ r.record_value().record_item(0).codeString().getText() +'@';
                //lastIndividual
                System.out.println("FamigliaFiglio.code: "+f);
            }
        }
        return visitChildren(ctx);
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
        for(Individual i : elements.values()){
            System.out.println("Nome: "+ i.getGivenName());
        }
        if(ctx == null)
            throw new NullPointerException("Il parse tree passato è null");
        String code = ctx.record_value().record_item(0).getText();
        this.requestCode = code;
        if(ctx.tag().getText().equals("ANCE") && isPresent(code)) getAncestorsOf(code);
        else if (ctx.tag().getText().equals("DISC") && isPresent(code)) getDescendantsOf(code);
        else throw new IllegalArgumentException("Il codice non è presente nella mappa o alla" +
                    " fine del file è presente un tag di richiesta non valido");
        return visitChildren(ctx);
    }

    /* COSE UTILI
    //String code = ctx.optCodeIndividual().codeString().getText();
    //String code = ctx.record_value().record_item(0).codeString().getText();
    //ctx.optCodeIndividual().codeString().getText().startsWith("@I")
    map.entrySet().forEach(entry->{
			System.out.println(entry.getKey() + " = " + entry.getValue());
		});
     */

}