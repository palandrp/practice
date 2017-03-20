package com.javarush.task.task34.task3413;

import org.omg.CORBA.Any;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        try {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject obj = softReference.get();
            return obj;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public AnyObject put(Long key, AnyObject value) {
        try {
            SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<AnyObject>(value));
            AnyObject obj = softReference.get();
            softReference.clear();
            return obj;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public AnyObject remove(Long key) {
        try {
            SoftReference<AnyObject> softReference = cacheMap.remove(key);
            AnyObject obj = softReference.get();
            softReference.clear();
            return obj;
        } catch (NullPointerException e) {
            return null;
        }
    }
}