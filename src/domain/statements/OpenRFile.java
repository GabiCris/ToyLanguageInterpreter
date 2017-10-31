package domain.statements;

import domain.PrgState;

public class OpenRFile implements IStmt {
    private String varFileId;
    private String fileName;

    public OpenRFile(String varFileId, String fileName) {
        this.varFileId = varFileId;
        this.fileName = fileName;
    }

    @Override
    public PrgState execute(PrgState state) throws Exception {
        
        return state;
    }
}
