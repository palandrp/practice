package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naatsms on 21.02.2017.
 */
public class Solution {

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 100);
        testStrategy(new OurHashMapStorageStrategy(), 100);
        testStrategy(new FileStorageStrategy(), 100);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        if (shortener == null || strings == null) return result;
        for (String s : strings) {
            long id = shortener.getId(s);
            result.add(id);
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        if (shortener == null || keys == null) return result;
        for (Long l : keys) {
            result.add(shortener.getString(l));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> idSet = getIds(shortener, testSet);
        Date end = new Date();
        Helper.printMessage(Long.toString(end.getTime() - start.getTime()));

        start = new Date();
        Set<String> stringSet = getStrings(shortener, idSet);
        end = new Date();
        Helper.printMessage(Long.toString(end.getTime() - start.getTime()));

        if (testSet.equals(stringSet)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

}
