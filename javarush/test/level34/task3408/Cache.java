package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V obj = cache.get(key);
        if (obj == null) {
            obj = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, obj);
        }
        return obj;
    }

    public boolean put(V obj) {
        try {
            Method m = obj.getClass().getDeclaredMethod("getKey");
            m.setAccessible(true);
            K key = (K) m.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (InvocationTargetException e) {
            return false;
        } catch (IllegalAccessException e) {
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
