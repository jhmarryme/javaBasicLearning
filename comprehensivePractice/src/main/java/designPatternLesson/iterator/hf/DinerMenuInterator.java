package designPatternLesson.iterator.hf;

import java.util.Iterator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/26 16:15
 */
public class DinerMenuInterator implements Iterator<MenuItem> {

    public DinerMenuInterator(MenuItem[] items) {
        this.items = items;
    }


    @Override
    public void remove() {

    }

    MenuItem[] items;
    int position = 0;
    @Override
    public boolean hasNext() {
        if(position >= items.length || items[position] == null){
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem item = items[position];
        position += 1;
        return item;
    }
}
