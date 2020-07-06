package ch1.base;

/**
 * 线程的启动方式两种
 */
public class NewThread {

    //扩展自Thread类
    private static class UseThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("I am extendec Thread");
        }
    }

    //扩展自Runnable接口
    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("I am implements Runnable");
        }
    }

    public static void main(String[] args) {
        UseThread useThread = new UseThread();
        useThread.start();
        useThread.start();

        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();
    }
}
