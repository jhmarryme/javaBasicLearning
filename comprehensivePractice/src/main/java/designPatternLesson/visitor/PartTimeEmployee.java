package designPatternLesson.visitor;

/**
 * 兼职人员  具体元素
 * @author jhmarryme.cn
 * @date 2019/10/27 15:16
 */
public class PartTimeEmployee implements Employee {

    private String name;

    private Integer workTime;

    //兼职人员 时薪
    private Double hourWage;

    public PartTimeEmployee(String name, Integer workTime, Double hourWage) {
        this.name = name;
        this.workTime = workTime;
        this.hourWage = hourWage;
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

    public Double getHourWage() {
        return hourWage;
    }

    public void setHourWage(Double hourWage) {
        this.hourWage = hourWage;
    }

    @Override
    public void accept(Department department) {
        department.visit(this);
    }
}
