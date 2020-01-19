package com.jay.test;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class TestURLConnection {

    @Test
    public void test1(){
        URL url= null;
        try {
            url = new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            InputStream inputStream=urlConnection.getInputStream();
            InputStream is=new BufferedInputStream(inputStream);
            Reader reader=new InputStreamReader(is);
            int c=0;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        URL url= null;
        try {
            url = new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            //返回主体内容类型
            System.out.println(urlConnection.getContentType());   //text/html
            //内容中字节数，若太大以至于超过了int的范围，会返回-1
            System.out.println(urlConnection.getContentLength());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //从web网站中下载二进制文件
    @Test
    public void download(){
        try {
            URL url=new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            String contextType=urlConnection.getContentType();
            int contextLength=urlConnection.getContentLength();
            if(contextType.startsWith("text/")||contextLength==-1){
                throw new IOException("这不是一个二进制文件");
            }
            InputStream inputStream=urlConnection.getInputStream();
            InputStream in=new BufferedInputStream(inputStream);
            byte[]read=new byte[contextLength];
            int offset=0;
            //将文件内容写在字节数组内
            while(offset<contextLength){
                int readLine=in.read(read,offset,read.length-offset);
                if(readLine==-1)
                    break;
                offset+=readLine;
            }
            FileOutputStream fileOutputStream=new FileOutputStream("abc.txt");
            fileOutputStream.write(read);
            fileOutputStream.flush();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        try {
            URL url=new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            System.out.println(urlConnection.getContentEncoding());  //获取编码方式，没有设置则返回null

            System.out.println(urlConnection.getDate());  //1579439658000  文件发送时间
            System.out.println(new Date(urlConnection.getDate()));

            System.out.println(urlConnection.getExpiration());  //文件过期时间，0则代表永不过期

            System.out.println(new Date(urlConnection.getLastModified()));  //最后一次修改时间
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6(){
        URL url= null;
        try {
            url = new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            for(int i=0;;i++){
                String header=urlConnection.getHeaderField(i);
                if(header==null)
                    break;
                System.out.println(urlConnection.getHeaderFieldKey(i)+":"+header);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓存Cache
     * **/
    //ifModifiedSince
    @Test
    public void test7(){
        try {
            URL url=new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            System.out.println(urlConnection.getIfModifiedSince());  //在这个时期之后文件被修改过，则重新读

            urlConnection.setIfModifiedSince((new Date(new Date().getTime()-24*60*60*1000)).getTime());  //设置为昨天

            System.out.println(new Date(urlConnection.getIfModifiedSince()));

            InputStream in=urlConnection.getInputStream();
            InputStream inputStream=new BufferedInputStream(in);
            Reader r=new InputStreamReader(inputStream);
            int c;
            while((c=r.read())!=-1){
                System.out.print((char)c);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //useCaches
    @Test
    public void test8(){
        try {
            URL url=new URL("http://www.baidu.com");
            URLConnection urlConnection=url.openConnection();
            urlConnection.setUseCaches(false);  //设置之后，不使用缓存，每次都从服务器获取
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 向服务器写数据
     */
    //表单提交
    @Test
    public void test9(){
        try {
            URL url=new URL("http://localhost:8080/test");
            URLConnection urlConnection=url.openConnection();
            urlConnection.setDoOutput(true);

            OutputStreamWriter out=new OutputStreamWriter(urlConnection.getOutputStream(),"utf-8");
            out.write("&name=jay&age=18");
            out.write("\r\n");
            out.flush();
            InputStream in=urlConnection.getInputStream();
            Reader r=new InputStreamReader(in);
            int c;
            while((c=r.read())!=-1)
                System.out.print((char)c);
            out.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //HttpURLConnection
    @Test
    public void test0(){
        try {
            URL url=new URL("http://www.baidu.com");
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("HEAD");  //使用GET也可以，不过我们需要的信息通过HEAD就可以得到，减小开销
            System.out.println("文件上次修改时间为："+new Date(httpURLConnection.getLastModified()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
