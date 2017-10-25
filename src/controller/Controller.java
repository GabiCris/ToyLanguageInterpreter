package controller;

import domain.MyStackException;
import domain.PrgState;
import domain.dataStructures.MyIStack;
import domain.statements.IStmt;
import repository.IRepository;

public class Controller implements IController {
    private IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public PrgState oneStep(PrgState state) throws MyStackException {
        MyIStack<IStmt> stack = state.getStack();
        if (stack.isEmpty()) {
            throw new MyStackException("Execution Stack is empty!");
        }
        IStmt currentStmt = stack.pop();
        return currentStmt.execute(state);
    }

    @Override
    public void allStep() {
        PrgState state = repository.getState();
        String s="";
        try {
            while (true) {
                oneStep(state);
            }
        }
        catch(MyStackException e) {
        }
    }
}
