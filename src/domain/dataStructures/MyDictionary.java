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

    @Override
    public String toString() {
        return map.toString();
    }

    public String toStringFile() {
        String msg = "";
        for (Map.Entry<K,V> entry: map.entrySet()) {
            msg += entry.getKey().toString() + "=" + entry.getValue().toString() + System.lineSeparator();
        }
        return msg;
    }

    @Override
    public void deleteEntry(K key) {
        map.remove(key);
    }

    @Override
    public boolean isValueInDictionary(V value) {
        return map.values()
                .stream()
                .anyMatch(item -> item.equals(value));
    }
}
