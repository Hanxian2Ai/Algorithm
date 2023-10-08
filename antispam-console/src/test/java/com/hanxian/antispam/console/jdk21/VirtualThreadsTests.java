package com.hanxian.antispam.console.jdk21;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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

    @Test
    void LockTest() throws InterruptedException {
        ThreadFactory threadFactory = Thread.ofVirtual().name("coroutine-", 0).factory();
        // 换成synchronized全部串行
        // lock底层使用的java.util.concurrent.locks.LockSupport#park有对虚拟线程的特殊处理
        Lock lock = new ReentrantLock();
        IntStream.range(0, 10_000).forEach(i -> threadFactory.newThread(() -> {
            lock.lock();
            try {
                Thread.sleep(Duration.ofMillis(1));
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }).start());

        IntStream.range(10_000, 20_000).forEach(i -> threadFactory.newThread(() -> {
            try {
                Thread.sleep(Duration.ofSeconds(10));
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start());

        Thread.sleep((Duration.ofSeconds(100)));
    }

    @Test
    void StructuredTaskScopeTest() throws InterruptedException {
        try (var scope = new StructuredTaskScope<String>()) {
            IntStream.range(0, 10_000).forEach(i -> scope.fork(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(10));
                    System.out.println(Thread.currentThread().getName() + " " + i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return null;
            }));
            scope.join();
        }
        System.out.println("success");
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