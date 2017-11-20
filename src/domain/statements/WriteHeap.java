package domain.statements;

import domain.IHeap;
import domain.MyException;
import domain.PrgState;
import domain.dataStructures.MyIDictionary;
import domain.expressions.Exp;

public class WriteHeap implements IStmt {
    private String varName;
    private Exp exp;

    public WriteHeap(String varName, Exp exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> dictionary = state.getSymTable();
        IHeap heap = state.getHeap();

        if (dictionary.get(varName) == null) {
            throw new MyException("Variable not found in symbol table!");
        }
        Integer symbolTableValue = dictionary.get(varName);

        if (heap.readValue(symbolTableValue) == null) {
            throw new MyException("Variable not found in heap!");
        }

        heap.updateHeap(symbolTableValue, exp.eval(dictionary, state.getHeap()));
        return state;
    }

    @Override
    public String toString() {
        return "WriteHeap(" + varName + "," + exp + ")";
    }
}
