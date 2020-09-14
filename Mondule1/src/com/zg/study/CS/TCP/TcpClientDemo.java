package com.zg.study.CS.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.客户端要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 38283;
            //2.创建一个socket连接
            socket = new Socket(serverIP,port);
            //3.发送消息 IO流
            os =socket.getOutputStream();
            String send = "Hello,zg.你好";
            os.write(send.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            os.close();
            socket.close();
        }





    }
}
