package javaBase.practice.apiBase;

import java.util.Calendar;

/**
 * @author jhmarryme.cn
 * @date 2019/6/27 17:03
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DAY_OF_WEEK ) - 1);
        System.out.println(cal.getTime());
    }
}
