package designPatternLesson.visitor;

/**
 * 抽象访问者类
 * @author jhmarryme.cn
 * @date 2019/10/27 15:12
 */
public interface Department {

    //重载, 访问不同类型的职员
    void visit(FullTimeEmployee employee);
    void visit(PartTimeEmployee employee);
}
