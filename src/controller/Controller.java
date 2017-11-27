package controller;

import domain.Heap;
import domain.IHeap;
import domain.MyStackException;
import domain.PrgState;
import domain.dataStructures.FileTouple;
import domain.dataStructures.MyIStack;
import domain.statements.IStmt;
import repository.IRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;


public class Controller implements IController {
    private IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

   /* public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        String res = s.stream()
                .map(i -> i.toString() + " ")
                .collect(Collectors.joining());
        System.out.println(res);
    }*/

    @Override
    public PrgState oneStep(PrgState state) throws Exception {
        MyIStack<IStmt> stack = state.getStack();
        if (stack.isEmpty()) {
            throw new MyStackException("Execution Stack is empty!");
        }
        IStmt currentStmt = stack.pop();
        try {
            return currentStmt.execute(state);
        } catch (Exception e) {
            throw e;
        }
    }

    private Map<Integer, Integer> garbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heapMap) {
        return heapMap.entrySet().stream()
                .filter(i -> symTableValues.contains(i.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void allStep() throws Exception {
        PrgState state = repository.getState();
        try {
            while (true) {
                oneStep(state);
                state.getHeap().setHeap(
                        garbageCollector(state.getSymTable().getMap().values(), state.getHeap().getHeap()));
                repository.logProgramStateExec();
            }
        }
        catch (MyStackException ex) {}
        catch(Exception e) {
            throw e;
        }
        finally {
            repository.getLogFile().close();
            state.getFileTable().getFileTable().getMap().values().stream()
                    .map(FileTouple::getFileReader)
                    .forEach(i -> {
                        try {
                            i.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
