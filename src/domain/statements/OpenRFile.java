package domain.statements;

import domain.IFileTable;
import domain.MyException;
import domain.PrgState;
import domain.dataStructures.FileTouple;

import java.io.*;

public class OpenRFile implements IStmt {
    private String varFileId;
    private String fileName;

    public OpenRFile(String varFileId, String fileName) {
        this.varFileId = varFileId;
        this.fileName = fileName;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        IFileTable fileTable = state.getFileTable();
        if (fileTable.isInTable(fileName)) {
            throw new MyException("Trying to open a file which already exists in the FileTable!");
        }

        BufferedReader fileBuffer = new BufferedReader(new FileReader(fileName));
        Integer fileKey = fileTable.put(new FileTouple(fileName, fileBuffer));
        state.getSymTable().put(varFileId, fileKey);

        return state;
    }

    @Override
    public String toString() {
        return "OpenFile(" + varFileId + ", " + fileName + ")";
    }
}
