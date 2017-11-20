package domain.expressions;

import domain.IHeap;
import domain.dataStructures.MyIDictionary;

public class ConstantExp extends Exp {
    private int value;

    public ConstantExp(int value) {
        this.value = value;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> dictionary, IHeap heap) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
