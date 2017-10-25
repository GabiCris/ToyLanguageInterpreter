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
            System.out.println(exp.eval(state.getSymTable()));
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
