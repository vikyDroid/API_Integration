package com.vikydroid.mylib.oldIntel.initialization;

import javax.swing.*;

public class Parent extends GrandParent {
    String age;

    public Parent(String age) {
        this.age = age;
    }

    private static final String TAG = "Parent";

    Parent() {
        System.out.println("Parent.Parent constructor");
    }

    static {
        System.out.println("Parent.static initializer 1");
    }

    static {
        System.out.println("Parent.static initializer 2");
    }

    {
        System.out.println("Parent.instance initializer 1");
    }

    {
        System.out.println("Parent.instance initializer 2");
    }

    {
        System.out.println("Parent.instance initializer 3");
    }
}
