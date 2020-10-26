package reading.designPatternLesson.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 将枚举适配为迭代器
 * @author jhmarryme.cn
 * @date 2019/10/17 11:31
 */
public class EnumerationToIterator implements Iterator {

    private Enumeration enumeration;

    public EnumerationToIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
