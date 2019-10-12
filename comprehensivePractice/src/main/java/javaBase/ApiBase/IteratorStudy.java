package javaBase.ApiBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jhmarryme.cn
 * @date 2019/7/4 15:28
 */
public class IteratorStudy {

    public static void main(String[] args) {
        Collection<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");

        Iterator<String> iterator = strList.iterator();

        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("next = " + next);
        }
/*
        for (String s : strList) {
            System.out.println("s = " + s);
        }*/

        /*strList.forEach(s -> {
            System.out.println("s = " + s);
        });*/

        List<String> collect = strList.stream().map(s -> s + "1").collect(Collectors.toList());
        for (String s : collect) {
            System.out.println("s = " + s);
        }
    }
}
