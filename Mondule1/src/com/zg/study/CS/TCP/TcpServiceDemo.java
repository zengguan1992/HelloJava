package com.zg.study.CS.TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServiceDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.服务端创建一个地址
            serverSocket = new ServerSocket(38283);
            //2.等待客户端连接过来
            socket = serverSocket.accept();
            //3.读取客户端的消息
            is = socket.getInputStream();
            //管道流(理解成输出输入流的连接接头)
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len=is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            //4.输出客户端的消息
            System.out.println(baos.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //5.关闭资源，跟创建的顺序倒着来，先开后关
            baos.close();
            is.close();
            socket.close();
            serverSocket.close();
        }


    }
}
