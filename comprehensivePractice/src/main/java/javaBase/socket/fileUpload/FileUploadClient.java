package javaBase.socket.fileUpload;

import java.io.*;
import java.net.Socket;


/**
 * @author jhmarryme.cn
 * @date 2019/7/21 20:34
 */
public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        
        //1. 连接服务器
        final Socket socket = new Socket("localhost", 6666);

        //2. 发送文件
        //2.1 读取本地文件
        final BufferedInputStream localBufferedIn = new BufferedInputStream(
                new FileInputStream("C:\\Users\\jhmarryme\\Downloads\\未命名文件.png")
        );
        //2.2 创建远程输出流
        final BufferedOutputStream remoteBufferedOut = new BufferedOutputStream(socket.getOutputStream());

        //2.3 缓冲区
        int len = -1;
        byte[] bytes = new byte[8 * 1024];
        //2.4 上传到服务器
        while ( (len = localBufferedIn.read(bytes)) != -1 ){
            remoteBufferedOut.write(bytes, 0, len);
//            remoteBufferedOut.flush(); // 采用关闭输出流的方式通知服务端, 因此不需要这个了
        }

        socket.shutdownOutput();
        System.out.println("文件发送完毕");
        //接收来自服务端的信息
        final InputStream remoteIn = socket.getInputStream();
        byte[] back = new byte[100];

        remoteIn.read(back);
        System.out.println(new String(back));
        remoteIn.close();

        //释放资源
        socket.close();
        localBufferedIn.close();

    }
}
