package com.holley.wxemcp.ent.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JobUtil {

    private final static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

    public static void execute(Runnable task) {
        cacheThreadPool.execute(task);
    }

    public static <T> T call(Callable<T> task) {
        try {
            return cacheThreadPool.submit(task).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T call(Callable<T> task, long timeOut) {
        try {
            return cacheThreadPool.submit(task).get(timeOut, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closePool() {
        if (!cacheThreadPool.isShutdown()) {
            cacheThreadPool.shutdown();
        }
    }
}
