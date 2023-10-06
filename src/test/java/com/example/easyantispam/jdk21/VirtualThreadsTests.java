package com.example.easyantispam.jdk21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


@SpringBootTest
public class VirtualThreadsTests {

    @Test
    void test(){
        Thread.ofVirtual()
                .name("thread-test1")
                .start(new SimpleThread());
        //or
        Thread thread = Thread.ofVirtual()
                .name("thread-test2")
                .uncaughtExceptionHandler((t, e) -> {
                    System.out.println(t.getName() + e.getMessage());
                })
                .unstarted(new SimpleThread());
        thread.start();

    }
    @Test
     void createVirtualThreads(){
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }
    }

    static class SimpleThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
