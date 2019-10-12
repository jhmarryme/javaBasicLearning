package javaBase.Stream;

import javaBase.enumBase.EnumTest;

/**
 * @author jhmarryme.cn
 * @date 2019/7/4 19:26
 */
public class lambdaTest {

    public static void main(String[] args) {
        invokeCook(() -> System.out.println("cook is running"));
    }

    static void invokeCook(Cook cook){
        cook.makeFood();
    }
}


interface Cook{
    void makeFood();
}
