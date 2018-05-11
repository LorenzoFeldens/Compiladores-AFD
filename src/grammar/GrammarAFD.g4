grammar GrammarAFD;

// Entrada: {{Alfabeto},{Conjunto de estados},{Funçoes de Transicoes},Estado Inicial,{Conjunto Estados Aceitacao}}
// {Alfabeto}: {x,y,z, [...]}
// {Conjunto de estados}: {q1,q2,q3, [...]}
// {Funçoes de Transicoes}: {{qx->qx,a},{qy->qy,b}, [...]} , onde  'x' e 'y' são índices dos estados, e 'a' e 'b' são simbolos do alfabeto
// Estado Inicial: qx
// {Conjunto Estados Aceitacao}: {q1,q2,q3, [...]}
// EXEMPLO DE ENTRADA: {{a,b,c},{q0,q1,q2,q3},{(q0->q1,a),(q0->q2,b)},q0,{q1,q2}}

parse : expression EOF ;

expression : '{{'alfabeto'},{'estados'},{'transicoes'},'inicial',{'finais'}}'	;

alfabeto : SIMB','alfabeto | SIMB ;

estados : ESTADO','estados | ESTADO ;

transicoes : TRANSICAO','transicoes | TRANSICAO ;

inicial : ESTADO ;

finais : ESTADO','ESTADO | ESTADO ;

TRANSICAO : '('ESTADO'-''>'ESTADO','SIMB')';
ESTADO : 'q'[0-9]+;
SIMB : [a-z] | [A-Z] | [0-9];


 
WS	: [ \r\t\u000C\n]+ -> skip;

