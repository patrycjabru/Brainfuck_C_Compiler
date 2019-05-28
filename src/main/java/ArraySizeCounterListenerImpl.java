import gen.brainfuckListener;
import gen.brainfuckParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ArraySizeCounterListenerImpl implements brainfuckListener {
    private int counter = 1;
    private int max = 0;

    public void enterFile(brainfuckParser.FileContext ctx) {

    }

    public void exitFile(brainfuckParser.FileContext ctx) {

    }

    public void enterExpression(brainfuckParser.ExpressionContext ctx) {

    }

    public void exitExpression(brainfuckParser.ExpressionContext ctx) {

    }

    public void enterSign(brainfuckParser.SignContext ctx) {
        String txt = ctx.getText();
        if (txt.equals(">")) {
            counter++;
            if (counter > max)
                max = counter;
        }
        else if (txt.equals("<")) {
            counter --;
        }
    }

    public void exitSign(brainfuckParser.SignContext ctx) {

    }

    public void visitTerminal(TerminalNode terminalNode) {

    }

    public void visitErrorNode(ErrorNode errorNode) {

    }

    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public int getSize() {
        return max;
    }
}
