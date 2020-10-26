package reading.designPatternLesson.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象元素类的集合   对象结构
 * @author jhmarryme.cn
 * @date 2019/10/27 15:48
 */
public class EmployeeList {

    private List<Employee> list = new ArrayList<>();

    public void addEmployee(Employee employee){
        list.add(employee);
    }

    /**
     * 根据传参的部门, 访问集合中的每一个员工
     * @param department
     */
    public void accept(Department department){
        list.stream().forEach(employee -> {
            employee.accept(department);
        });
    }
}
