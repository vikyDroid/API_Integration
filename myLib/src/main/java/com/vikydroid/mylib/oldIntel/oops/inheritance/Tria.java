package com.vikydroid.mylib.oldIntel.oops.inheritance;

import com.practice.oops.abstracation.ChildSecondAddr;

public class Tria {
    public static void main(String[] args) {
        /*Paa paa = new Paa();

        Addr age = paa.getAddress();
        System.out.println(age);
        age.s = "asdasdasd";
        System.out.println(paa.getAddress());*/

//        age = paa.getAddress();
//        System.out.println(age);

        ChildSecondAddr childAddr = new ChildSecondAddr();
        System.out.println(childAddr.num);
        System.out.println(childAddr.print());
//        System.out.println(childAddr.printMore());
        System.out.println(childAddr.num);

//        Addr.TesttInner testtInner = new Addr.TesttInner();

    }
}
