package chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:07
 */
public interface Observer {
    /**
     * 收到通知, 更新数据
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void update(float temp, float humidity, float pressure);
}
