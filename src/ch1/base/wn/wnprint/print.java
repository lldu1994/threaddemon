package ch1.base.wn.wnprint;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用wait和notifyALl实现打印功能
 */
public class print {

    //仓库最大容量
    private final int MAX_SIZE = 100;

    /**
     * 设置静态的map对象
     */
    private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();


    /**
     * 生产map信息
     *
     * @param
     */
    public void product(HashMap<String, Object> map1, int num) throws InterruptedException {
        synchronized (map) {
            //从数据库获取到的map信息进行遍历
            while (map1 != null) {
                //for()
                //等待消费线程消费
                map.wait();
            }


            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + map.size());
            map.notifyAll();
        }
    }

    /**
     * 消费map信息
     */
    public void consumer(int num) throws InterruptedException {
        synchronized (map) {
            //不满足消费条件
            while (num > map.size()) {
                System.out.println("消费条件不满足");
                map.wait();
            }
            System.out.println("开始replaceTemplates====");
            for (Object value : map.values()) {
                System.out.println(value.toString());
            }
            System.out.println("结束replaceTemplates====");
            map.clear();
        }

    }
}
