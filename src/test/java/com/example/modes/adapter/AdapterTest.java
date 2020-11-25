package com.example.modes.adapter;

import org.junit.jupiter.api.Test;

public class AdapterTest {

    @Test
    public void test(){

        Adaptee adaptee = new Adaptee();

        Target target = new Adapter(adaptee);

        target.request();
    }
}
