package reading.designPatternLesson.iterator.hf;

import java.util.Iterator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/26 16:30
 */
public class IteratorTestDrive {

    public static void main(String[] args) {

        DinerMenu dinerMenu = new DinerMenu();
        final Iterator iterator = dinerMenu.createIterator();
        while(iterator.hasNext()){
        }
    }
}
