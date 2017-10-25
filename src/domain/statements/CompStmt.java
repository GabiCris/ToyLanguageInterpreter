package domain.statements;

import domain.PrgState;
import domain.dataStructures.MyIStack;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt second;

    @Override
    public PrgState execute(PrgState state) {
        MyIStack<IStmt> stack = state.getStack();
        stack.push(second);
        stack.push(first);
        return state;
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ";" + second.toString() + ")";
    }
}
