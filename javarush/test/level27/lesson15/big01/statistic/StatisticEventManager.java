package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticEventManager {
    private static StatisticEventManager ourInstance = new StatisticEventManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticEventManager getInstance() {
        return ourInstance;
    }

    private StatisticEventManager() {
    }
    // register a new row of statistic data
    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public Map<Date, Long> getAdvertismentProfit() {
        Map<Date, Long> profit = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = statisticStorage.getData(EventType.SELECTED_VIDEOS);
        for (EventDataRow ed : list) {
            VideoSelectedEventDataRow row = (VideoSelectedEventDataRow) ed;
            Date date = setTimeToMidnight(row.getDate());
            Long cash = row.getAmount();
            if (profit.containsKey(date)) {
                cash += profit.get(date);
            }
            profit.put(date, cash);
        }
        return profit;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        Map<Date, Map<String, Integer>> workloading = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> list = statisticStorage.getData(EventType.COOKED_ORDER);
        for (EventDataRow ed : list) {
            CookedOrderEventDataRow row = (CookedOrderEventDataRow) ed;
            int time = row.getTime();
            String name = row.getCookName();
            Date date = setTimeToMidnight(row.getDate());

            if (workloading.containsKey(date)) {
                Map<String, Integer> map = workloading.get(date);
                if (map.containsKey(name)) {
                    time += workloading.get(date).get(name);
                }
                map.put(name, time);
            }
            else {
                workloading.put(date, new TreeMap<String, Integer>());
                workloading.get(date).put(name, time);
            }
        }
        return workloading;
    }


    //Storage of statistic data
    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> map;

        public StatisticStorage() {
            map = new HashMap<>();
            for (EventType t : EventType.values()) {
                map.put(t, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
        }

        private List<EventDataRow> getData(EventType type) {
            return map.get(type);
        }

    }

    private Date setTimeToMidnight(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

}
