package reading.designPatternLesson.simpleFactory;

/**
 * 通过简单工厂模式创建具体对象
 */

/**
 * 工厂角色
 * @author jhmarryme.cn
 * @date 2019/10/13 10:42
 */
public class NvWa {
    public static Person makePerson(char arg){
        Person person = null;

        switch (Character.toString(arg).toLowerCase().charAt(0)) {
            case 'm':
                person = new Man();
                break;
            case 'w':
                person = new Woman();
                break;
            case 'r':
                person = new Robot();
                break;
            default:
                //不做操作
        }

        return person;
    }
}

/**
 * 抽象产品角色
 */
interface Person{

    void speak();

}

/**
 * 具体产品角色
 */
class Robot implements Person{

    @Override
    public void speak() {
        System.out.println("i 'm a rebot");
    }
}
class Woman implements Person{

    @Override
    public void speak() {
        System.out.println("i 'm a woman");
    }
}
class Man implements Person{

    @Override
    public void speak() {
        System.out.println("i 'm a man");
    }
}
