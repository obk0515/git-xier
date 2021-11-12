package com.obk.lei;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class myTest {
    /**
     * 余额不足
     */
    @Test
    public void test1() {
        ArrayList<Cat> catArrayList=new ArrayList<>();
        ArrayList<Customer> customerArrayList=new ArrayList<>();


        MyCatCafe myCatCafe=new MyCatCafe(10,catArrayList,customerArrayList);
        myCatCafe.buyCat(new BlackCat("aaa",5,"公"));
    }

    /**
     * 无猫可rua
     */
    @Test
    public void test2(){
        ArrayList<Cat> catArrayList=new ArrayList<>();
        ArrayList<Customer> customerArrayList=new ArrayList<>();

        MyCatCafe myCatCafe=new MyCatCafe(10,catArrayList,customerArrayList);
        myCatCafe.entertainCustomer(new Customer("aaa",3, LocalDate.now()));
    }

    @Test
    public void test3(){
        ArrayList<Cat> catArrayList=new ArrayList<>();
        ArrayList<Customer> customerArrayList=new ArrayList<>();

        MyCatCafe myCatCafe=new MyCatCafe(10000,catArrayList,customerArrayList);
        myCatCafe.buyCat(new BlackCat("aaa",5,"公"));
        myCatCafe.buyCat(new BlackCat("bbb",6,"母"));
        myCatCafe.buyCat(new BlackCat("ccc",7,"公"));
        myCatCafe.entertainCustomer(new Customer("AAA",3, LocalDate.now()));
        myCatCafe.entertainCustomer(new Customer("BBB",2, LocalDate.parse("2021-10-01")));
        myCatCafe.entertainCustomer(new Customer("CCC",1, LocalDate.now()));
        System.out.println("---------------");
        myCatCafe.close();
    }
}
