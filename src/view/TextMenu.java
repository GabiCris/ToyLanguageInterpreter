package view;

import controller.Controller;
import domain.PrgState;
import domain.dataStructures.MyDictionary;
import domain.dataStructures.MyList;
import domain.dataStructures.MyStack;
import domain.expressions.ArithmeticExp;
import domain.expressions.ConstantExp;
import domain.expressions.VarExp;
import domain.statements.*;
import repository.IRepository;
import repository.Repository;
import view.commands.Command;
import view.commands.ExitCommand;
import view.commands.RunExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextMenu {
    private Map<String, Command> commands;

    public TextMenu() {
        commands = new HashMap<>();
    }

    public void addCommand(Command command) {
        commands.put(command.getKey(), command);
    }

    public void printMenu() {
        for (Command c: commands.values()) {
            String line = String.format("%4s : %s", c.getKey(), c.getDescription());
            System.out.println(line);
        }
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            initValues();
            System.out.println("\nAvailable example statements:");
            printMenu();
            System.out.println("Input the option: ");
            String key = scanner.nextLine();
            Command com = commands.get(key);

            if (com == null) {
                System.out.println("Invalid Option.");
                continue;
            }
            com.execute();
        }
    }
    private void initValues() {
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
                                new AssignStmt("v", new ConstantExp(2)),
                                new AssignStmt("v", new ConstantExp(3))),
                        new PrintStmt(new VarExp("v"))));

        IStmt example4 = new CompStmt(
                new OpenRFile("var_f", "C:\\Users\\n3zqi\\IdeaProjects\\ToyLanguageInterpreter\\src\\test.in"),
                new CompStmt(
                        new CompStmt(
                                new ReadFile(new VarExp("var_f"), "var_c"),
                                new PrintStmt(new VarExp("var_c"))
                        ),
                        new CompStmt(
                                new IfStmt(
                                        new VarExp("var_c"),
                                        new CompStmt(
                                                new ReadFile(new VarExp("var_f"), "var_c"),
                                                new PrintStmt(new VarExp("var_c"))
                                        ),
                                        new PrintStmt(new ConstantExp(0))
                                ),
                                new CloseRFile(new VarExp("var_f"))
                        )
                )
        );

        commands.put("0", new ExitCommand("0", "Exit menu"));

        PrgState prgState1 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), example1);
        IRepository repo1 = new Repository(prgState1, "log1.txt");
        Controller ctrl1 = new Controller(repo1);
        commands.put("1", new RunExample("1", example1.toString(), ctrl1));

        PrgState prgState2 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), example2);
        IRepository repo2 = new Repository(prgState2, "log2.txt");
        Controller ctrl2 = new Controller(repo2);
        commands.put("2", new RunExample("2", example2.toString(), ctrl2));

        PrgState prgState3 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), example3);
        IRepository repo3 = new Repository(prgState3, "log3.txt");
        Controller ctrl3 = new Controller(repo3);
        commands.put("3", new RunExample("3", example3.toString(), ctrl3));

        PrgState prgState4 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), example4);
        IRepository repo4 = new Repository(prgState4, "log4.txt");
        Controller ctrl4 = new Controller(repo4);
        commands.put("4", new RunExample("4", example4.toString(), ctrl4));
    }
}
