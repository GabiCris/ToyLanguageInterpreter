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
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int value = 0;
        try {
            value = exp.eval(symTable);
        } catch (Exception e) {
            throw e;
        }
        symTable.put(varId, value);
        return state;
    }

    @Override
    public String toString() {
        return varId + "=" + exp;
    }
}
