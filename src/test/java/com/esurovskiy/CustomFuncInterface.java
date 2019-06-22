package com.esurovskiy;

@FunctionalInterface
public interface CustomFuncInterface {
    default void print() {
        System.out.println("Hellow from default");
    }

    int calc(int x);
}
