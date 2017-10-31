package repository;

import domain.PrgState;

import java.io.PrintWriter;

public interface IRepository {
    PrgState getState();
    void setState(PrgState state);
    void logProgramStateExec();
    public PrintWriter getLogFile();
}
