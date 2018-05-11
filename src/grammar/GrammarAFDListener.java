package grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarAFDParser}.
 */
public interface GrammarAFDListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(GrammarAFDParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(GrammarAFDParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarAFDParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarAFDParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#alfabeto}.
	 * @param ctx the parse tree
	 */
	void enterAlfabeto(GrammarAFDParser.AlfabetoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#alfabeto}.
	 * @param ctx the parse tree
	 */
	void exitAlfabeto(GrammarAFDParser.AlfabetoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#estados}.
	 * @param ctx the parse tree
	 */
	void enterEstados(GrammarAFDParser.EstadosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#estados}.
	 * @param ctx the parse tree
	 */
	void exitEstados(GrammarAFDParser.EstadosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#transicoes}.
	 * @param ctx the parse tree
	 */
	void enterTransicoes(GrammarAFDParser.TransicoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#transicoes}.
	 * @param ctx the parse tree
	 */
	void exitTransicoes(GrammarAFDParser.TransicoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#inicial}.
	 * @param ctx the parse tree
	 */
	void enterInicial(GrammarAFDParser.InicialContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#inicial}.
	 * @param ctx the parse tree
	 */
	void exitInicial(GrammarAFDParser.InicialContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarAFDParser#finais}.
	 * @param ctx the parse tree
	 */
	void enterFinais(GrammarAFDParser.FinaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarAFDParser#finais}.
	 * @param ctx the parse tree
	 */
	void exitFinais(GrammarAFDParser.FinaisContext ctx);
}