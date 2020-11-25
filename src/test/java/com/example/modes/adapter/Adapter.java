package com.example.modes.adapter;

public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter() {
    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
          adaptee.specialRequest();
    }
}
