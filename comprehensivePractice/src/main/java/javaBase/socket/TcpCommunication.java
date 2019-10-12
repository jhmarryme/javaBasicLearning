package javaBase.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 20:01
 */
public class TcpCommunication {

    static int count = 0;

    public static void main(String[] args) {



        //创建服务端线程
        new Thread(() -> {
            System.out.print(++count);
            System.out.println("服务器正在启动, 等待连接中");

            try {
                //1. 创建serverSocket对象, 等待连接
                ServerSocket serverSocket = new ServerSocket(6666);
                //2. 连接成功, 返回Socket对象
                Socket accept = serverSocket.accept();
                //3. 通过连接的socket获取输入流
                InputStream inputStream = accept.getInputStream();
                //4. 解析输入流中数据
                byte[] b = new byte[1024];
                final int len = inputStream.read(b);
                System.out.print(++count);
                System.out.println(new String(b, 0, len));

                //5. 通过socket获取输出流
                final OutputStream outputStream = accept.getOutputStream();
                //6. 发送数据到客户端
                System.out.print(++count);
                outputStream.write("这是服务端发送的数据".getBytes());

                outputStream.close();
                inputStream.close();
                serverSocket.close();

            } catch (Exception e){
                e.printStackTrace();
            }

        }).start();

        //创建客户端线程

        new Thread(() -> {

            try{
                System.out.print(++count);
                System.out.println("客户端启动成功");
                //1. 创建socket连接
                Socket socket = new Socket("localhost", 6666);
                //2. 获取输出流
                final OutputStream outputStream = socket.getOutputStream();
                //3. 发出数据
                System.out.print(++count);
                outputStream.write("这是客户端发送的数据: hello".getBytes());
                //4. 获取输入流
                final InputStream inputStream = socket.getInputStream();
                //5. 显示接受到的数据
                byte[] bytes = new byte[1024];
                final int len = inputStream.read(bytes);
                System.out.print(++count);
                System.out.println(new String(bytes, 0, len));

                inputStream.close();
                outputStream.close();
                socket.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
