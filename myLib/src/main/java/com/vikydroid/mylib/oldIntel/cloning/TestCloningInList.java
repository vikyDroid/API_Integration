package com.vikydroid.mylib.oldIntel.cloning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestCloningInList {
    public static void main(String[] args) {
        ArrayList<NewEmployee> original = new ArrayList<>();
        original.add(new NewEmployee(2, "vivek"));
        original.add(new NewEmployee(3, "rahul"));
        original.add(new NewEmployee(1, "komal"));
        original.add(new NewEmployee(4, "shahshank"));
        original.add(new NewEmployee(5, "vicky"));


        //ArrayList().clone() would provide shallow copy only
        ArrayList<NewEmployee> clone = new ArrayList<>();/*(ArrayList<NewEmployee>) original.clone()*/;
        for (NewEmployee newEmployee : original) {
            try {
                clone.add((NewEmployee) newEmployee.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Is Hashcode same :");
        System.out.println(original.hashCode() == clone.hashCode());

        for (int i = 0; i < original.size(); i++) {
            if (original.get(i).hashCode() == clone.get(i).hashCode()) {
                System.out.println("Hashcode is : SAME");
            } else {
                System.out.println("Hashcode is : NOT-SAME");
            }
        }

        original.get(0).age = 10000;
        System.out.println("------------------" + clone.get(0).age);
        for (int i = 0; i < original.size(); i++) {
            if (original.get(i).hashCode() == clone.get(i).hashCode()) {
                System.out.println("Hashcode is : SAME");
            } else {
                System.out.println("Hashcode is : NOT-SAME");
            }
        }
    }
}
