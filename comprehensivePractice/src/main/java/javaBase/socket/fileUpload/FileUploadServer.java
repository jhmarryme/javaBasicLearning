package javaBase.socket.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 20:34
 */
public class FileUploadServer {

    public static void main(String[] args) throws IOException {
//1. 创建服务器, 等待连接
        final ServerSocket serverSocket = new ServerSocket(6666);

        String parent = "D:\\develop\\folderForDevelop\\";
        while (true){
            //2. 连接成功
            final Socket accept = serverSocket.accept();
            // 如果连接成功的话会继续进行.
            new Thread(() -> {

                try (
                        //3.1 获取远程输入流
                        BufferedInputStream in = new BufferedInputStream(accept.getInputStream());
                        //3.2 获取本地输出流
                        final BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(parent + System.currentTimeMillis() + ".txt")));

                ){

                    //4. 保存文件到本地
                    //4.1 缓冲区
                    byte[] bytes = new byte[1024 * 8];
                    int len = -1;
                    //4.2 保存
                    while( (len = in.read(bytes)) != -1 ){
                        out.write(bytes, 0, len);
                    }

                    //5. 回写数据
                    final OutputStream remoteOut = accept.getOutputStream();
                    remoteOut.write("上传成功".getBytes());

                    //关闭资源
                    accept.close();
                    remoteOut.close();
                    System.out.println("文件已保存");
                } catch (Exception e){
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
