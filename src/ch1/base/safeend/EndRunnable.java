package ch1.base.safeend;

/**
 * 实现接口runnable如何使线程中断
 */
public class EndRunnable {
    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            //while(!Thread.interrupted()){
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName()
                        + " I am implements Runnable.");
            }
            System.out.println(Thread.currentThread().getName()
                    + " interrupt flag is " + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread endThread = new Thread(useRunnable);
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
