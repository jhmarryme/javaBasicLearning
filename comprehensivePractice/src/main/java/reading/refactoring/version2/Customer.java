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
            thisAmount = amountFor(each);
            // add frequent renter points （累计常客积点。
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines（结尾打印）
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        // determine amounts for each line
        // 取得影片出租价格
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                thisAmount += 0;
                break;
        }
        return thisAmount;
    }
}