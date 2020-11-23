package reading.easycoding.datetype.collections.failfast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * description: fail-fast机制学习
 *      java.util下的所有集合类都是 fail-fast机制: 对集合遍历操作时的错误检测机制.
 *      concurrent包中的集合类都是fail-safe机制: 类似于快照机制
 * @Author: Wjh
 * @Date: 2020/11/19 9:26
 * @Modified By:
 */
public class FailFastTest {

    @Test
    @DisplayName("foreach遍历元素时,使用删除方式测试fail-fast机制")
    public void arrayListFailFast() {
        Assertions.assertThrows(
                ConcurrentModificationException.class,
                () -> {
                    ArrayList<String> list = getStrings();
                    for (String s : list) {
                        if ("two".equals(s)) {
                            list.remove(s);
                        }
                    }
                    System.out.println("list = " + list);
                },
                "在forEach中删除元素测试fail-fast机制, 会出现unchecked异常"
        );

        // 出现巧合的情况, 恰好是倒数第二个元素时, 不会发生异常(码出高效p183)
        ArrayList<String> list = getStrings();
        for (String s : list) {
            if ("four".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println("list = " + list);

    }

    @Test
    @DisplayName("多线程并发下, 使用Iterator机制进行遍历时的删除")
    public void whenUseIteratorToDeleteInForEach() {
        ArrayList<String> list = getStrings();

        Iterator<String> iterator = list.iterator();
        // 遍历时删除元素
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("two".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println("list第1次 = " + list);

        // 更简洁的方式
        list.removeIf("four"::equals);
        System.out.println("list第2次 = " + list);

    }

    @Test
    @DisplayName("通过ArrayList.subList()学习fail-fast机制")
    public void subListFailFast() {

        ArrayList<String> masterList = getStrings();
        List<String> branchList = masterList.subList(0, 3);

        Assertions.assertThrows(
                ConcurrentModificationException.class,
                () -> {
                    // 会导致子列表的操作产生异常的操作
                    masterList.remove(0);
                    masterList.add("ten");
                    masterList.clear();

                    // subList返回的是ArrayList的内部类(SubList), 没有实现序列化接口
                    // 子列表并且修改后会影响到主列表
                    branchList.clear();
                    branchList.add("six");
                    branchList.add("seven");
                    branchList.remove(0);
                },
                "masterList 的任何关于元素个数的修改都会导致branchList的'增删改查'抛出ConcurrentModificationException"
        );

    }

    @Test
    @DisplayName("使用fail-safe机制的Copy-On-Writer容器")
    public void whenUseCopyOnWriteArrayList() {

        // 1. 尽量设置合理的容量初始值, 扩容的代价很大
        // 2. 写操作时, 处理方式为 先复制一个新集合, 在新集合内进行添加或删除, 待修改完成后将原集合指向该集合引用
        // 3. 在高并发请求下, 尽量进行批量添加或删除, 攒够足够的元素后再进行addAll/removeAll, 避免增加1个元素就复制整个集合
        List<Long> copy = new CopyOnWriteArrayList<>();
        List<Long> list = new ArrayList<>();

        long start = System.nanoTime();
        // CopyOnWriteArrayList的200000次add操作
        for (int i = 0; i < 20 * 10000; i++) {
            copy.add(System.nanoTime());
        }

        long middle1 = System.nanoTime();
        // ArrayList的200000 次add操作
        for (int i = 0; i < 20 * 10000; i++) {
            list.add(System.nanoTime());
        }

        long middle2 = System.nanoTime();
        // 初始化数据量较大的cow集合, 建议先将数据填充到ArrayList集合中, 再进行
        List<Long> cowCopyList = new CopyOnWriteArrayList<>(list);


        long end = System.nanoTime();

        long cowTime = (middle1 - start) / (1000 * 1000);
        long arrayListTime = (middle2 - middle1) / (1000 * 1000);
        long cowCopyTime = (end - middle2) / (1000 * 1000);

        // cow直接add 90s左右
        System.out.println("cowTime = " + cowTime);
        // ArrayList 60ms
        System.out.println("arrayListTime = " + arrayListTime);
        // 将ArrayList复制到cow, 不到1ms
        System.out.println("cowCopyTime = " + cowCopyTime);
    }

    private ArrayList<String> getStrings() {
        return new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
    }
}
