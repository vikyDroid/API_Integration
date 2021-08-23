package com.vikydroid.mylib.oldIntel.practice.practice1.arrays;

public class Remove {
    int A[] = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;

    public static void main(String[] args) {
        Remove demo = new Remove();
        int x = demo.removeElement(demo.A, demo.val);
        System.out.println(x);

        for (int i = 0; i < x; i++) {
            System.out.print(demo.A[i] + " ");
        }
    }


    int removeElement(int[] A, int item) {
        int n = A.length, i, j = 0;
        for (i = 0; i < n; i++) {
            if (A[i] != item) {
                A[j] = A[i];
                j++;
            }
        }
        return j;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


}
