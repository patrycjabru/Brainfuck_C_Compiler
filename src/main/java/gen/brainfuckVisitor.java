package gen;// Generated from D:/aSTUDIA/semestr 6/Teoria kompilacji i kompilatory/Brainfuck_Compiler_in_Java\brainfuck.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link brainfuckParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface brainfuckVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link brainfuckParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(brainfuckParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link brainfuckParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(brainfuckParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link brainfuckParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(brainfuckParser.SignContext ctx);
}