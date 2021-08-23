package com.vikydroid.mylib.oldIntel.cloning;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.youtube.com/watch?v=e0PUoHgpdM0&t=188s
public class TestArrayCloneVsCopy {
    public static void main(String[] args) {
        int[][] a = {
                {1, 1},
                {2, 2}
        };
        int[][] b;// = new int[a.length][a[0].length];

        /*NewEmployee[] c = {
                new NewEmployee(1, "vivek"),
                new NewEmployee(2, "komu")
        };*/
        String[] c = {"1", "2", "3", "4", "5"};
        b = a.clone();
        String[] d = c.clone()/*Arrays.copyOf(c, c.length)*/;
        c[0] += "dsada";
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        for (int i = 0; i < c.length; i++) {
            if (c.hashCode() == d.hashCode()) {
                System.out.println("SAME");
            } else {
                System.out.println("NOT-SAME");
            }
        }
        /*for (int i = 0; i < a.length; i++) {
            b[i] = a[i].cloneStrArr();
        }*/
        a[0][0]++;
       /* for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.println(b);
            }
        }*/
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }

        System.out.println("---------");
        String[][] strArr = {
                {"!", "2"},
                {"#", "$"}
        };
        String[][] cloneStrArr = new String[2][2]/*strArr.clone()*/;
        for (int i = 0; i < cloneStrArr.length; i++) {
            for (int j = 0; j < cloneStrArr[i].length; j++) {
                cloneStrArr[i][j] = "" + strArr[i][j];
            }
        }
        strArr[0][0] = "appe";
        for (int i = 0; i < cloneStrArr.length; i++) {
            for (int j = 0; j < cloneStrArr[i].length; j++) {
                System.out.print(cloneStrArr[i][j] + ", ");
            }
        }
        System.out.println("+++++++++");
        int[][] mat = {
                {1, 1},
                {2, 2}
        };
        int[][] cloneMat = new int[2][2];/*mat.clone()*/;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                cloneMat[i][j] = mat[i][j];
            }
        }
        mat[0][0]++;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(cloneMat[i][j] + ", ");
            }
        }
    }
}
