package com.vikydroid.mylib.oldIntel.equals;

import java.util.Objects;

public class MyEmployee {
    String name;
    int age;
    int height;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEmployee myEmployee = (MyEmployee) o;
        return age == myEmployee.age &&
                height == myEmployee.height &&
                Objects.equals(name, myEmployee.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
    }

    public static void main(String[] args) {
        String s1 = "Dad";
        String s2 = new String("Dad");

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
