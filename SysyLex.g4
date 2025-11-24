lexer grammar SysyLex;

// keyword
INT : 'int';
FLOAT : 'float';
VOID : 'void';
CONST : 'const';
RETURN : 'return';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
BREAK : 'break';
CONTINUE : 'continue'; 

// delimeter
LP : '(' ;
RP : ')' ;
LB : '[' ;
RB : ']' ;
LC : '{' ;
RC : '}' ;
COMMA : ',' ;
SEMICOLON : ';';
QUESTION : '?';
COLON : ':';

// operator
MINUS : '-';
NOT : '!';
ASSIGN : '=';
ADD : '+';
MUL : '*';
DIV : '/';
MOD : '%';
AND : '&&';
OR : '||';
EQ : '==';
NEQ : '!=';
LT : '<';
LE : '<=';
GT : '>';
GE : '>=';
ID : [a-zA-Z_][a-zA-Z0-9_]* ;

ERR_INT_LIT: '0'[0-9]*[89][0-9]*;  // 检测085这样的错误

INT_LIT
    : [0-9]+
    | '0'[0-7]*
    | '0'[xX][0-9a-fA-F]+
    ;

FLOAT_LIT
    : [0-9]+ '.' [0-9]* ExponentPart?
    | '.' [0-9]+ ExponentPart?
    | [0-9]+ ExponentPart
    | [0-9]+ ('.' [0-9]*)? [fF]
    ;

// 科学计数法部分（可复用）
fragment ExponentPart
    : [eE] [+-]? [0-9]+[fF]
    ;


// integer literal


// float literal


// fragment for float literal


// identifier

// string
STRING : '"'(ESC|.)*?'"';

// for string
fragment
ESC : '\\"'|'\\\\';

// whitespace
WS : 
    [ \t\r\n] -> skip
    ;

// comments
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip;
BLOCK_COMMENT : '/*'.*?'*/'-> skip ;


// (4) 词法错误 LEX_ERR —— 捕获所有无法识别的字符
LEX_ERR
    : .   // 匹配任意单个字符（放在所有规则最后！）
    ;