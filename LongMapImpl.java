package de.comparus.opensource.longmap;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LongMapImpl<V> implements LongMap<V> {

    //realized by 2 arrayLists:
    private ArrayList<Long> keySet = new ArrayList<>();
    private ArrayList<V> values = new ArrayList<>();

    public V put(long key, V value) {
        int index;
        if (keySet.isEmpty() | (index = keySet.indexOf(key)) == -1) {
            keySet.add(key);
            values.add(value);
            return null;
        } else {
            return values.set(index, value);
        }
    }

    public V get(long key) {
        int index = keySet.indexOf(key);
        //ArrayList throws an IndexOutOfBoundsException
        //but HashMap return null if keySet is not contain current key:
        return index == -1 ? null : values.get(index);
    }

    public V remove(long key) {
        int index = keySet.indexOf(key);
        if (index == -1) {
            return null;
        }
        keySet.remove(index);
        return values.remove(index);
    }

    public boolean isEmpty() {
        return keySet.isEmpty();
    }

    public boolean containsKey(long key) {
        return keySet.contains(key);
    }

    public boolean containsValue(V value) {
        return values.contains(value);
    }

    public long[] keys() {
        long[] arr = new long[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            arr[i] = keySet.get(i);
        }
        return arr;
    }

    public V[] values() {
        if (values.isEmpty()) {
            return null;
        }
        V[] arr = (V[]) Array.newInstance(values.get(0).getClass(), values.size());
        for (int i = 0; i < values.size(); i++) {
            arr[i] = values.get(i);
        }
        return arr;
    }

    public long size() {
        return keySet.size();
    }

    public void clear() {
        keySet.clear();
        values.clear();
    }
}