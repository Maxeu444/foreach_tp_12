package org.example.bimap;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class BiMap<K, V> {
    private Map<K, V> keyToValueMap;
    private Map<V, Set<K>> valueToKeysMap;

    public void BiDirectionalMap() {
        this.keyToValueMap = new HashMap<>();
        this.valueToKeysMap = new HashMap<>();
    }

    public void put(K key, V value) {
        // Supprimer l'ancienne association si la clé existe
        if (keyToValueMap.containsKey(key)) {
            V oldValue = keyToValueMap.get(key);
            valueToKeysMap.get(oldValue).remove(key);
            if (valueToKeysMap.get(oldValue).isEmpty()) {
                valueToKeysMap.remove(oldValue);
            }
        }

        keyToValueMap.put(key, value);
        valueToKeysMap.computeIfAbsent(value, k -> new HashSet<>()).add(key);
    }

    public void removeKey(K key) {
        if (!keyToValueMap.containsKey(key)) return;

        V value = keyToValueMap.remove(key);
        Set<K> keys = valueToKeysMap.get(value);
        keys.remove(key);

        if (keys.isEmpty()) {
            valueToKeysMap.remove(value);
        }
    }

    public void removeValue(V value) {
        if (!valueToKeysMap.containsKey(value)) return;

        Set<K> keys = valueToKeysMap.remove(value);
        for (K key : keys) {
            keyToValueMap.remove(key);
        }
    }

    public V getValue(K key) {
        return keyToValueMap.get(key);
    }

    public Set<K> getKeysForValue(V value) {
        return valueToKeysMap.getOrDefault(value, Collections.emptySet());
    }

    public boolean containsKey(K key) {
        return keyToValueMap.containsKey(key);
    }

    public boolean containsValue(V value) {
        return valueToKeysMap.containsKey(value);
    }

    @Override
    public String toString() {
        return "KeyToValueMap: " + keyToValueMap + "\nValueToKeysMap: " + valueToKeysMap;
    }
}

