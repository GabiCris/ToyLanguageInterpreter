package domain.dataStructures;

public interface MyIDictionary<K, V> {
    void put(K key, V elem);
    V get(K key);
}