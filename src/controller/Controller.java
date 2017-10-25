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
        try {
            while (true) {
                oneStep(state);
                //System.out.println(state);
            }
        }
        catch(MyStackException e) {
        }
    }
}
