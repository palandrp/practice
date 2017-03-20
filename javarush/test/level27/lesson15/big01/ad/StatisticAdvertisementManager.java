package com.javarush.test.level27.lesson15.big01.ad;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StatisticAdvertisementManager {
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public Set<Advertisement> getVideoSet(boolean active){
        Set<Advertisement> set = new TreeSet<>(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        if (active) {
            for (Advertisement ad : storage.list()) {
                if (ad.getHits() > 0) set.add(ad);
            }
        }
        else {
            for (Advertisement ad : storage.list()) {
                if (ad.getHits() == 0) set.add(ad);
            }
        }
        return set;
    }
}
