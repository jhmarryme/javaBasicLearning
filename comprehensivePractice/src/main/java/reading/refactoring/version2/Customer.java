package reading.refactoring.version2;

import java.util.Enumeration;
import java.util.Vector;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 8:47
 * @Modified By:
 */
public class Customer {
    // 姓名
    private String _name;
    // 租借记
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        // 总消费金。
        double totalAmount = 0;
        // 常客积点
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            // 取得一笔租借记。
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        // add footer lines（结尾打印）
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        return _rentals.stream().mapToDouble(o -> ((Rental) o).getCharge()).sum();
    }
}