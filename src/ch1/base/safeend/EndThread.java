package ch1.base.safeend;

/**
 * 如何安全中断线程
 */
public class EndThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "interrrupt flag" + isInterrupted());
            while (!isInterrupted()) {
                System.out.println(threadName+" is running");
                System.out.println(threadName+"inner interrrupt flag ="
                        +isInterrupted());
            }
            System.out.println(threadName+" interrrupt flag ="+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread();
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();//中断线程 ，其实就是设置线程的表示位为true

    }
}
