package reading.easycoding.datetype.collections.elementcomparison;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * description: Comparator和Comparable
 *      约定俗成, 小于的情况返回-1, 等于返回0, 大于返回1
 *      Comparable表明自身具备与同类比较的能力 compareTo
 *      Comparator表明自身是比较器的实践者 compare
 * @Author: Wjh
 * @Date: 2020/11/18 15:26
 * @Modified By:
 */
public class ComparatorAndComparableTest {

    /** 用于自定义比较 **/
    private static final SearchResult HONOR;
    /** 用于自定义比较 **/
    private static final SearchResult APPLE;

    static {
        APPLE = new SearchResult(10, 4);
        HONOR = new SearchResult(10, 5);
    }

    @Test
    @DisplayName("自定义comparable")
    public void customizeComparable() {

        // 根据对象本身定义的比较规则
        System.out.println("apple.compareTo(honor) = " + APPLE.compareTo(HONOR));

    }

    @Test
    @DisplayName("自定义comparator")
    public void customizeComparator() {
        ArrayList<SearchResult> list = new ArrayList<>(Arrays.asList(APPLE, HONOR));
        System.out.println("排序前:");
        list.forEach(System.out::println);

        // 自定义 外部的比较规则
        list.sort((o1, o2) -> {
            if (o1.relativeRatio != o2.relativeRatio) {
                return o1.relativeRatio < o2.relativeRatio ? 1 : -1;
            }
            if (o1.count != o2.count) {
                return o1.count < o2.count ? 1 : -1;
            }

            return 0;
        });
        System.out.println("排序后:");
        list.forEach(System.out::println);

    }

    @Data
    private static class SearchResult implements Comparable<SearchResult> {

        /** 相关度 **/
        int relativeRatio;
        /** 浏览数 **/
        long count;
        int recentOrders;

        public SearchResult(int relativeRatio, long count) {
            this.relativeRatio = relativeRatio;
            this.count = count;
        }

        @Override
        public int compareTo(SearchResult o) {
            // 先比较相关度
            if (this.relativeRatio != o.relativeRatio) {
                return this.relativeRatio > o.relativeRatio ? 1 : -1;
            }

            // 相关度相等再比较浏览数
            if (this.count != o.count) {
                return this.count > o.count ? 1 : -1;
            }

            return 0;
        }
    }
}
