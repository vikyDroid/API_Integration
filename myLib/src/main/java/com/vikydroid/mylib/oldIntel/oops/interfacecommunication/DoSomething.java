package com.vikydroid.mylib.oldIntel.oops.interfacecommunication;

public class DoSomething {
    private final MyInterface communication;

    DoSomething(MyInterface communication) {
        this.communication = communication;
    }

    void callBackA() {
        ((MyInterface) communication).onClickA();
    }

    void callBackB() {
        ((MyInterface) communication).onClickB();
    }
}
