package ch1.base.threadlocal;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * threadLocal造成的内存泄露演示
 */
public class ThreadLocalOOM {

    private static final int TASK_LOOP_SIZE = 500;

    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

    static class LocalVariable {
        private byte[] a = new byte[1024 * 1024 * 5];
    }

    ThreadLocal<LocalVariable> localVariableThreadLocal;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < TASK_LOOP_SIZE; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadLocalOOM threadLocalOOM =  new ThreadLocalOOM();
                    threadLocalOOM.localVariableThreadLocal =new ThreadLocal<>();
                    threadLocalOOM.localVariableThreadLocal.set(new LocalVariable());
                    System.out.println(threadLocalOOM.localVariableThreadLocal.get());
                    System.out.println("use local varaible");
                    threadLocalOOM.localVariableThreadLocal.remove();
                }
            });
            Thread.sleep(100);
        }
        System.out.println("pool execute over");
    }


}
