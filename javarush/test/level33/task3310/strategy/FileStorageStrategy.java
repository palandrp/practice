package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = 10000;
    private int size;

    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

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
        Entry taken = table[index].getEntry();
        while (!taken.key.equals(key)) {
            taken = taken.next;
            if (taken == null) return null;
        }
        return taken;
    }

    private void resize(int newCapacity){
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
    }

    private void transfer(FileBucket[] newTable){
        for (FileBucket fileBucket : table) {
            Entry entry = fileBucket.getEntry();
            int index = indexFor(entry.hash, newTable.length);
            if (newTable[index] == null) {
                createEntry(entry.hash, entry.key, entry.value, index);
            }
            else {
                addEntry(entry.hash, entry.key, entry.value, index);
            }
            while (entry.next != null) {
                Entry next = entry.next;
                int indexForSub = indexFor(next.hash, table.length);
                if (newTable[indexForSub] == null) {
                    createEntry(next.hash, next.key, next.value, indexForSub);
                }
                else {
                    addEntry(next.hash, next.key, next.value, indexForSub);
                }
                entry = next;
            }
            fileBucket.remove();
        }
        table = newTable;
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex){
        FileBucket current = table[bucketIndex];
        if (current.getFileSize() == 0) current.putEntry(new Entry(hash, key, value, null));
        else {
            Entry old = current.getEntry();
            if (old.key.equals(key)) {
                old.value = value;
            }
            else {
                if (old.next == null) {
                    old.next = new Entry(hash, key, value, null);
                }
                else {
                    Entry next = old.next;
                    while (next != null) {
                        if (next.key.equals(key)) {
                            next.value = value;
                            break;
                        }
                        else if (next.next == null) {
                            next.next = new Entry(hash, key, value, null);
                            break;
                        }
                        next = next.next;
                    }
                }

            }
            current.putEntry(old);
        }
        if (current.getFileSize() > bucketSizeLimit) resize(table.length << 1);
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex){
        Entry newOne = new Entry(hash, key, value, null);
        FileBucket current = new FileBucket();
        table[bucketIndex] = current;
        current.putEntry(newOne);
        if (current.getFileSize() > bucketSizeLimit) resize(table.length << 1);
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    @Override
    public boolean containsKey(Long key) {
        Entry current = getEntry(key);
        while (!current.key.equals(key)) {
            current = current.next;
            if (current == null) return false;
        }
        return true;
    }
    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] == null) createEntry(hash, key, value, index);
        else addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket bucket : table) {
            if (bucket != null) {
                Entry entry = bucket.getEntry();
                if (entry.value.equals(value)) return entry.key;
                Entry next = entry.next;
                while (next != null) {
                    if (next.value.equals(value)) return next.key;
                    next = next.next;
                }
            }
        }
        return null;
    }

    @Override
    public boolean containsValue(String value) {
        if (getKey(value) == null) return false;
        return true;
    }


    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null) return entry.value;
        else return null;
    }
}
