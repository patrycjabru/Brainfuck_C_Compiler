grammar brainfuck;

file: expression*;
expression: sign | OPEN expression* CLOSE ;
sign: PLUS | MINUS | GREATER | LOWER | DOT | COMMA;
PLUS: '+';
MINUS: '-';
GREATER: '>';
LOWER: '<';
DOT: '.';
COMMA: ',';
OPEN: '[';
CLOSE: ']';
WS: . -> skip;