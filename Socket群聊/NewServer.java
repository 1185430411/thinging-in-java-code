package com.jay.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NewServer {

    private class ServerThread extends Thread{

        private Socket socket;

        public ServerThread(Socket socket){
            this.socket=socket;
            try {
                PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
                list.add(printWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            try {
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
                String s;
                while((s=bufferedReader.readLine())!=null)
                    sendToAll(socket+"说:"+s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ServerSocket serverSocket;

    private List<PrintWriter> list;

    public void sendToAll(String msg){
        for(PrintWriter printWriter:list)
            printWriter.println(msg);
    }

    public NewServer(int port){
        try {
            this.serverSocket=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        list=new ArrayList<>();
    }

    public void start(){
        while(true){
            try {
                Socket socket=serverSocket.accept();
                new ServerThread(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[]args){
        NewServer newServer=new NewServer(13);
        newServer.start();
    }
}
