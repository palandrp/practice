package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(versionHistoryMap);
        boolean isFinded = false;
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            if (isFinded) versionHistoryMap.remove(pair.getKey());
            if (pair.getKey() == rollbackVersion) {
                isFinded = true;
                currentVersion = pair.getKey();
            }
        }
        return isFinded;
    }
}
