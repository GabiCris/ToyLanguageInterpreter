package domain.dataStructures;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K, V> implements MyIDictionary<K, V> {
    Map<K,V> map = new HashMap<>();

    @Override
    public void put(K key, V elem) {
        map.put(key, elem);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }
}
