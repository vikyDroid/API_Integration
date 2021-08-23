package com.vikydroid.mylib.oldIntel.practice.practice2.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strArr = new String[]{"cat", "dog", "tac", "god", "act"};
//        new GroupAnagrams().groupAnagrams(strArr);
        new GroupAnagrams().groupAnagrams3(strArr);

    }

    public void groupAnagrams(String[] strArr) {
        int n = strArr.length;
        int[] index = new int[n];
        String[] strInner = new String[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
            strInner[i] = strArr[i];
        }
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        System.out.println();

        /*for (int i = 0; i < n; i++) {
            strArr[i].compareTo(strArr[i + 1]);
        }*/
    }

    public void groupAnagrams2(String[] strArr) {
        int n = strArr.length;
        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = strArr[i];
            int key = getKey(str);
//            if (hm.containsKey(key)){
            hm.put(key, str);
//            }
        }
        for (Map.Entry e :
                hm.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    private int getKey(String str) {
        String s;
        int n = str.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += str.charAt(i);
        }
        return sum;
    }


    static class Word {
        String str;
        int index;

        Word(String str, int index) {
            this.str = str;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "text='" + str + '\'' +
                    ", index=" + index +
                    '}';
        }
    }

    public void groupAnagrams3(String[] strArr) {
        int n = strArr.length;
        Word[] array = new Word[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Word(strArr[i], i);
        }
        System.out.println("Before Sort:" + Arrays.toString(strArr));
        for (int i = 0; i < n; i++) {
            char[] chars = array[i].str.toCharArray();
            Arrays.sort(chars);
            array[i].str = new String(chars);
            System.out.println(chars);
        }
        Arrays.sort(array, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.str.compareTo(o2.str);
            }
        });
        System.out.println("After Sort:" + Arrays.toString(array));
        for (int i = 0; i < n; i++) {
            System.out.print(strArr[array[i].index]+" ");
        }
        /*String temp = array[0].str;
        for (int i = 0; i < n; i++) {
            Word item = array[i];
            if (temp.equals(item.str)) {
                System.out.print(strArr[item.index] + " ");
            } else {
                temp = item.str;
                i--;
            }
        }*/
    }

}
