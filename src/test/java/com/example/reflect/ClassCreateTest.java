package com.example.reflect;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * 简单的java类的静态代码块，代码块和构造方法执行顺序测试
 */
public class ClassCreateTest {

    @Test
    public void test(){
         Create create = new Create(300,400);

        System.out.println(create);
    }

    @Test
    public void test1(){
        Class<Sub> clazz = Sub.class;
        System.out.println("============================AnnotatedElement===========================");
        System.out.println(Arrays.toString(clazz.getAnnotations()));    //获取自身和父亲的注解。如果@ATable未加@Inherited修饰，则获取的只是自身的注解而无法获取父亲的注解。
        System.out.println("------------------");
    }
}

class Create{

    private static int num2;

    private static int num1 = 10;

    private int num3 = 30;

    private int num4;

    {
        num4 = 40;
        System.out.println("执行代码块，给num4赋值:" + num4);
        System.out.println("成员变量num3：" + num3);
    }

    static {
        num2 = 20;
        System.out.println("执行静态代码块，给num2赋值:" + num2);
        System.out.println("静态成员变量num1：" + num1);
    }

    public Create() {
    }

    public Create(int num3, int num4) {

        this.num3 = num3;
        this.num4 = num4;
        System.out.println("执行构造方法给num3和num4赋值 num3:" + num3 + "num4:" + num4);
    }

    @Override
    public String toString() {
        return "Create{" +
                "num3=" + num3 +
                ", num4=" + num4 +
                '}';
    }
}
