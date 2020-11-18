package reading.easycoding.datetype.collections.withgenerics;

import base.entity.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * description: easy-coding泛型练习
 *      尖括号 -> 返回值之前, 类名之后
 *      尖括号里的每一个元素都指代一种未知类型,类名后的<T>和返回值之前的<T>可以完全不同
 *
 * @Author: Wjh
 * @Date: 2020/11/17 10:45
 * @Modified By:
 */
public class GenericTest<T> {

    @Test
    @DisplayName("模拟微波炉加热食物, 泛型的作用")
    public void simulateStove() {
        Object unknownFood = new Object();
        heat(unknownFood);

        Student student = CreateUtils.createStudent(false);
        heat(student);

    }

    @Test
    @DisplayName("泛型与集合联合使用, extends: get first; super: put first")
    public void whenUseExtendAndSuperSuccess() {

        // 1. 声明集合, Object > animal > cat > garfield
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfield> garfields = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        garfields.add(new Garfield());


        // 2. 测试赋值操作
        // 编译出错 上限为cat
        // List<? extends Cat> extendsCatFromAnimal = animals;
        List<? super Cat> superFromAnimal = animals;

        List<? extends Cat> extendsCatFromCat = cats;
        List<? super Cat> superFromCat = cats;

        List<? extends Cat> extendsCatFromGarfield = garfields;
        // 编译出错 下限为cat
        // List<? super Cat> superFromGarfield = garfields;


        // 3. 测试add操作
        // <? extends T> 无法进行add操作
        // extendsCatFromCat.add(new Animal());
        // extendsCatFromCat.add(new Cat());
        // extendsCatFromCat.add(new Garfield());

        // <? super Cat> 只能add Cat和其子类
        // superFromCat.add(new Animal());
        superFromCat.add(new Cat());
        superFromCat.add(new Garfield());


        // 4. 测试get方法
        // super 虽然能够返回元素, 但类型丢失
        Object object = superFromCat.get(0);

        // extend 正常返回
        Cat cat = extendsCatFromCat.get(0);
        Object cat1 = extendsCatFromCat.get(0);
        // 编译错误, 虽然extendsCatFromGarfield 由garfield赋值而来, 但只能返回Cat和父类对象, 子类型被擦除了
        // Garfield cat2 = extendsCatFromGarfield.get(0);

    }

    public <T> T heat(T food) {
        System.out.println(food + "is done");
        return food;
    }

    private class Animal {

    }

    private class Cat extends Animal {

    }

    private class Garfield extends Cat {

    }
}
