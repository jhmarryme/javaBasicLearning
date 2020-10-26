package reading.designPatternLesson.visitor;

/**
 *
 * 抽象元素类
 * @author jhmarryme.cn
 * @date 2019/10/27 15:12
 */
public interface Employee {
    void accept(Department department);
}
