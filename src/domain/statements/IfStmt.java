package domain.statements;

import domain.MyException;
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
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        try {
            if (exp.eval(symTable, state.getHeap()) != 0) {
                thenStmt.execute(state);
            }
            else {
                elseStmt.execute(state);
            }
        } catch (Exception e) {
            throw e;
        }
        return state;
    }

    @Override
    public String toString() {
        return "IF (" + exp + ") THEN (" + thenStmt + ") ELSE " + elseStmt + ")";
    }
}
