package com.jay.test;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;

    //初始化服务器信息，绑定端口
    public Server(){
        try {
            serverSocket=new ServerSocket(13);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        while(true){
            try {
                Socket socket=serverSocket.accept();
                //接受信息的线程
                new Thread(new ServerThread(socket)).start();
                String s;
                Scanner scanner=new Scanner(System.in);
                PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
                while(true){
                    s=scanner.next();
                    printWriter.println(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Server server=new Server();
        server.start();
    }
}
class ServerThread implements Runnable{

    private Socket socket;

    public ServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            //获取对应的缓冲输入流
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            String s;
            //持续接受信息
            while((s=bufferedReader.readLine())!=null)
                System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

