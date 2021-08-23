package com.vikydroid.mylib.oldIntel.initialization;

public class Child extends Parent {
    int a, b, c;

    public Child(int a) {
        this.a = a;
    }

    public Child(int a, int b) {
        this(a);
        this.b = b;
//        System.out.println("a: " + this.a + ", b: " + this.b);
    }
    public Child(int a, int b, int c){
        this(a, b);
        this.c = c;
    }

    Child() {
        System.out.println("Child.Child constructor");
    }

    static {
        System.out.println("Child.static initializer 1");
    }

    static {
        System.out.println("Child.static initializer 2");
    }

    {
        System.out.println("Child.instance initializer 1");
    }

    {
        System.out.println("Child.instance initializer 2");
    }

    {
        System.out.println("Child.instance initializer 3");
    }

    @Override
    public String toString() {
        return "Child{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
