package com.vikydroid.mylib.oldIntel.accessmodifiers.pack2;

import com.practice.accessmodifiers.pack1.Parent1;

public class Child1 extends Parent1 {
//   protected int hours = 10;

    void testng(){
        this.hours = 4;
        System.out.println(super.hours);
        System.out.println(this.hours);
    }
    public static void main(String[] args) {
        Child1 a = new Child1();
//        System.out.println(a.hours);
//        System.out.println(a.minute);
        a.testng();
    }
}
