package reading.designPatternLesson.visitor;

/**
 * 全职人员 具体元素
 * @author jhmarryme.cn
 * @date 2019/10/27 15:15
 */
public class FullTimeEmployee implements Employee {
    private String name;

    private Integer workTime;

    //全职员工 周薪
    private Double weeklyWage;


    public FullTimeEmployee(String name, Integer workTime, Double weeklyWage) {
        this.name = name;
        this.workTime = workTime;
        this.weeklyWage = weeklyWage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Double getWeeklyWage() {
        return weeklyWage;
    }

    public void setWeeklyWage(Double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    @Override
    public void accept(Department department) {
        department.visit(this);
    }
}
