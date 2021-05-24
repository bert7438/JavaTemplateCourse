package ru.bert7438.javatemplatecourse.prac3;

import java.util.ArrayList;

public class Main {

    static class thread1 extends Thread{
        public void run(){
            SyncMap<Integer, String> syncMap = new SyncMap<Integer, String>();
            syncMap.put(1, "One");
            syncMap.put(2, "Two");
            syncMap.put(3, "Three");
            syncMap.put(4, "Four");

            System.out.println(syncMap);
            System.out.println(syncMap.containsKey(2));
            System.out.println(syncMap.remove(4));
            System.out.println(syncMap);
        }
    }

    static class thread2 extends Thread{
        public void run(){
            SyncList<Integer> syncList = new SyncList<>();
            syncList.add(1);
            syncList.add(2);
            syncList.add(3);
            syncList.add(4);
            System.out.println(syncList);
            System.out.println(syncList.contains(2));
            System.out.println(syncList.indexOf(2));
        }
    }

    public static void main(String[] args) {
        thread1 t1 = new thread1();
        t1.start();
        System.out.println();
        thread2 t2 = new thread2();
        t2.start();
    }

}
