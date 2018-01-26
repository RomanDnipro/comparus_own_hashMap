package de.comparus.opensource.longmap;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LongMapImplTest {
    private LongMapImpl<String> longMapImpl;
    private HashMap<Long, String> hashMap;
    private long key = 1;
    private long notExistingKey = 8;

    @Before
    public void initTest() {
        longMapImpl = new LongMapImpl<>();
        hashMap = new HashMap<>();
        for (long i = 0; i < 3; i++) {
            String currentStringVal = "value " + i;
            longMapImpl.put(i, currentStringVal);
            hashMap.put(i, currentStringVal);
        }
    }

    @Test
    public void put() throws Exception {
        long key = 3;
        String firsStringVal = "first String Value";
        String secondStringVal = "second String Value";
        assertEquals("put entry by new key", hashMap.put(key, firsStringVal), longMapImpl.put(key, firsStringVal));
        assertEquals("put entry by old key", hashMap.put(key, secondStringVal), longMapImpl.put(key, secondStringVal));
    }

    @Test
    public void putNullValue() throws Exception {
        long key = 4;
        assertEquals("put null value to new entry", hashMap.put(key, null), longMapImpl.put(key, null));
        assertEquals("put null value to existing entry", hashMap.put(key, null), longMapImpl.put(key, null));
    }

    @Test
    public void get() throws Exception {
        assertEquals(hashMap.get(key), longMapImpl.get(key));
        assertEquals(hashMap.get(notExistingKey), longMapImpl.get(notExistingKey));
    }

    @Test
    public void remove() throws Exception {
        assertEquals("removes by existing key", hashMap.remove(key), longMapImpl.remove(key));
        assertEquals("removes by not existing key", hashMap.remove(key), longMapImpl.remove(key));
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(hashMap.isEmpty(), longMapImpl.isEmpty());
    }

    @Test
    public void containsKey() throws Exception {
        assertEquals(hashMap.containsKey(key), longMapImpl.containsKey(key));
    }

    @Test
    public void containsValue() throws Exception {
        String existingValue = hashMap.get(key);
        assertEquals(hashMap.containsValue(existingValue), longMapImpl.containsValue(existingValue));
        hashMap.remove(key);
        longMapImpl.remove(key);
        assertEquals(hashMap.containsValue(existingValue), longMapImpl.containsValue(existingValue));
    }

    @Test
    public void keys() throws Exception {
        long[] primitivesArr = longMapImpl.keys();
        Long[] wrappersArr = new Long[primitivesArr.length];
        for (int i = 0; i < primitivesArr.length; i++) {
            wrappersArr[i] = primitivesArr[i];
        }
        Set<Long> mySet = new HashSet<>(Arrays.asList(wrappersArr));
        Set<Long> hashSet = hashMap.keySet();
        mySet.removeAll(hashSet);
        assertEquals(true, mySet.isEmpty());
    }

    @Test
    public void values() throws Exception {
        Collection<String> mySet = new HashSet<>(Arrays.asList(longMapImpl.values()));
        Collection<String> hashMapValuesSet = hashMap.values();
        mySet.removeAll(hashMapValuesSet);
        assertEquals(true, mySet.isEmpty());
    }

    @Test
    public void size() throws Exception {
        assertEquals(hashMap.size(), longMapImpl.size());
    }

    @Test
    public void clear() throws Exception {
        longMapImpl.clear();
        assertEquals(true, longMapImpl.isEmpty());
    }
}