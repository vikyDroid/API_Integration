package com.vikydroid.mylib.oldIntel.practice.practice7.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] arr = {"cat", "dog", "tac", "god", "act"};
        String[] arr = {"act", "god", "cat", "dog", "tac"};
        List<List<String>> list;
        list = getGroup(arr);
        for (List<String> l : list) {
            for (String s : l) {
                System.out.print(s + " ");
            }
        }
        System.out.println("========");
        List<List<String>> list2;
        list2 = getGroup2(arr);
        for (List<String> l : list2) {
            for (String s : l) {
                System.out.print(s + " ");
            }
        }

    }

    private static List<List<String>> getGroup(String[] arr) {
        List<List<String>> list = new ArrayList<>();
        ArrayList<Dummy> list1 = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char[] chars = arr[i].toCharArray();
            Arrays.sort(chars);
            list1.add(new Dummy(String.valueOf(chars), i));
        }
        Collections.sort(list1, new Comparator<Dummy>() {
            @Override
            public int compare(Dummy o1, Dummy o2) {
                return o1.s.compareTo(o2.s);
            }
        });
        List<String> l1 = new ArrayList<>();
        String s = "";
        for (int i = 0; i < list1.size(); i++) {
            s = list1.get(i).s;
            l1.add(arr[list1.get(i).pos]);
        }
        list.add(l1);
        return list;
    }

    private static List<List<String>> getGroup2(String[] arr) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, ArrayList<Dummy>> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            char[] chars = arr[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            ArrayList<Dummy> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(new Dummy(key, i));
            map.put(key, temp);
        }
        for (String s : map.keySet()) {
            List<String> ss = new ArrayList<>();
            for (Dummy d : map.get(s)) {
                ss.add(arr[d.pos]);
            }
            list.add(ss);
        }
        return list;
    }

    static class Dummy {
        String s;
        int pos;

        Dummy(String s, int pos) {
            this.s = s;
            this.pos = pos;
        }
    }
}
