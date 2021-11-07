package com.obk.Multithreading;

public class AlternateOutputTest{
    public static void main(String[] args) {
        final Object obj = new Object();
        int[] a={1,3,5,7,9};
        int[] b={2,4,6,8,10};
        new Thread(() -> {
            synchronized (obj){
                for(int num : a){
                    System.out.print(num + " ");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (obj){
                for(int num : b){
                    System.out.print(num + " ");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }).start();
    }
}
