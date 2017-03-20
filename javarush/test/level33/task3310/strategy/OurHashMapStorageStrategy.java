package com.javarush.task.task33.task3310.strategy;

/**
 * Created by Naatsms on 22.02.2017.
 */
public class OurHashMapStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;
    private int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    private int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length){
        int h = hash;
        while (h >= length) {
            h = h >> 1;
        }
        return h;
    }

    private Entry getEntry(Long key){
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry taken = table[index];
        while (!taken.key.equals(key)) {
            taken = taken.next;
            if (taken == null) return null;
        }
        return taken;
    }

    private void resize(int newCapacity){
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable){
        for (Entry entry : table) {
            if (entry != null) {
                int index = indexFor(entry.hash, newTable.length);
                if (newTable[index] == null) newTable[index] = entry;
                else {
                    Entry bucket = newTable[index];
                    while (bucket.next != null) {
                        bucket = bucket.next;
                    }
                    bucket.next = entry;
                }
                while (entry.next != null) {
                    Entry next = entry.next;
                    int indexForSub = indexFor(next.hash, table.length);
                    if (newTable[indexForSub] == null) newTable[indexForSub] = next;
                    else {
                        Entry bucket = newTable[indexForSub];
                        while (bucket.next != null) {
                            bucket = bucket.next;
                        }
                        bucket.next = next;
                    }
                }
            }
        }
        table = newTable;
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry newOne = new Entry(hash, key, value, null);
        Entry old = table[bucketIndex];
        while (old.next != null) {
            old = old.next;
        }
        old.next = newOne;
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry newOne = new Entry(hash, key, value, null);
        table[bucketIndex] = newOne;
    }

    @Override
    public boolean containsKey(Long key) {
        int hash = key.hashCode();
        Entry look = table[indexFor(hash, table.length)];
        while (!look.key.equals(key)) {
            look = look.next;
            if (look == null) return false;
        }
        return true;
    }

    @Override
    public boolean containsValue(String value) {
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int bucket = indexFor(hash, table.length);
        if (table[bucket] == null) createEntry(hash, key, value, bucket);
        else addEntry(hash, key, value, bucket);
        size++;
        if (size > threshold) resize(table.length << 1);
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : table) {
            if (entry.value.equals(value)) return entry.key;
            Entry next = entry.next;
            while (next != null) {
                if (next.value.equals(value)) return next.key;
                next = next.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null) return entry.value;
        else return null;
    }
}
