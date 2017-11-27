package domain.statements;

import domain.PrgState;
import domain.expressions.Exp;

public class WhileStmt implements IStmt {
    private Exp exp;
    private IStmt stmt;

    public WhileStmt(Exp exp, IStmt stmt) {
        this.exp = exp;
        this.stmt = stmt;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        int val = exp.eval(state.getSymTable(), state.getHeap());
        if (val > 0) {
            state.getStack().push(this);
            stmt.execute(state);
        }
        return state;
    }

    @Override
    public String toString() {
        return "While(" + exp + ") " + stmt + ";";
    }
}
