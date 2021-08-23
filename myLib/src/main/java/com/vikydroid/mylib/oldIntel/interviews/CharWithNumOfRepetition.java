package com.vikydroid.mylib.oldIntel.interviews;

//Nagarro
//Print chars with their reps num in alphabetic order
public class CharWithNumOfRepetition {
    public static void main(String[] args) {
        String s = "zxvczbaa";
        System.out.println(wirthReps(s));
    }

    private static String wirthReps(String s) {
        int n = s.length(), size = 256;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[size];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] > 1) {
                sb.append((char) i);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
