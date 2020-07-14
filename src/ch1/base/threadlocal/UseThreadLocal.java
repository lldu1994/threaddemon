package ch1.base.threadlocal;

/**
 * 演示ThreadLocal的使用
 */
public class UseThreadLocal {
    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private static ThreadLocal<String> stringThreadLocal;

    public void StartThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestThread(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static class TestThread implements Runnable {
        int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            Integer integer = integerThreadLocal.get();
            integer = integer + id;
            integerThreadLocal.set(integer);
            System.out.println(Thread.currentThread().getName()
                    + ":" + integerThreadLocal.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal threadLocal = new UseThreadLocal();
        threadLocal.StartThreadArray();
    }

}
