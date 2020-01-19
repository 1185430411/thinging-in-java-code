package com.jay.test;

import org.junit.Test;
import sun.nio.ch.Net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class TestWeb {
    @Test
    public void test1(){
        try {
            //一个域名绑定多个ip地址
            //与DNS进行交互
            InetAddress[] inetAddress=InetAddress.getAllByName("www.baidu.com");
            for(InetAddress i:inetAddress){
                System.out.println(i);
            }
            //这样通过ip地址去获得对象，并不保证该主机一定存在
            InetAddress inetAddress2=InetAddress.getByName("14.215.177.38");
            System.out.println(inetAddress2.getCanonicalHostName());  //输出域名。但能否获取得到取决了目标地址的安全机制
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            InetAddress inetAddress=InetAddress.getLocalHost();
            System.out.println(inetAddress) ;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        try {
            InetAddress inetAddress=InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.isReachable(100));  //检测地址是否可达
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        try {
            InetAddress inetAddress=InetAddress.getLocalHost();
            NetworkInterface networkInterface=NetworkInterface.getByInetAddress(inetAddress);  //网络接口
            System.out.println(networkInterface);
            System.out.println("----------------------------");
            Enumeration<NetworkInterface> enumeration=NetworkInterface.getNetworkInterfaces();  //获得此主机上所有的网络接口
            while(enumeration.hasMoreElements()){
                System.out.println(enumeration.nextElement());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        try {
            InetAddress inetAddress=InetAddress.getByName("www.sina.com");
            System.out.println(inetAddress);  //www.sina.com/117.21.216.80
            System.out.println(inetAddress.getHostName());  //www.sina.com
            String ip=inetAddress.getHostAddress();
            System.out.println(ip);  //117.21.216.80
            /**
             * ip字符串转为字节数组
             * **/
            String[]ips=ip.split("\\.");
            System.out.println(ips.length);
            byte[]ipByte=new byte[4];
            for(int i=0;i<4;i++){
                int m=Integer.parseInt(ips[i]);
                ipByte[i]=(byte)(m&0xff);
            }

            InetAddress inetAddress1=InetAddress.getByAddress(ipByte);
            System.out.println(inetAddress1.getHostName());  //   117.21.216.80
            System.out.println(inetAddress1.getCanonicalHostName());  //117.21.216.80

            InetAddress inetAddress2 =InetAddress.getByName("117.21.216.80");
            System.out.println(inetAddress2.getHostName());  //   117.21.216.80
            System.out.println(inetAddress2.getCanonicalHostName());  //117.21.216.80
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
