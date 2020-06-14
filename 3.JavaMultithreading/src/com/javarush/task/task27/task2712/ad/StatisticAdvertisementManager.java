package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager statisticAdvertisementManager;
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){}

    public static StatisticAdvertisementManager getInstance(){
        if(statisticAdvertisementManager == null)
            synchronized (StatisticAdvertisementManager.class){
            if(statisticAdvertisementManager == null){
                statisticAdvertisementManager = new StatisticAdvertisementManager();
            }
            }
        return statisticAdvertisementManager;
    }

    public List<Advertisement> getActiveAdvertisement(boolean isActive){
    List<Advertisement> videos = new ArrayList<>();
    for(Advertisement ad : advertisementStorage.list()){
        if(!isActive && ad.getHits() == 0){
            videos.add(ad);
        }
        if(isActive && ad.getHits() != 0){
            videos.add(ad);
        }
    }
        Collections.sort(videos, new Comparator<Advertisement>(){

            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    return videos;
    }
}
