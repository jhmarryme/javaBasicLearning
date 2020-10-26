package javaBase.functionalProgram.lambda.simple;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/17 11:21
 */
public class ComparatorWithLambda {
    public static void main(String[] args) {

        PersonForComparator[] persons = {
                new PersonForComparator("古力娜扎", 19),
                new PersonForComparator("迪丽热巴", 18),
                new PersonForComparator("马尔扎哈", 20) };

        /*Comparator<PersonForComparator> comparator = new Comparator<PersonForComparator>() {

            @Override
            public int compare(PersonForComparator o1, PersonForComparator o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        Arrays.sort(persons, comparator);*/

        //lambda表达式的写法
        Arrays.sort(persons, (PersonForComparator o1, PersonForComparator o2) -> {
            return o2.getAge() - o1.getAge();
        });
        for (PersonForComparator person : persons) {
            System.out.println(person);
        }
    }
}
