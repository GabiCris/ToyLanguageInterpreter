package domain.expressions;

import domain.IHeap;
import domain.MyException;
import domain.dataStructures.MyIDictionary;

public class ReadHeap extends Exp {
    private String varName;

    public ReadHeap(String varName) {
        this.varName = varName;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> dictionary, IHeap heap) throws Exception {
        if (dictionary.get(varName) == null) {
            throw new MyException("Variable not found in symbol table!");
        }
        Integer symbolTableValue = dictionary.get(varName);

        if (heap.readValue(symbolTableValue) == null) {
            throw new MyException("Variable not found in heap!");
        }
        return heap.readValue(symbolTableValue);
    }

    @Override
    public String toString() {
        return "ReadHeap(" + varName + ")";
    }
}
