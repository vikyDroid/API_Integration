package com.vikydroid.mylib.oldIntel.cloning.copyconstructor;

//Drawback of copy constructor
public class TestAnother {
    public static void main(String[] args) {
        PointOne one = new PointOne(1, 2);
        PointTwo two = new PointTwo(1, 2, 3);

        PointOne clone1 = new PointOne(one);
        PointOne clone2 = new PointOne(two);

        //This is the problem, both return same class name
        System.out.println(clone1.getClass());
        System.out.println(clone2.getClass());

        String[] array = {"one", "two", "three"};
        String[] copiedArray = array.clone();
        System.out.println(array.hashCode() == copiedArray.hashCode());
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].hashCode() == copiedArray[i].hashCode());
        }
        System.out.println("--------");
//        copiedArray[0] = "das";
//        copiedArray[1] = "das";
//        copiedArray[2] = "das";
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].hashCode() == copiedArray[i].hashCode());
        }
    }
}
