package com.vikydroid.mylib.oldIntel.oops;

public class CheckConstructorCall {
    public static void main(String[] args) {
        Child child = new Child();
//        Parent parent = new Parent();

    }
}

class Parent {
    int age;

    Parent(int age) {
        this.age = age;
    }

//    Parent() {
//        System.out.println("Parent constructor");
//    }

    public String publicData = "public data";
    private String privateData = "private data";
    protected String protectedData = "protected data";

}

class Child extends Parent {
    Child() {
        super(2);
        System.out.println("Child constructor");
    }
}
