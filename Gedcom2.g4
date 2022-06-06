grammar Gedcom2;
/*
@header {
	package it.unicam.cs.lc.lc2122.project;
}*/
/**
 * Un file gedcom ha necessariamente un header posto all'inizio. può anche avere
 */
prog: ZEROLEVEL head record+;//individual? family? finefile request? RN;

head: ' HEAD ' format charU date file? lang?;

format: FIRSTLEVEL ' GEDC ' version?;

version: SECONDLEVEL ' VERS ' ID'.'ID'.'ID;

charU: ' ';

date: ;

file: ;

lang: ;

individual: ;

family: ;

finefile: ;

request: ;

record: level tag? code_individual? record_value? RN ;

code_individual: ' ';

record_value: ' ';

tag: ' ';

level: ' ';

ZEROLEVEL: '0 ';

FIRSTLEVEL: '1';

SECONDLEVEL:'2';

ID: [0-9]+;

WS: [ \t\r\n]+ -> skip ;