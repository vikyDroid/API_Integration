package com.vikydroid.mylib.oldIntel.cloning;

public class NewEmployee implements Cloneable {
    int age;
    String name;

    public NewEmployee(int age, String name) {
        this.age = age;
        this.name = name;
    }

   /* @Override
    public String toString() {
        return "NewEmployee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
