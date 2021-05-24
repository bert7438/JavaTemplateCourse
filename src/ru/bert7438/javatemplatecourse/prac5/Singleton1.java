package ru.bert7438.javatemplatecourse.prac5;

public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1(){
        System.out.println("Singleton1 - easy way");
    }
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
            return instance;
        }
        return instance;
    }
}

