grammar Gedcom;

@header {
package it.unicam.cs.lc.lc2122.project;
}

// Un file in formato Gedcom è un insieme di record e da una richiesta di visita di un record
gedcom: record+ request EOF;

/*
 * Un record è la composizione dei valori livello, dato obbligatorio, codice dell'individuo opzionale, tag obbligatorio
 * e il valore del record opzionale. Infine è presente la richiesta di ricerca degli antenati/discendenti dell'individuo.
 */
record: level optCodeIndividual? tag record_value? EOL;

level: DIGIT;

optCodeIndividual: '@' codeString '@';

tag: WORD;

record_value: record_item+;

request: level tag record_value EOL;

record_item: '@' codeString '@'
   | anystring
   ;

codeString: pointer+;

pointer: WORD
   | DIGIT
   | specialChar
   ;

anystring: WORD
   | DIGIT
   | specialChar
   ;

WORD: [a-zA-Z]+;

DIGIT: [0-9]+;

specialChar: '-'
   | ','
   | '.'
   | '/'
   | ':'
   ;

EOL: [\r\n]+;

WS: [ \n\r\t] -> skip;