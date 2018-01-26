package de.comparus.opensource.longmap;

public interface MyEntry<K, V> {
    K getKey();

    V getValue();

    V setValue(V newValue);
}
