package com.example.modes.factory.simple.factory.method;

import com.example.modes.pojo.Product;
import com.example.modes.pojo.ProductB;

public class FactoryB implements Factory {

    ProductB productB;

    /**
     * 使用单例模式创建对象
     * @return
     */
    @Override
    public Product createProduct() {
        System.out.println("创建产品B");

        if (productB == null){
            productB = new ProductB();
        }
        return productB;
    }
}
