package domain.statements;

import domain.PrgState;

public interface IStmt {
    PrgState execute(PrgState state) throws Exception;
}
