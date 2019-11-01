package concurrentProgramming.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author jhmarryme.cn
 * @date 2019/10/21 13:10
 */
public class TempClass {
    public static void main(String[] args) {

        final ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            list.add(new Random().nextInt(100));
        }
        Collections.sort(list, (o1, o2) -> {
            if(o2 > o1){
                return 1;
            } else{
                return -1;
            }
        });

        list.stream().forEach(integer -> {
            System.out.print(integer + ",  ");
        });

    }
}
