package reading.refactoring.version2;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 8:47
 * @Modified By:
 */
public class Rental {
    // 影片
    private Movie _movie;
    // 租期
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {
        double thisAmount = 0;
        // determine amounts for aRental line
        // 取得影片出租价格
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (getDaysRented() > 2) {
                    thisAmount += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (getDaysRented() > 3) {
                    thisAmount += (getDaysRented() - 3) * 1.5;
                }
                break;
            default:
                thisAmount += 0;
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints() {
        // 累计常客积点 默认1, 属于NEW_RELEASE的电影并且借出天数大于1的 再加1
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && this.getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
