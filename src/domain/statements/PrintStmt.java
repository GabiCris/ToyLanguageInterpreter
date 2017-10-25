package domain.statements;

import domain.PrgState;
import domain.expressions.Exp;

public class PrintStmt implements IStmt {
    private Exp exp;

    @Override
    public PrgState execute(PrgState state) {
        System.out.println(exp);
        return state;
    }

    @Override
    public String toString() {
        return "(print" + exp.toString() + ")";
    }
}
