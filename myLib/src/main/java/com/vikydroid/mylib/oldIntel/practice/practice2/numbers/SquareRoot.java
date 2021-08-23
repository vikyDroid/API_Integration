package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(new SquareRoot().squareRootBS(129));

    }

    //O(log n)
    public int squareRootBS(int key) {
        if (key == 0 || key == 1) {
            return key;
        }
        int l = 1, r = key, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            int prod = mid * mid;
            if (prod == key) {
                return mid;
            }
            if (prod < key) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //O(sqrt n)
    public int squareRoot(int key) {
        int ans = 0;
        if (key == 0 || key == 1) {
            return key;
        }
        int i = 2;
        int product = 0;
        while (product <= key) {
            i++;
            product = i * i;
        }
        return i - 1;
    }

}
