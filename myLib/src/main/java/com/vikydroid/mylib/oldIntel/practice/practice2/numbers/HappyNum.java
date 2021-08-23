package com.vikydroid.mylib.oldIntel.practice.practice2.numbers;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public static void main(String[] args) {
        int num = 8;
        System.out.println(new HappyNum().isHappyNum(num));
        System.out.println(new HappyNum().isHappyNum2(num));
    }

    //Efficient
    public boolean isHappyNum2(int num) {
        int slow = num, fast = num;
        do {
            slow = numSquareSum(slow);
            fast = numSquareSum(numSquareSum(fast));
        }
        while (slow != fast);
        return (slow == 1);
    }

    public boolean isHappyNum(int num) {
        Set<Integer> st = new HashSet<>();
        while (true) {
            num = numSquareSum(num);
            if (num == 1)
                return true;
            if (st.contains(num))
                return false;
            st.add(num);
        }
    }

    private int numSquareSum(int num) {
        int squareSum = 0;
        while (num > 0) {
            squareSum += (num % 10) * (num % 10);
            num /= 10;
        }
        return squareSum;
    }

}
