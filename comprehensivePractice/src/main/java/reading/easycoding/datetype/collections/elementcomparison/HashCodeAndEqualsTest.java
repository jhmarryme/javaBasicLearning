package reading.easycoding.datetype.collections.elementcomparison;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * description: hashCode和equals
 *      任何时候重写equals,都必须重写hashCode
 *
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

        System.out.println("set.size() = " + set.size());

    }
    @Test
    @DisplayName("重写equals后, 重写hashCode方法时")
    public void whenRewriteHashCode() {
        Set<EqualsAndHashCodeObject> set = new HashSet<>();

        set.add(new EqualsAndHashCodeObject(1, "one"));
        set.add(new EqualsAndHashCodeObject(1, "one"));
        set.add(new EqualsAndHashCodeObject(1, "one"));

        System.out.println("set.size() = " + set.size());
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
