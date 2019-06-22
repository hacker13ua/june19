package com.esurovskiy;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        final HashMap hashMap = new HashMap();
        final WeakHashMap weakHashMap = new WeakHashMap();
        String keyHM = new String("keyHM");
        String keyWHM = new String("keyWHM");
        hashMap.put(keyHM, "HASHMAP");
        weakHashMap.put(keyWHM, "WHM");
        System.gc();
        Thread.sleep(1000);
        System.out.println("strong " + hashMap);
        System.out.println("weak "+ weakHashMap);
        keyHM = null;
        keyWHM = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("strong " + hashMap);
        System.out.println("weak "+ weakHashMap);

    }
}
