package domain.expressions;

import domain.dataStructures.MyIDictionary;

public class ArithmeticExp extends Exp {
    private char operation;
    private Exp left;
    private Exp right;

    public ArithmeticExp(char operation, Exp left, Exp right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> dictionary) {
        if (operation == '+') {
            return left.eval(dictionary) + right.eval(dictionary);
        }
        if (operation == '-') {
            return left.eval(dictionary) - right.eval(dictionary);
        }
        if (operation == '*') {
            return left.eval(dictionary) * right.eval(dictionary);
        }
        if (operation == '/') {
            return left.eval(dictionary) / right.eval(dictionary);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }
}
