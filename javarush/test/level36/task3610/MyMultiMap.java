package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        if (repeatCount == 0) throw new UnsupportedOperationException();
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            if (list.size() == repeatCount) {
                list.remove(0);
            }
            list.add(value);
            if (list.size() > 1) return list.get(list.size() - 2);
            else return null;
        }
        else {
            List<V> list = new LinkedList<V>();
            list.add(value);
            map.put(key, list);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            if (list.size() == 1) {
                map.remove(key);
                return list.get(0);
            }
            else {
                return list.remove(0);
            }
        } else return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<List<V>> list = new ArrayList<>(map.values());
        Collection<V> result = new ArrayList<V>();
        for (List<V> list1 : list) {
            result.addAll(list1);
        }
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}