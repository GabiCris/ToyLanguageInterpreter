package domain.statements;

import domain.IFileTable;
import domain.MyException;
import domain.PrgState;
import domain.dataStructures.FileTouple;
import domain.expressions.Exp;

public class CloseRFile implements IStmt {
    private Exp expression;

    public CloseRFile(Exp expression) {
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        IFileTable fileTable = state.getFileTable();
        int expressionValue = expression.eval(state.getSymTable(), state.getHeap());

        FileTouple fileTouple = fileTable.get(expressionValue);
        if (fileTouple == null) {
            throw new MyException("Trying to read from unopened file!");
        }
        fileTouple.getFileReader().close();
        fileTable.deleteEntry(expressionValue);

        return state;
    }

    @Override
    public String toString() {
        return "CloseFile(" + expression + ")";
    }
}
