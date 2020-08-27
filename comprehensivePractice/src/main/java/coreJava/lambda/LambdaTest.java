package coreJava.lambda;

import org.junit.Test;

import javax.swing.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: core-java
 * @description:
 * @author: JiaHao Wang
 * @create: 2020-07-02 14:33
 **/
public class LambdaTest {

    @Test
    public void testLambda() {
        var planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune" };
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, e -> {
            System.out.println("Instant.ofEpochMilli(e.getWhen()) = " + Instant.ofEpochMilli(e.getWhen()));
        });
        timer.start();

        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
