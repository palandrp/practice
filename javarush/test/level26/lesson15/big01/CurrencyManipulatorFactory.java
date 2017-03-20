package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class CurrencyManipulatorFactory {
    private static HashMap<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory(){}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (map.containsKey(currencyCode)) return map.get(currencyCode);
        else {
            CurrencyManipulator cm = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, cm);
            return cm;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }

}
