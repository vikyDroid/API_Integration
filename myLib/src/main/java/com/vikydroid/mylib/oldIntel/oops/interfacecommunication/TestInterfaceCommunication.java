package com.vikydroid.mylib.oldIntel.oops.interfacecommunication;

public class TestInterfaceCommunication {

    public static void main(String[] args) {
        DoSomething doSomething = new DoSomething(new MyInterface() {
            @Override
            public void onClickA() {
                System.out.println("function A");
            }

            @Override
            public void onClickB() {
                System.out.println("function B");
            }
        });
        doSomething.callBackB();
        doSomething.callBackA();
    }

    /*@Override
    public void onClickA() {
        System.out.println("Print A");
    }

    @Override
    public void onClickB() {
        System.out.println("Print B");
    }*/
}
