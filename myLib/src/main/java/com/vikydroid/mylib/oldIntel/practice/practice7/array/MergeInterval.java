package com.vikydroid.mylib.oldIntel.practice.practice7.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeInterval {
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(6, 8));
        list.add(new Interval(1, 9));
        list.add(new Interval(2, 4));
        list.add(new Interval(4, 7));
        list.add(new Interval(12, 19));
        ArrayList<Interval> list1 = mergeInterval(list);
        for (Interval i : list1) {
            System.out.println("[" + i.start + "," + i.end + "]");
        }
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static ArrayList<Interval> mergeInterval(ArrayList<Interval> list) {
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int i = 0;
        for (int j = 1; j < list.size(); j++) {
            if (list.get(i).end >= list.get(j).start) {
//                list.get(i).start = Math.min(list.get(i).start, list.get(j).start);
                list.get(i).end = Math.max(list.get(i).end, list.get(j).end);
            } else {
                i++;
                list.set(i, list.get(j));
            }
        }
        ArrayList<Interval> res = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
            res.add(list.get(j));
        }
        return res;
    }
}
