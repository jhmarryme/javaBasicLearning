package designPatternLesson.visitor;

/**
 * 测试代码
 * @author jhmarryme.cn
 * @date 2019/10/27 15:46
 */
public class VisitorTestDrive {
    public static void main(String[] args) {

        final EmployeeList list = new EmployeeList();

        list.addEmployee(new FullTimeEmployee("员工1号", 40, 5000.0));
        list.addEmployee(new FullTimeEmployee("员工2号", 50, 4000.0));
        list.addEmployee(new FullTimeEmployee("员工3号", 30, 8000.0));


        final FinanceDepartment financeDepartment = new FinanceDepartment();
        final HumanResourceDepartment humanResourceDepartment = new HumanResourceDepartment();
        list.accept(financeDepartment);
        System.out.println();
        list.accept(humanResourceDepartment);
    }
}
