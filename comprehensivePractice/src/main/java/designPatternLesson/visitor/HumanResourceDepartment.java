package designPatternLesson.visitor;

/**
 * 人力资源部  具体访问者
 * @author jhmarryme.cn
 * @date 2019/10/27 15:29
 */
public class HumanResourceDepartment implements Department{
    /**
     * 访问全职员工 计算工作时间
     * @param employee
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        final Integer workTime = employee.getWorkTime();

        System.out.printf("正式员工: %s 实际工作时间为: %d 小时 \n", employee.getName(), employee.getWorkTime());
        if(workTime > 40){
            System.out.printf("加班时间为:%d 小时 \n", employee.getWorkTime() - 40);
        } else if (workTime < 40){
            System.out.printf("请假时间为:%d 小时 \n", 40 - employee.getWorkTime());
        } else {
            System.out.println("该员工没有加班或请假");
        }
    }

    /**
     * 访问兼职员工, 计算工作时间
     * @param employee
     */
    @Override
    public void visit(PartTimeEmployee employee) {
        System.out.printf("临时工: %s 实际工作时间为 %d 小时", employee.getName(), employee.getWorkTime());
    }
}
