package view;

public class Dummy {
    public Integer i;
    public String s;

    public Dummy(Integer i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }
}
