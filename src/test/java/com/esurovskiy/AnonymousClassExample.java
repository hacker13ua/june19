package com.esurovskiy;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class AnonymousClassExample {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello"))
                .start();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit((Callable<Object>) () ->
                "Hello world");
    }
}
