package domain.expressions;

import domain.dataStructures.MyIDictionary;

abstract public class Exp {
    public abstract int eval(MyIDictionary<String, Integer> dictionary);
}
