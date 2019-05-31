package cn.net.zhipeng.web.service;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static void main(String[] args) {
        AtomicInteger j = new AtomicInteger(0);

        new Thread(j::incrementAndGet).start();
        new Thread(j::incrementAndGet).start();
        new Thread(j::decrementAndGet).start();
        new Thread(j::decrementAndGet).start();
    }
}
