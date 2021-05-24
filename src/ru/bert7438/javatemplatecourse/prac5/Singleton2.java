package ru.bert7438.javatemplatecourse.prac5;

public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2() {
        System.out.println("Singleton 2 - modified - Double-Checked Locking");
    }
    public static Singleton2 getInstance() {
        if (instance == null)
            synchronized (Singleton2.class) {
                if (instance == null)
                    instance = new Singleton2();
            }
        return instance;
    }
}
