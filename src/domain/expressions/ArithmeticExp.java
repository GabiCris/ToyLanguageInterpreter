package domain.expressions;

import domain.dataStructures.MyIDictionary;

public class ArithmeticExp extends Exp {
    private Exp left;
    private Exp right;
    private char operation;

    public ArithmeticExp(Exp left, Exp right, char operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    int eval(MyIDictionary<String, Integer> dictionary) {
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
