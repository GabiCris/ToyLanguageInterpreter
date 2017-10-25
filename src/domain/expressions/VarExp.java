package domain.expressions;

import domain.dataStructures.MyIDictionary;

public class VarExp extends Exp {
    private String key;

    public VarExp(String key) {
        this.key = key;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> dictionary) {
        return dictionary.get(key);
    }

    @Override
    public String toString() {
        return key;
    }
}
