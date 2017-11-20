package domain;

import java.util.HashMap;
import java.util.Map;

public interface IHeap {
    int allocateHeap(int value);
    Integer readValue(int key);
    void updateHeap(int key, int value);
    Map<Integer, Integer> getHeap();
    void setHeap(Map<Integer, Integer> heap);
}
