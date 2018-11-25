package com.example.app;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Data
//@RequiredArgsConstructor
public class Argument {
    private final int a;
    private final int b;

    public Argument(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }
}
