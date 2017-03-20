package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by Naatsms on 20.02.2017.
 */
public class CachingProxyRetriever implements Retriever {
    private LRUCache lruCache = new LRUCache(10);
    private OriginalRetriever originalRetriever;

    public Object retrieve(long id) {
        Object obj = lruCache.find(id);
        if (obj != null) return obj;
        else {
            obj = originalRetriever.retrieve(id);
            lruCache.set(id, obj);
            return obj;
        }
    }

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

}
