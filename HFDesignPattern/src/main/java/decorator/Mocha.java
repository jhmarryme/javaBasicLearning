package decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/6/27 14:21
 */
public class Mocha extends Condimentdecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost(){
        return .20 + beverage.cost();
    }
}
