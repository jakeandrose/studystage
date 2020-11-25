package com.example.modes;

import com.example.modes.factory.simple.SimpleFactory;
import com.example.modes.factory.simple.factory.method.FactoryA;
import com.example.modes.factory.simple.factory.method.FactoryB;
import com.example.modes.pojo.Product;
import com.example.modes.pojo.ProductA;
import com.example.modes.pojo.ProductB;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    /**
     * 测试简单工厂创建对象
     */
    @Test
    public void test(){

        Product product = SimpleFactory.createProduct("A");

        System.out.println(product);
    }

    /**
     * 测试工厂方法创建对象
     */
    @Test
    public void test1() throws Exception {

        ProductA productA = (ProductA) FactoryA.class.newInstance().createProduct();

        ProductB productB = (ProductB) FactoryB.class.newInstance().createProduct();

        

    }
}
