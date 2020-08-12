package designPatternLesson.singleton;

/**
 * description: effectiveJava 推荐的单例模式
 *
 * @Author: Wjh
 * @Date: 2020/8/12 11:20
 * @Modified By:
 */
public enum SingletonExample {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("来自枚举实现的单例模式中的方法");
    }
}
