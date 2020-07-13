package ch1.base.syn;

import tool.SleepTools;

/**
 * 锁的示例不一样，也是可以并行的
 */
public class DiffInstance {
    private static class InstanceSyn implements Runnable {
        private DiffInstance diffInstance;

        public InstanceSyn(DiffInstance diffInstance) {
            this.diffInstance = diffInstance;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..." + diffInstance);
            diffInstance.instance();
        }
    }

    private static class Instance2Syn implements Runnable {
        private DiffInstance diffInstance;

        public Instance2Syn(DiffInstance diffInstance) {
            this.diffInstance = diffInstance;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..." + diffInstance);
            diffInstance.instance2();
        }
    }

    private synchronized void instance() {
        SleepTools.second(3);
        System.out.println("synInstance is going..." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance ended " + this.toString());
    }

    private synchronized void instance2() {
        SleepTools.second(3);
        System.out.println("synInstance2 is going..." + this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 ended " + this.toString());
    }

    public static void main(String[] args) {
        DiffInstance diffInstance1 = new DiffInstance();
        Thread t1 = new Thread(new InstanceSyn(diffInstance1));
        DiffInstance diffInstance2= new DiffInstance();
        Thread t2 = new Thread(new Instance2Syn(diffInstance2));
        t1.start();
        t2.start();
        SleepTools.second(5);
    }

}
