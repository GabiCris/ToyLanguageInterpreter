package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Heap implements IHeap {
    private Map<Integer, Integer> heap = new HashMap<>();

    private int findNextIndex() {
        int i = 1;
        while(heap.get(i) != null) {
            i++;
        }
        return i;
    }

    @Override
    public int allocateHeap(int value) {
        int nextIndex = findNextIndex();
        heap.put(nextIndex, value);
        return nextIndex;
    }

    @Override
    public Integer readValue(int key) {
        if (key == 0) {
            return 0;
        }
        return heap.get(key);
    }

    @Override
    public void updateHeap(int key, int value) {
        heap.put(key, value);
    }

    public Map<Integer, Integer> getHeap() {
        return heap;
    }

    public void setHeap(Map<Integer, Integer> heap) {
        this.heap = heap;
    }

    @Override
    public String toString() {
        return heap.entrySet().stream()
                .map(i -> "Key: " + i.getKey() + " Value: " +i.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
