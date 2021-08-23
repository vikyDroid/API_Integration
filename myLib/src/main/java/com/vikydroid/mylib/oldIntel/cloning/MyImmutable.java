package com.vikydroid.mylib.oldIntel.cloning;

public class MyImmutable implements Cloneable{
    private StringBuilder builder;

    public MyImmutable(StringBuilder builder) {
        this.builder = builder;
    }

    public StringBuilder getBuilder() {
        return builder;
    }
    public void setBuilder(StringBuilder s) {
         this.builder = s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        MyImmutable e = (MyImmutable) super.clone();
//        e.setBuilder(e.builder);
        return super.clone();
    }

    @Override
    public String toString() {
        return "MyImmutable{" +
                "builder=" + builder +
                '}';
    }
}
