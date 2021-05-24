package ru.bert7438.javatemplatecourse.prac4;

import java.util.Random;

public class PersonGenerator implements Runnable{
    private String[] names = {"Albert", "Aboba", "Boris", "Foma", "Hiro", "Ivan", "Igor", "Makoto"};
    private Random random = new Random();
    @Override
    public void run() {
        try{
            System.out.println(names[random.nextInt(names.length)]);
            Thread.sleep(random.nextInt(150)+100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Running it");
    }
}
