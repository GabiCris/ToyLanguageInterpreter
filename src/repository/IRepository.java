package repository;

import domain.PrgState;

public interface IRepository {
    PrgState getState();
    void setState(PrgState state);
}
