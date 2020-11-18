package reading.easycoding.datetype.collections.elementcomparison;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * description: hashCode和equals
 *      任何时候重写equals,都必须重写hashCode
 *      尽量避免通过实例对象引用来调用equals方法,容易NPE, 推荐使用Objects的equals方法
 *      集合比较时, 具体逻辑需要具体分析
 * @Author: Wjh
 * @Date: 2020/11/18 15:52
 * @Modified By:
 */
public class HashCodeAndEqualsTest {

    @Test
    @DisplayName("重写equals后, 没有重写hashCode方法时")
    public void whenNotRewriteHashCode() {
        Set<EqualsObject> set = new HashSet<>();

        set.add(new EqualsObject(1, "one"));
        set.add(new EqualsObject(1, "one"));
        set.add(new EqualsObject(1, "one"));

        // 没有重写hashCode时, set不能正确识别重复对象, size = 3
        System.out.println("set.size() = " + set.size());

    }

    @Test
    @DisplayName("重写equals后, 重写hashCode方法时")
    public void whenRewriteHashCode() {
        Set<EqualsAndHashCodeObject> set = new HashSet<>();

        set.add(new EqualsAndHashCodeObject(1, "one"));
        set.add(new EqualsAndHashCodeObject(1, "one"));
        set.add(new EqualsAndHashCodeObject(1, "one"));

        // 重写hashCode后, set能正确识别重复对象, size = 1
        System.out.println("set.size() = " + set.size());
    }

    @Test
    @DisplayName("两个相同数据 不同类型的集合类的比较")
    public void listEquals() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        // equals的实现方式与类的具体实现逻辑有关, 这里会为true
        System.out.println("arrayList.equals(linkedList) = " + arrayList.equals(linkedList));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class EqualsObject {
        private int id;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof EqualsObject)) {
                return false;
            }
            EqualsObject that = (EqualsObject) o;
            return getId() == that.getId() &&
                    getName().equals(that.getName());
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class EqualsAndHashCodeObject {
        private int id;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof EqualsAndHashCodeObject)) {
                return false;
            }
            EqualsAndHashCodeObject that = (EqualsAndHashCodeObject) o;
            return getId() == that.getId() &&
                    getName().equals(that.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }
}
