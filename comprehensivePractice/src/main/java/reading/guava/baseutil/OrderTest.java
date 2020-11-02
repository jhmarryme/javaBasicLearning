package reading.guava.baseutil;

import com.google.common.collect.Ordering;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description:   guava Ordering使用, 大多数都能够使用Comparator替代
 *      https://blog.wangqi.love/articles/Java/guava%20Ordering%E6%80%BB%E7%BB%93.html
 *      https://wizardforcel.gitbooks.io/guava-tutorial/content/6.html
 * @Author: Wjh
 * @Date: 2020/11/2 12:16
 * @Modified By:
 */
public class OrderTest {

    @Test
    public void useOrdering() {
        List<String> naturalList =
                Ordering.natural().sortedCopy(Stream.generate(() -> RandomStringUtils.randomNumeric(4)).limit(100).collect(Collectors.toList()));
        naturalList.forEach(System.out::println);

    }
}
