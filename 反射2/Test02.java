package com.jay.test;

import com.jay.model.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test02 {

    @Test
    public void test01(){
        try {
            Class c1=Class.forName("com.jay.model.Person");
            Class c2= Person.class;
            Person p=new Person();
            Class c3=p.getClass();
            System.out.println(c1==c2); //true
            System.out.println(c2==c3);  //true
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            //读取时需要加上类的包名
            Class clazz = Class.forName("com.jay.model.Person");
            System.out.println(clazz.getName()); //com.jay.model.Person
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03(){
        try {
            //读取时需要加上类的包名
            Class clazz = Class.forName("com.jay.model.Person");
            Object o = clazz.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04(){
        try {
            Class c=Class.forName("com.jay.model.Person");
            //获取所有属性
            Field[]fields=c.getDeclaredFields();
            for(Field f:fields){
                System.out.println(f);  //private java.lang.String com.jay.model.Person.name
                System.out.println(f.getName());  //name
                System.out.println(f.getModifiers());  //2
                System.out.println(Modifier.toString(f.getModifiers()));  //private
                Class class1=f.getClass();
                System.out.println(class1.getName());  //java.lang.reflect.Field
                Class type=f.getType();
                System.out.println(type.getName());  //java.lang.String
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05(){
        try {
            Class c=Class.forName("com.jay.model.Person");
            Field f=c.getDeclaredField("name");
            Person person=(Person) c.newInstance();
            f.setAccessible(true);  //name属性是private的，这里从外部打破封装
            f.set(person,"jay");
            System.out.println(f.get(person));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06(){
        Class c= null;
        try {
            c = Class.forName("com.jay.model.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[]methods=c.getDeclaredMethods();
        for(Method m:methods){
            System.out.println(Modifier.toString(m.getModifiers()));
            Class type=m.getReturnType();
            System.out.println(type.getSimpleName());
            System.out.println(m.getName());
            Class[]param=m.getParameterTypes();
            for(Class  p:param){
                System.out.println(p.getSimpleName());
            }
        }
    }

    @Test
    public void test07(){
        try {
            Class c=Class.forName("com.jay.model.Person");
            Method m=c.getDeclaredMethod("sing", String.class);
            Object o=c.newInstance();
            Object res=m.invoke(o,"七里香");
            System.out.println(res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
