package javaBase.recursion;


import java.io.File;
import java.util.*;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 11:17
 */
public class PrintAllDirs {

    private static Map<String, List<String>> map;

    /**
     * 测试打印当前目录下所有文件及目录
     * @param args
     */
    public static void main(String[] args) {
        map = new HashMap<>();
        File dir  = new File("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase");

        printDir(dir);
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            String key = stringListEntry.getKey();
            System.out.println(key + ": ");
            List<String> value = stringListEntry.getValue();
            for (String s : value) {
                System.out.println(s);
            }
            System.out.println();
        }

    }


    /**
     * 将当前目录下所有文件名及目录名 一一对应显示出来
     * @param dir
     */
    public static void  printDir(File dir) {

        //先获取所有文件及目录
        File[] files = dir.listFiles();
        for (File file : files) {
            //如果是文件则直接存入
            if (file.isFile()){
                String parent = file.getParent();

                List<String> strings = map.get(parent);

                if (strings == null) {
                    strings = new ArrayList<>();
                    map.put(parent, strings);
                }
                strings.add(file.getName());

            } else {
                printDir(file);
            }
        }
    }
}
