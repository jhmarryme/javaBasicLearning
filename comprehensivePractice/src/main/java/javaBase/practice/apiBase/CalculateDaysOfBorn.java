package javaBase.practice.apiBase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author jhmarryme.cn
 * @date 2019/6/27 15:43
 */
public class CalculateDaysOfBorn {

    /**
     * 计算你的生日距离今天过去了多少天
     * @param str
     * @return
     */
    public static int compute(String str){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date birth = null;
        try {
            birth = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }

        Date date = new Date();
        long millTimes = date.getTime() - birth.getTime();

        return (int) (millTimes/1000/60/60/24);
    }


    /**
     * 获取指定天数以前的日期
     * @param day
     * @return
     */
    public static String getDate(int day){
        long mills = 1000 * 60 * 60 * 24;
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis - mills*day);
        System.out.println("date = " + date);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        String birth = scanner.next();
        System.out.println(compute(birth));*/

        Scanner scanner = new Scanner(System.in);
        String day = scanner.next();
        System.out.println(getDate(Integer.valueOf(day)));
    }
}
