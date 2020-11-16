package reading.easycoding.datetype.collections.witharrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 集合与数组的转换测试
 * @Author: Wjh
 * @Date: 2020/11/16 12:27
 * @Modified By:
 */
public class ConvertTest {

    private static int INITIAL_CAPACITY = 100 * 100 * 100;

    @Test
    @DisplayName("数组正常转换为集合")
    public void whenConvertArraysToListSuccess() {
        // // 这种转换可以使用修改集合相关方法, add, remove, clear
        List<String> arrayList = new ArrayList<>(Arrays.asList(generateStringArrays()));
        arrayList.add("four");
        arrayList.add("five");

        arrayList.remove(0);
        arrayList.forEach(System.out::println);

        arrayList.clear();
        arrayList.forEach(System.out::println);
    }

    @Test
    @DisplayName("数组异常转换为集合")
    public void whenConvertArraysToListException() {
        List<String> asList = Arrays.asList(generateStringArrays());
        Assertions.assertThrows(
                UnsupportedOperationException.class,
                () -> {
                    asList.add("a");
                    asList.remove(0);
                    asList.clear();
                },
                "这种转换不能使用修改集合相关方法, add, remove, clear"
        );
        asList.forEach(System.out::println);

    }

    @Test
    @DisplayName("集合正常转为数组")
    public void whenConvertListToArraysSuccess() {

        long start = System.nanoTime();
        String[] notEnoughArray = new String[INITIAL_CAPACITY - 1];
        generateStringList().toArray(notEnoughArray);
        long middle1 = System.nanoTime();

        // 建议数组容量等于集合大小
        String[] equalsArray = new String[INITIAL_CAPACITY];
        generateStringList().toArray(equalsArray);
        long middle2 = System.nanoTime();

        String[] doubleArray = new String[INITIAL_CAPACITY * 2];
        generateStringList().toArray(doubleArray);
        long middle3 = System.nanoTime();

        String[] newArray = new String[]{};
        generateStringList().toArray(newArray);
        long middle4 = System.nanoTime();

        generateStringList().toArray(String[]::new);
        long end = System.nanoTime();

        long notEnoughArrayTime = middle1 - start;
        long equalsArrayTime = middle2 - middle1;
        long doubleArrayTime = middle3 - middle2;
        long newArrayTime = middle4 - middle3;
        long toArrayTime = end - middle4;


        System.out.println("notEnoughArrayTime = " + notEnoughArrayTime / (1000.0 * 1000.0));
        System.out.println("equalsArrayTime = " + equalsArrayTime / (1000.0 * 1000.0));
        System.out.println("doubleArrayTime = " + doubleArrayTime / (1000.0 * 1000.0));
        System.out.println("newArrayTime = " + newArrayTime / (1000.0 * 1000.0));
        System.out.println("toArrayTime = " + toArrayTime / (1000.0 * 1000.0));
    }


    public String[] generateStringArrays() {
        return new String[]{"one", "two", "three"};
    }

    public List<String> generateStringList() {
        ArrayList<String> arrayList = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            arrayList.add("str" + i);
        }
        return arrayList;
    }
}
