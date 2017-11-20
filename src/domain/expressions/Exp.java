package domain.expressions;

import domain.IHeap;
import domain.dataStructures.MyIDictionary;

import java.util.Map;

abstract public class Exp {
    public abstract int eval(MyIDictionary<String, Integer> dictionary, IHeap heap) throws Exception;
}
