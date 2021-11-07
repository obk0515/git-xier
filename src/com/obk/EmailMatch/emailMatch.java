package com.obk.EmailMatch;

import java.util.Scanner;

public class emailMatch {
    static boolean matches(String s){
        return s.matches("[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        System.out.println(matches(s));
    }
}
