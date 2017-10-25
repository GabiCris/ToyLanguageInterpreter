package controller;

import domain.MyStackException;
import domain.PrgState;

public interface IController {
    PrgState oneStep(PrgState state) throws MyStackException;
    void allStep();
}
