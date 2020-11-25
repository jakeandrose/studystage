package com.example.modes.factory.simple.factory.method;

import com.example.modes.pojo.Product;
import com.example.modes.pojo.ProductA;

/**
 * 产品A的工厂，只常见产品A的对象
 */
public class FactoryA implements Factory {

    Product productA;

    /**
     * 使用单例模式创建对象
     * @return
     */
    @Override
    public Product createProduct() {
        System.out.println("创建产品A");

        if (productA == null){
            productA = new ProductA();
        }

        return productA;
    }
}
