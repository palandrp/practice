package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class DirectorTablet {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
    private StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
    private StatisticEventManager statisticEventManager = StatisticEventManager.getInstance();

    public void printAdvertisementProfit() {
        Map<Date, Long> data = statisticEventManager.getAdvertismentProfit();
        double total = 0;
        for (Map.Entry<Date, Long> pair : data.entrySet()) {
            double value = pair.getValue();
            total += value;
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(pair.getKey()), value / 100));
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total / 100));
        ConsoleHelper.writeMessage("");
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> data = statisticEventManager.getCookWorkloading();
        for (Map.Entry<Date, Map<String, Integer>> pair : data.entrySet()) {
            ConsoleHelper.writeMessage(dateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> sPair : pair.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", sPair.getKey(), toMinutes(sPair.getValue())));
            }
        }
        ConsoleHelper.writeMessage("");
    }

    public void printActiveVideoSet() {
        Set<Advertisement> set = statisticAdvertisementManager.getVideoSet(true);
        for (Advertisement ad : set) {
            ConsoleHelper.writeMessage(String.format("%s - %d", ad.getName(), ad.getHits()));
        }
        ConsoleHelper.writeMessage("");
    }

    public void printArchivedVideoSet() {
        Set<Advertisement> set = statisticAdvertisementManager.getVideoSet(false);
        for (Advertisement ad : set) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }

    private static int toMinutes(int seconds) {
        if (seconds % 60 == 0) {
            return seconds / 60;
        }
        else return seconds / 60 + 1;
    }

}
