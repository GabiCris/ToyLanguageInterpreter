package domain.expressions;

import domain.IHeap;
import domain.MyException;
import domain.dataStructures.MyIDictionary;

public class VarExp extends Exp {
    private String key;

    public VarExp(String key) {
        this.key = key;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> dictionary, IHeap heap) throws MyException {
        Integer value = dictionary.get(key);
        if (value == null) {
            throw new MyException("Value is not defined in the symbol table!");
        }
        return value;
    }

    @Override
    public String toString() {
        return key;
    }
}
