package factory;

/**
 * @author jhmarryme.cn
 * @date 2019/7/1 10:55
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;

        //通过工厂创建pizza
        pizza = createPizza(type);
        pizza.prepare();;
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);

}
