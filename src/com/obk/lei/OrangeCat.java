package com.obk.lei;

public class OrangeCat extends Cat{
    private boolean isFat;

    public OrangeCat(String name, int age, String sex, boolean isFat) {
        super(name, age, sex, 200);
        this.isFat = isFat;
    }
}
