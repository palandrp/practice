package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    final private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) throw new NoVideoAvailableException();
        ArrayList<Advertisement> source = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.getHits() > 0 && ad.getDuration() <= timeSeconds) source.add(ad);
        }

        if (source.isEmpty()) throw new NoVideoAvailableException();

        @SuppressWarnings("unchecked")
        List<Advertisement> result = (List<Advertisement>)findBestList(source, timeSeconds);

        Collections.sort(result, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying() ?
                        (int)(o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying()) :
                        (int)(o1.getAmountPerOneSecond() - o2.getAmountPerOneSecond());
            }
        });
        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(
                result,
                getAmount(result),
                getTime(result)));
        //register selected videoset
        for (Advertisement ad : result) {
            ConsoleHelper.writeMessage(ad.toString());
            ad.revalidate();
        }


    }
    @SuppressWarnings("unchecked")
    private List findBestList(List<Advertisement> source, int seconds) {
        List[][] result = new ArrayList[source.size() + 1][seconds + 1];
        for (int i = 0; i <= seconds; i++) {
            result[0][i] = new ArrayList<Advertisement>();
        }
        for (int i = 0; i <= source.size(); i++) {
            result[i][0] = new ArrayList<Advertisement>();
        }

        for (int i = 1; i <= source.size(); i++) {
            for (int j = 1; j <= seconds; j++) {
                ArrayList<Advertisement> oldList = new ArrayList<>(result[i-1][j]);
                result[i][j] = oldList;
                Advertisement ad = source.get(i - 1);
                if (ad.getDuration() <= j) {
                    ArrayList<Advertisement> newList = new ArrayList<>(result[i - 1][j - ad.getDuration()]);
                    newList.add(ad);
                    result[i][j] = MaxList(oldList, newList);
                }
            }
        }
        return result[source.size()][seconds];
    }

    private List<Advertisement> MaxList(List<Advertisement> o1, List<Advertisement> o2) {
        if (getAmount(o1) > getAmount(o2)) return o1;
        else if (getAmount(o2) > getAmount(o1)) return o2;
        else if (getTime(o1) > getTime(o2)) return o1;
        else if (getTime(o2) > getTime(o1)) return o2;
        else if (o1.size() > o2.size()) return o2;
        else return o1;
    }

    private int getAmount(List<Advertisement> ads) {
        int result = 0;
        for (Advertisement ad : ads) {
            result += ad.getAmountPerOneDisplaying();
        }
        return result;
    }

    private int getTime(List<Advertisement> ads) {
        int result = 0;
        for (Advertisement ad : ads) {
            result += ad.getDuration();
        }
        return result;
    }

}
