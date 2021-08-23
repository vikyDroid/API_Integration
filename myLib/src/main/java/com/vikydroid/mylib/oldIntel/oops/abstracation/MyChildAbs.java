package com.vikydroid.mylib.oldIntel.oops.abstracation;

public class MyChildAbs extends MyAbstract {
    MyChildAbs() {
        System.out.println("Dasdasd");
    }

    @Override
    void myFun1() {
        System.out.println("Child fun 1");
    }

    @Override
    void myFun2() {

    }

    @Override
    void myFun3() {

    }

    public static void main(String[] args) {
        MyChildAbs myChildAbs = new MyChildAbs();
        MyAbstract myAbstract = new MyAbstract() {
            @Override
            void myFun1() {
                System.out.println("myFun1");
            }

            @Override
            void myFun2() {
                System.out.println("myFun2");
            }

            @Override
            void myFun3() {
                System.out.println("myFun3");
            }
        };

        myChildAbs.myFun1();
        myAbstract.myFun1();
    }
}
