package domain;

import domain.dataStructures.MyIDictionary;
import domain.dataStructures.MyIList;
import domain.dataStructures.MyIStack;
import domain.statements.IStmt;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIList<Integer> output;
    private IStmt originalProgram;
    private IFileTable fileTable = new FileTable();
    private IHeap heap = new Heap();

    public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<String, Integer> symTable, MyIList<Integer> output, IStmt program) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.output = output;
        this.originalProgram = program;
        this.exeStack.push(program);
    }

    @Override
    public String toString() {
        return "PrgState{" +
                "exeStack=" + exeStack +
                ", symTable=" + symTable +
                ", output=" + output +
                '}';
    }

    public MyIStack<IStmt> getStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Integer> getOutput() {
        return output;
    }

    public void setOutput(MyIList<Integer> output) {
        this.output = output;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(IStmt originalProgram) {
        this.originalProgram = originalProgram;
    }

    public IFileTable getFileTable() {
        return fileTable;
    }

    public void setFileTable(IFileTable fileTable) {
        this.fileTable = fileTable;
    }

    public IHeap getHeap() {
        return heap;
    }

    public void setHeap(IHeap heap) {
        this.heap = heap;
    }
}
