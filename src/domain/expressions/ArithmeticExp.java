package domain.expressions;

import domain.IHeap;
import domain.MyException;
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
    public int eval(MyIDictionary<String, Integer> dictionary, IHeap heap) throws Exception {
        int left = 0;
        int right = 0;
        try {
            left = this.left.eval(dictionary, heap);
            right = this.right.eval(dictionary, heap);
        } catch (Exception e) {
            throw e;
        }

        if (operation == '+') {
            return left + right;
        }
        if (operation == '-') {
            return left - right;
        }
        if (operation == '*') {
            return left * right;
        }
        if (operation == '/') {
            if (right == 0) {
                throw new MyException("Division by 0!");
            }
            return left / right;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }
}
