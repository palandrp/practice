package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CurrencyManipulator {
    public String currencyCode;
    public Map<Integer, Integer> denominations;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new TreeMap<>(Collections.<Integer>reverseOrder());
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else denominations.put(denomination, count);
    }

    public int getTotalAmount(){
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            result += pair.getKey() * pair.getValue();
        }
        return result;
    }

    public boolean hasMoney() {
        return getTotalAmount() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.<Integer>reverseOrder());
        Iterator<Map.Entry<Integer, Integer>> it = denominations.entrySet().iterator();

        int current = 0;
        while (it.hasNext() && current != expectedAmount) {
            map.clear();
            current = 0;
            int startCupper = it.next().getKey();
            for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
                int cupper = pair.getKey();
                int amount = pair.getValue();
                if (cupper <= startCupper) {
                    while (expectedAmount - current >= cupper && amount > 0) {
                        current += cupper;
                        amount--;
                        if (map.containsKey(cupper)) map.put(cupper, map.get(cupper) + 1);
                        else map.put(cupper, 1);
                    }
                }
            }
        }

        if (current == expectedAmount) {
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                int cur = denominations.get(pair.getKey());
                if (pair.getValue() == cur) denominations.remove(pair.getKey());
                else denominations.put(pair.getKey(), cur - pair.getValue());
            }
            return map;
        }
        throw new NotEnoughMoneyException();
    }

}
