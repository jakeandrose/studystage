package com.example.modes.factory.simple;

import com.example.modes.pojo.Product;
import com.example.modes.pojo.ProductA;
import com.example.modes.pojo.ProductB;

/**
 * 简单工厂的实现
 */
public class SimpleFactory {

    /**
     * 静态的创建对象方法，通过传入外部参数，创建相应的对象给调用者
     * @param product
     * @return
     */
    public static Product createProduct(String product){
        switch (product){
            case "A":
                return new ProductA();

            case "B" :
                return new ProductB();

            default:
                System.out.println("没有该系列的产品");
                return null;

        }
    }
}
