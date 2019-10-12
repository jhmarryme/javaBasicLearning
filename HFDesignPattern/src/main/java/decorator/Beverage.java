package decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/6/27 14:18
 */
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
