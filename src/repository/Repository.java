package repository;

import domain.PrgState;

public class Repository implements IRepository {
    private PrgState state;

    public PrgState getState() {
        return state;
    }

    public void setState(PrgState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "state=" + state +
                '}';
    }
}
