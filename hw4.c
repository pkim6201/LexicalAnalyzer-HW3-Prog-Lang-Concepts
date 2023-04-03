// STMT -> WHILE_LOOP | IF_STMT | BLOCK | EXPR

void statement(void){
	if (nextToken == WHILE_CODE)
		while_loop();
	else if (nextToken == IF_CODE)
		ifstmt();
	else if (nextToken == LEFT_CURLY)
		block();
	else if (nextToken == IDENT || nextToken == INT_LIT || nextToken == LEFT_PAREN)
		expr();
	else {
		error();
	}	
}


// STMT_LIST -> <STMT> ';'

void statement_list(void){
	if (nextToken == STMT_CODE) {
		statement();
		if(nextToken != SEMI_COLON)
			error();
	}
	else {
		error();
	}	
}

/*
<WHILE_LOOP> --> `while` `(` <BOOL_EXPR> `)` ( <STMT> `;` | <BLOCK> )
*/

void while_loop(void) {
 if (nextToken != WHILE_CODE)
 	error();
 else {
	lex();
 	if (nextToken != LEFT_PAREN)
 		error();
 	else {
 		lex();
 		boolexpr();
 		if (nextToken != RIGHT_PAREN)
 			error();
		
		if(nextToken == LEFT_CURLY
			block();
		else {
			statement();
			if(nextToken != SEMI_COLON)
			error();
		}
 	}
 }
}

/* 
<IF_STMT> --> `if` `(` <BOOL_EXPR> `)` ( <STMT> `;` | <BLOCK> ) [ `else` ( <STMT> `;` | <BLOCK> )] 
 */
void ifstmt(void) {
 if (nextToken != IF_CODE)
 	error();
 else {
	lex();
 	if (nextToken != LEFT_PAREN)
 		error();
 	else {
 		lex();
 		boolexpr();
 		if (nextToken != RIGHT_PAREN)
 			error();
		
		if(nextToken == LEFT_CURLY
			block();
		else {
			statement();
			if(nextToken != SEMI_COLON)
			error();
		}
 		if (nextToken == ELSE_CODE) {
 			if(nextToken == LEFT_CURLY
				block();
			else {
				statement();
				if(nextToken != SEMI_COLON)
				error();
		}
 		}
 	}
 }
}

// <BLOCK> --> `{` <STMT_LIST> `}`

void block(void){
	if (nextToken == LEFT_CURLY){
		statement_list();
		if(nextToken != RIGHT_CURLY){
			error();
	} else {
		error();
}

/* 
<EXPR> --> <TERM> {(`+`|`-`) <TERM>}
 */
void expr(void) {
	 printf("Enter <expr>\n");
	 term();
	 while (nextToken == ADD_OP || nextToken == SUB_OP) {
		 lex();
		 term();
	 }
	 printf("Exit <expr>\n");
}

/* 
<TERM> --> <FACT> {(`*`|`/`|`%`) <FACT>} 
 */
void term(void) {
	 printf("Enter <term>\n");
	 factor();
	 while (nextToken == MULT_OP || nextToken == DIV_OP) {
		 lex();
		 factor();
	 }
	 printf("Exit <term>\n");
}

/* 
<FACT> --> ID | INT_LIT | FLOAT_LIT | `(` <EXPR> `)` 
 */
void factor(void) {
	 printf("Enter <factor>\n");
	 if (nextToken == IDENT || nextToken == INT_LIT)
		 lex();
	 else { if (nextToken == LEFT_PAREN) {
		 lex();
		 expr();
		 if (nextToken == RIGHT_PAREN)
		 	lex();
		 else
		 	error();
		 }
		 else
		 error();
	 }
	 printf("Exit <factor>\n");
}

/*
<BOOL_EXPR> --> <BTERM> {(`>`|`<`|`>=`|`<=`) <BTERM>}
<BTERM> --> <BAND> {(`==`|`!=`) <BAND>}
<BAND> --> <BOR> {`&&` <BOR>}
<BOR> --> <EXPR> {`||` <EXPR>}
*/

void boolexpr(void) {
	if(nextToken == BTERM_CODE){
		bterm();
		if(nextToken != LESS_THAN || nextToken != GREATER_THAN || nextToken != LESS_THAN_EQUAL || nextToken != GREATER_THAN_EQUAL) 
			error();
		bterm();
	}else {
		error();
	}
}

void bterm(void) {
	if(nextToken == BAND_CODE){
		band();
		if(nextToken != EQUAL_SIGN || nextToken != NOT_EQUAL)
			error();
		band();
	}else {
		error();
	}
}

void band(void) {
	if(nextToken == BOR_CODE){
		bor();
		if(nextToken != AND_AND)
			error();
		bor();
	}else {
		error();
	}
}

void bor(void) {
	if(nextToken == nextToken == IDENT || nextToken == INT_LIT || nextToken == LEFT_PAREN){
		expr();
		if(nextToken != OR_OR)
			error();
		expr();
	}else {
		error();
	}
}
