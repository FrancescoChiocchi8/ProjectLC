grammar Gedcom;

gedcom: record+ ;

/* Un record, in generale è formato da un livello, dato obbligatorio, da un header opzionale, da un codice di un individuo
 * opzionale se il livello è 0, da un tag obbligatorio e da un valore riferito al tag, anch'esso opzionale.
 */
record: level tag? code_individual? record_value? RN ;

level: LEVEL
    | DIGIT;

code_individual: code;

code: '@' ('I'|'F') DIGIT '@' WORD;

tag: WORD;

record_value: record_item+;

record_item: code
   | anystring
   ;

anystring: anychar+;

anychar: WORDS
   | DIGIT
   | special_char
   ;

special_char:  ','
   | '.'
   | ':'
   | '/'
   | '-'
   ;


DIGIT: [0-9]+;
LEVEL: [0-3];

WORD: [A-Z]+;
WORDS: [a-zA-Z]+;
RN: [\r\n]+;
WS: [ \t] -> skip;
//ID:	[a-zA-Z][a-zA-Z0-9]* ;
