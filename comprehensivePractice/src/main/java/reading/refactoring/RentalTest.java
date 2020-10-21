package reading.refactoring;

import org.junit.jupiter.api.Test;
import reading.refactoring.version2.Customer;
import reading.refactoring.version2.Movie;
import reading.refactoring.version2.Rental;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 16:47
 * @Modified By:
 */
public class RentalTest {

    @Test
    public void whenVersion2Success() {

        List<Movie> movieList = createMovie();

        Customer customer = new Customer("王家豪");
        movieList.forEach(movie -> {
            customer.addRental(new Rental(movie, 2));
        });

        System.out.println(customer.statement());

    }



    public static List<Movie> createMovie() {
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("福尔摩斯", 1));
        movieList.add(new Movie("基本演绎法", 2));

        return movieList;
    }
}
