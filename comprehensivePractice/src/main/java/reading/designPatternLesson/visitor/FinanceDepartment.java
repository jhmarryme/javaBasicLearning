package reading.designPatternLesson.visitor;

/**
 * 财务部  具体访问者
 * @author jhmarryme.cn
 * @date 2019/10/27 15:29
 */
public class FinanceDepartment implements Department {

    /**
     * 访问全职员工, 计算工资
     * @param employee
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        final Integer workTime = employee.getWorkTime();
        Double weeklyWage = employee.getWeeklyWage();

        if(workTime > 40){
            weeklyWage = weeklyWage + (workTime - 40) * 100;
        } else {
            weeklyWage = weeklyWage - (40 - workTime) * 80;
            if (weeklyWage < 0){
                weeklyWage = 0.0;
            }
        }

        System.out.printf("正式员工: %s 实际工资为 %.2f 元\n",employee.getName(), weeklyWage);
    }

    /**
     * 访问兼职员工, 计算工资
     * @param employee
     */
    @Override
    public void visit(PartTimeEmployee employee) {
        System.out.printf("临时员工: %s 实际工资为 %.2f 元\n",employee.getName(), employee.getHourWage() * employee.getWorkTime());

    }
}
