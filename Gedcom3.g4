grammar Gedcom3;

@header {
	package it.unicam.cs.lc.lc2122.project;
}

// Un file in formato Gedcom è un insieme di record
gedcom: record+;

/*
 * Un record è la composizione dei valori livello, dato obbligatorio, codice dell'individuo opzionale, tag obbligatorio
 * e il valore del record opzionale.
 */
record: level optCodeIndividual? tag record_value? EOL;

level: DIGIT;

optCodeIndividual: '@' codeString '@';

tag: WORD;

record_value: record_item+;

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

WS: [ \t] -> skip;