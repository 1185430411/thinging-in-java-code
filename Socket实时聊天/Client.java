package com.jay.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    //初始化，连接目的服务器的端口
    public Client(){
        try {
            socket=new Socket("localhost",13);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //启动接受信息的线程
        GetMsgFromServer getMsgFromServer=new GetMsgFromServer(socket);
        new Thread(getMsgFromServer).start();
    }
    //发送信息的方法
    public void start(){
        Scanner scanner=new Scanner(System.in);
        try {
            PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
            //持续发送信息
            while (true){
                String msg=scanner.next();
                printWriter.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        Client client=new Client();
        client.start();
    }
}
//接受信息的线程
class GetMsgFromServer implements Runnable{

    private Socket socket;

    public GetMsgFromServer(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            String s;
            while((s=bufferedReader.readLine())!=null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
