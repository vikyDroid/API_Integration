package com.vikydroid.mylib.oldIntel.initialization;

public class GrandParent {
    static {
        System.out.println("GrandParent.static initializer");
    }
    {
        System.out.println("GrandParent.instance initializer");
    }

    GrandParent(){
        System.out.println("GrandParent.GrandParent constructor");
    }
}
