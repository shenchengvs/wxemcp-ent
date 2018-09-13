package com.holley.wxemcp.ent.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Test implements Callable<String> {

    private int     timeout = 10;
    private boolean flag    = true;

    @Override
    public String call() throws Exception {
        while (true) {
            System.out.println(timeout);
            if (timeout <= 0) {
                return "timeout";
            }
            if (false) {
                return "ok";
            } else {
                timeout--;
                TimeUnit.SECONDS.sleep(1);
            }
        }

    }

}
