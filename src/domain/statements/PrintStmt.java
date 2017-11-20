package domain.statements;

import domain.PrgState;
import domain.expressions.Exp;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        try {
            int value = exp.eval(state.getSymTable(), state.getHeap());
            System.out.println(value);
            state.getOutput().append(value);
        } catch (Exception e) {
            throw e;
        }
        return state;
    }

    @Override
    public String toString() {
        return "print(" + exp + ")";
    }
}
