package domain.statements;

import domain.IFileTable;
import domain.MyException;
import domain.PrgState;
import domain.dataStructures.FileTouple;
import domain.dataStructures.MyIDictionary;
import domain.expressions.Exp;

public class ReadFile implements IStmt {
    private Exp expression;
    private String varName;

    public ReadFile(Exp expression, String varName) {
        this.expression = expression;
        this.varName = varName;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        IFileTable fileTable = state.getFileTable();
        int expressionValue = expression.eval(symTable);
        FileTouple fileTouple = fileTable.get(expressionValue);
        if (fileTouple == null) {
            throw new MyException("Trying to read from unopened file!");
        }

        int valueToAdd = 0;
        String line = fileTouple.getFileReader().readLine();
        if (line != null && !line.isEmpty()) {
            valueToAdd = Integer.parseInt(line);
        }
        symTable.put(varName, valueToAdd);

        return state;
    }

    @Override
    public String toString() {
        return "ReadFile(" + expression + ", " + varName + ")";
    }
}
