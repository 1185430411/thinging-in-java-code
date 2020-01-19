package com.jay.test;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    @Test
    public void test1(){
        try {
            URL url=new URL("http://www.baidu.com");

            URL url1=new URL("http","www.baidu.com","/abc.html");//使用默认端口80

            URL url2=new URL("http","www.baidu.com",8080,"/abc.html");//显示指定端口

            URL url3=new URL("http://www.baidu.com/abc.html");
            URL url4=new URL(url3,"def.html");  //http://www.baidu.com/def.html
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        InputStream inputStream=null;
        try {
            URL url=new URL("http://www.alibaba.com");
            inputStream=url.openStream();
            inputStream= new BufferedInputStream(inputStream);
            Reader reader=new InputStreamReader(inputStream);
            int count=0;
            while((count=reader.read())!=-1){
                System.out.print((char)count);
            }
            Object o=url.getContent();
            System.out.println(o);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        try {
            URL url=new URL("http://www.baidu.com/path1/path2?name=jay#123");
            System.out.println(url.getProtocol());   //http
            System.out.println(url.getHost());      //www.baidu.com
            System.out.println(url.getPort());      //-1
            System.out.println(url.getDefaultPort());   //80
            System.out.println(url.getFile());      ///path1/path2?name=jay

            System.out.println("-------------------------------------");

            System.out.println(url.getPath());      // /path1/path2
            System.out.println(url.getRef());       //123(标识符)
            System.out.println(url.getQuery());     //name=jay
            System.out.println(url.getUserInfo());  //null(用户信息)
            System.out.println(url.getAuthority()); //www.baidu.com

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
