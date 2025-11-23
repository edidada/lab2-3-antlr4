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
// (1) 标识符 ID
ID : [a-zA-Z_][a-zA-Z0-9_]* ;

// (2) 十进制整数字面量 INT_LIT（支持 0、前导零、普通十进制）
INT_LIT
    : [0-9]+
    | '0'[0-7]*           // 八进制（实验允许）
    | '0'[xX][0-9a-fA-F]+ // 十六进制（实验允许）
    ;

// (3) 浮点数字面量 FLOAT_LIT（完整支持科学计数法、小数点、前缀等）
FLOAT_LIT
    : [0-9]+ '.' [0-9]* ExponentPart?   // 1.23, 1., .123（实验允许后两种）
    | '.' [0-9]+ ExponentPart?          // .123
    | [0-9]+ ExponentPart               // 1e10, 2E-5
    | [0-9]+ ('.' [0-9]*)? [fF]         // 后缀 f/F 表示 float（C 风格，实验接受）
    ;

// 科学计数法部分（可复用）
fragment ExponentPart
    : [eE] [+-]? [0-9]+
    ;

// (4) 词法错误 LEX_ERR —— 捕获所有无法识别的字符
LEX_ERR
    : .   // 匹配任意单个字符（放在所有规则最后！）
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


