package javaBase.File;

import java.io.*;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 15:27
 */
public class FileReadByBufferdStream {

    public static void main(String[] args) {
        copyFileByBufferedStream();
    }

    /**
     * 通过缓冲流复制大文件
     */
    public static void copyFileByBufferedStream()  {

        String parent = "C:\\Users\\jhmarryme\\Downloads";

        long length = 0;

        long currentTimeMillis = System.currentTimeMillis();

        try ( BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream(parent + "\\我是大哥大.Kyou.kara.Ore.wa.Ep08.Chi_Jap.HDTVrip.1280X720-ZhuixinFan.mp4"));
              BufferedOutputStream outputStream = new BufferedOutputStream(
                      new FileOutputStream(parent + "\\dageda.mp4"));
              ){


            byte[] bytes = new byte[8 * 1024];
            int len = -1;

            while ( (len = inputStream.read(bytes)) != -1 ){
                outputStream.write(bytes, 0, len);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("复制所花费的时间" + (System.currentTimeMillis() - currentTimeMillis));
    }
}
