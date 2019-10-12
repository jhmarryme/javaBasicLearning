package decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/6/27 14:21
 */
public class Whip extends Condimentdecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost(){
        return .10+ beverage.cost();
    }
}
