package ch1.base.wn;

/**
 * 快递实体类
 */
public class Express {

    public final static String CITY = "ShangHai";
    private int km;// 快递运输里程数
    private String site; //快递到达地点

    public Express() {

    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /**
     * 变化公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理
     */
    public synchronized void changeKm() {
        this.km = 101;
        notify();
    }

    public synchronized void changeSite() {
        this.site = "BeiJing";
        notify();
    }


}
