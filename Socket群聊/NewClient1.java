package com.jay.test;



import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class NewClient1 {

    private Socket socket;

    public class ClientThread extends Thread{
        @Override
        public void run() {
            try {
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
                String str;
                while((str=bufferedReader.readLine())!=null)
                    System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error");
            }
        }
    }

    public NewClient1(String ip,int post){
        try {
            this.socket=new Socket(ip,post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new ClientThread().start();
    }

    public void start(){
        try {
            PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
            Scanner sc=new Scanner(System.in);
            while(true){
                String s=sc.next();
                printWriter.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        NewClient1 newClient1=new NewClient1("localhost",13);
        newClient1.start();
    }
}
