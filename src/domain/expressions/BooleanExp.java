package domain.expressions;

import domain.IHeap;
import domain.MyException;
import domain.dataStructures.MyIDictionary;

public class BooleanExp extends Exp{
    private String operation;
    private Exp left;
    private Exp right;

    public BooleanExp(String operation, Exp left, Exp right) {
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

        if (operation.equals("<")) {
            return left < right ? 1 : 0;
        }
        if (operation.equals("<=")) {
            return left <= right ? 1 : 0;
        }
        if (operation.equals(">")) {
            return left > right ? 1 : 0;
        }
        if (operation.equals(">=")) {
            return left >= right ? 1 : 0;
        }
        if (operation.equals("==")) {
            return left == right ? 1 : 0;
        }
        if (operation.equals("!=")) {
            return left != right ? 1 : 0;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operation + right.toString() + ")";
    }
}
