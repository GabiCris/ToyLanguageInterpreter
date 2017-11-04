package repository;

import domain.PrgState;

import java.io.*;

public class Repository implements IRepository {
    private PrgState state;
    private String logFilePath;

    public PrintWriter getLogFile() {
        return logFile;
    }

    private PrintWriter logFile;

    public Repository(String logFilePath) {
        this.logFilePath = logFilePath;
        File file = new File(logFilePath);
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logProgramStateExec() {
        logFile.println("################################");
        logFile.println("Execution Stack\n");
        logFile.println(state.getStack().toStringFile());
        logFile.println("Symbol Table\n");
        logFile.println(state.getSymTable().toStringFile());
        logFile.println("Output\n");
        logFile.println(state.getOutput().toStringFile());
        logFile.println("File Table\n");
        logFile.println(state.getFileTable());
        logFile.println();
    }

    public PrgState getState() {
        return state;
    }

    public void setState(PrgState state) {
        this.state = state;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "state=" + state +
                '}';
    }
}
