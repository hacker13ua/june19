package com.esurovskiy;


public class MyObject {


    private long a;

    public MyObject(final long a) {
        this.a = a;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize call");
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        MyObject myObject = new MyObject(2200);
        System.out.println("myObject = "+ myObject);
        myObject = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("Object = "+ myObject);
    }
}
