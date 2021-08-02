package javaBase.File;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.file.FileReader;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/2 15:23
 */
public class Temp {



    public static void main(String[] args) {
        ztc();
    }

    private static void ztc() {
        File[] ls = FileUtil.ls("D:\\jhmarryme\\资料\\笔记收集\\note-architect-main\\docs\\ztc");

        File mkdir = FileUtil.mkdir("D:\\jhmarryme\\personalNote\\参考笔记归档\\ztc");
        int num = 0;
        Arrays.stream(ls).
                forEach(file -> {
                    String absolutePath = file.getAbsolutePath();
                    File[] childs = FileUtil.ls(absolutePath);
                    String name = FileNameUtil.mainName(file);
                    Arrays.stream(childs).forEach(child -> {
                        if ( !"assets".equals(FileNameUtil.getName(child)) && "md".equals(FileTypeUtil.getType(child))) {

                            String chileName = FileNameUtil.getName(child);
                            if (StringUtils.endsWith(chileName, "new.md") && !StringUtils.startsWith(chileName, "README")) {
                                String childNo = chileName.substring(0, 2);
                                FileReader fileReader = new FileReader(child);
                                String title = fileReader.readLines().stream().findFirst().orElse("default");

                                title = title.replace("#", "");
                                title = title.replace("/", "");
                                File dir = FileUtil.file(mkdir, name);
                                BufferedInputStream in = FileUtil.getInputStream(child);
                                BufferedOutputStream out = FileUtil.getOutputStream(FileUtil.file(dir, childNo + title + ".md"));
                                IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
                            }


                        }
                    });
                });
    }


    private static void designPattern() {
        File[] ls = FileUtil.ls("D:\\jhmarryme\\资料\\笔记收集\\设计模式之美");

        File mkdir = FileUtil.mkdir("D:\\jhmarryme\\资料\\笔记收集\\设计模式之美\\temp");
        Arrays.stream(ls).
                forEach(file -> {
                    String absolutePath = file.getAbsolutePath();
                    File[] childs = FileUtil.ls(absolutePath);
                    String name = FileNameUtil.mainName(file);
                    Arrays.stream(childs).forEach(child -> {
                        if ("md".equals(FileTypeUtil.getType(child))) {
                            BufferedInputStream in = FileUtil.getInputStream(child);
                            BufferedOutputStream out = FileUtil.getOutputStream(FileUtil.file(mkdir, name + ".md"));
                            IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
                        }
                    });
                });
    }
}
