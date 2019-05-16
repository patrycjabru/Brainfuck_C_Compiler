package gen;// Generated from D:/aSTUDIA/semestr 6/Teoria kompilacji i kompilatory/Brainfuck_Compiler_in_Java\brainfuck.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link brainfuckParser}.
 */
public interface brainfuckListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link brainfuckParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(brainfuckParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link brainfuckParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(brainfuckParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link brainfuckParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(brainfuckParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link brainfuckParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(brainfuckParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link brainfuckParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(brainfuckParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link brainfuckParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(brainfuckParser.SignContext ctx);
}