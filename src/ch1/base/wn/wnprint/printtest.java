package ch1.base.wn.wnprint;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 打印测试
 */
public class printtest {
    // 控制器:控制main线程将会等待所有Woker结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) {
        //线程数量10
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Worker(map),
                    "worker_" + i);
            thread.start();
        }
    }

    static class Worker implements Runnable {


        public Worker(ConcurrentHashMap<String, Object> map) {

        }

        @Override
        public void run() {

        }
    }
}
