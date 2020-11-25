package com.example.modes.factory.simple.factory.method;

import com.example.modes.pojo.Product;

/**
 * 抽象工厂，只提供抽象的对象创建方法，具体实现交给实现类
 */
public interface Factory {
    /**
     * 测试下
     * @return
     */
    public Product createProduct();
}
