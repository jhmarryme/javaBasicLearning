package designPatternLesson.iterator.hf;

import java.util.Iterator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/26 16:23
 */
public class DinerMenu implements Menu {

    final int MAX_ITEMS = 6;
    MenuItem[] menuItems;
        int curItems = 0;
    public DinerMenu() {
            menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05);
        addItem("Steamed Veggies and Brown Rice",
                "Steamed vegetables over brown rice", true, 3.99);
        addItem("Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price){
        if(curItems >= MAX_ITEMS){
            System.err.println("存满了");
        } else{
            final MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
            menuItems[curItems++] = menuItem;
        }
    }
    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuInterator(menuItems);
    }
}
