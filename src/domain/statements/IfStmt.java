package domain.statements;

import domain.PrgState;
import domain.dataStructures.MyIDictionary;
import domain.expressions.Exp;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenStmt;
    private IStmt elseStmt;

    public IfStmt(Exp exp, IStmt thenStmt, IStmt elseStmt) {
        this.exp = exp;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        if (exp.eval(symTable) != 0) {
            thenStmt.execute(state);
        }
        else {
            elseStmt.execute(state);
        }
        return state;
    }

    @Override
    public String toString() {
        return "IF (" + exp + ") THEN (" + thenStmt + ") ELSE" + elseStmt + ")";
    }
}
