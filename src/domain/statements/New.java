package domain.statements;

import domain.PrgState;
import domain.expressions.Exp;

public class New implements IStmt {
    private String varName;
    private Exp exp;

    public New(String varName, Exp exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        int heapIndex = state.getHeap().allocateHeap(exp.eval(state.getSymTable(), state.getHeap()));
        state.getSymTable().put(varName, heapIndex);
        return state;
    }

    @Override
    public String toString() {
        return "New(" + varName + "," + exp + ")";
    }
}
