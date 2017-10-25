package domain.expressions;

import domain.dataStructures.MyIDictionary;

public class ConstantExp extends Exp {
    private int value;

    public ConstantExp(int value) {
        this.value = value;
    }

    @Override
    int eval(MyIDictionary<String, Integer> dictionary) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
