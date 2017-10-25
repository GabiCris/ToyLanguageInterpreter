package domain.statements;

import domain.PrgState;
import domain.dataStructures.MyIDictionary;
import domain.dataStructures.MyIStack;
import domain.expressions.Exp;

public class AssignStmt implements IStmt {
    private String varId;
    private Exp exp;

    public AssignStmt(String varId, Exp exp) {
        this.varId = varId;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIStack<IStmt> stack = state.getStack();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int value = exp.eval(symTable);
        symTable.put(varId, value);
        return state;
    }

    @Override
    public String toString() {
        return varId + "=" + exp;
    }
}
