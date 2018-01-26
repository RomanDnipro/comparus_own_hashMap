package de.comparus.opensource.longmap;

import java.lang.Long;

public class LongKeyEntry<V> implements MyEntry<Long, V>, Comparable<LongKeyEntry> {

    private final Long key;
    private V value;

    public LongKeyEntry(Long key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Long getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    @Override
    public int compareTo(LongKeyEntry anotherEntry) {
        return key.compareTo(anotherEntry.key);
    }

}
