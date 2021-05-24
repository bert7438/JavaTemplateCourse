package ru.bert7438.javatemplatecourse.prac3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        SyncMap<Integer, Integer> syncMap = new SyncMap<Integer, Integer>();
        syncMap.put(1, 2);
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(3,4);
        syncMap.putAll(hashMap);
    }

}
