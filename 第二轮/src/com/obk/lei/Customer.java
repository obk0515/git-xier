package com.obk.lei;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int rua;
    private LocalDate date;

    public Customer(String name, int rua, LocalDate date) {
        this.name = name;
        this.rua = rua;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "com.obk.lei.Customer{" +
                "name='" + name + '\'' +
                ", rua=" + rua +
                ", date=" + date +
                '}';
    }
}
