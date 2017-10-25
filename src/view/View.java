package view;

import controller.Controller;
import controller.IController;
import domain.PrgState;
import domain.dataStructures.*;
import domain.expressions.ArithmeticExp;
import domain.expressions.ConstantExp;
import domain.expressions.VarExp;
import domain.statements.*;
import repository.IRepository;
import repository.Repository;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        IRepository repository = new Repository();
        IController controller = new Controller(repository);
        MyIStack<IStmt> exeStack = new MyStack<>();
        MyIDictionary<String, Integer> symTable = new MyDictionary<>();
        MyIList<Integer> outputList = new MyList<>();

        IStmt example1 = new CompStmt(
                new AssignStmt("v",new ConstantExp(2)),
                new PrintStmt(new VarExp("v")));

        IStmt example2 = new CompStmt(
                new AssignStmt("a",
                        new ArithmeticExp('+',
                                new ConstantExp(2),
                                new ArithmeticExp('*', new ConstantExp(3), new ConstantExp(5)))),
                new CompStmt(
                        new AssignStmt("b",
                                new ArithmeticExp('+', new VarExp("a"), new ConstantExp(1))),
                        new PrintStmt(new VarExp("b"))));

        IStmt example3 = new CompStmt(
                new AssignStmt("a",
                        new ArithmeticExp('-',new ConstantExp(2), new ConstantExp(2))),
                new CompStmt(
                        new IfStmt(
                                new VarExp("a"),
                                new AssignStmt("v",new ConstantExp(2)),
                                new AssignStmt("v", new ConstantExp(3))),
                        new PrintStmt(new VarExp("v"))));

        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an example to evaluate: \n" +
                    "1. v=2; Print(v)\n" +
                    "2. a=2+3*5; b=a+1; Print(b)\n" +
                    "3. a=2-2; (If a Then v=2 Else v=3); Print(v)\n" +
                    "0. exit\n");

            System.out.println("Your choice: ");
            int choice = keyboard.nextInt();
            PrgState state;

            switch (choice) {
                case 1: state = new PrgState(exeStack, symTable, outputList, example1);
                        break;
                case 2: state = new PrgState(exeStack, symTable, outputList, example2);
                        break;
                case 3: state = new PrgState(exeStack, symTable, outputList, example3);
                        break;
                case 0: System.exit(0);
                default: System.out.println("Invalid input, using example no. 1!");
                        state = new PrgState(exeStack, symTable, outputList, example1);
                        break;
            }
            repository.setState(state);
            controller.allStep();
        }
    }
}
