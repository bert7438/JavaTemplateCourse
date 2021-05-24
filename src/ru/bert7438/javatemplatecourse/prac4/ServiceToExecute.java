package ru.bert7438.javatemplatecourse.prac4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceToExecute {
    private ExecutorService executorService;
    private Random random = new Random();
    public ServiceToExecute(int num){
        executorService = Executors.newFixedThreadPool(num);
        int threads = random.nextInt(15) + 1;
        System.out.println("Number of threads: " + threads + " for entered " + num + '\n');
        for(int i = 0; i<threads;++i){
            System.out.println((i+1) + " thread");
            executorService.execute(new PersonGenerator());
        }

        executorService.shutdown();
        System.out.println("Successfully ended");
    }
}
