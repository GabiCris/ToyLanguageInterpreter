package domain.dataStructures;

import java.util.Map;

public interface MyIDictionary<K, V> {
    void put(K key, V elem);
    V get(K key);
    public String toStringFile();
    boolean isValueInDictionary(V value);
    void deleteEntry(K key);
    public Map<K, V> getMap();
}