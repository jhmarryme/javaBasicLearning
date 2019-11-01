package designPatternLesson.builder;

/**
 *
 * 产品类
 * @author jhmarryme.cn
 * @date 2019/11/1 17:18
 */
public class Actor {
    private String type;
    private String sex;
    private String costume;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", costume='" + costume + '\'' +
                '}';
    }
}
