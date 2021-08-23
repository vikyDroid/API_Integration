package com.vikydroid.mylib.oldIntel.practice.practice4;

import com.vikydroid.mylib.oldIntel.practice.practice2.templateT.Stack;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayFunctions {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        Integer[][] arr2 = {{1, 3}, {5, 7}, {6, 8}, {2, 4}};
        Integer[][] arr3 = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        int[] arr4 = {100, 180, 260, 310, 40, 535, 695};
        int[] arr5 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int key = 10;
        int sum = 22;
//        mergeInterval(arr2);
//        System.out.println(maxSumSubArray(arr));
//        System.out.println();
//        System.out.println(maxSumSubArrayWithPos(arr));
//        System.out.println(trapWater(arr5));
//        printSumPair(arr, sum);
//        System.out.println(searchInSortedRotated(arr, key));
//        System.out.println(Arrays.toString(mergeTwoSorted(arr, arr2)));
//        tripletSum(arr, sum);
//        mergeInterval(arr3);
        stockBuy(arr4);
//        System.out.println(maxSumSubArrayWithPos(arr));
//        findDuplicatesInPlace(arr);
//        System.out.println();
//        findDuplicatesInPlace2(arr);
    }

    static void printSumPair(int[] arr, int sum) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int i = arr[l] + arr[r];
            if (i == sum) {
                System.out.print("(" + arr[l] + "," + arr[r] + ") ");
                l++;
                r--;
            } else if (i < sum) {
                l++;
            } else {
                r--;
            }
        }
    }

    static int searchInSortedRotated(int[] arr, int val) {
        int n = arr.length;
        int l = 0, r = n - 1;
        int pivotIndex = getPivotInSortedRotated(arr, l, r - 1);
        if (arr[pivotIndex] == val)
            return pivotIndex;
        if (arr[0] < val) {
            return binarySearchInSorted(arr, val, l, pivotIndex - 1);
        } else {
            return binarySearchInSorted(arr, val, pivotIndex + 1, r);
        }
    }

    static int getPivotInSortedRotated(int[] arr, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[mid] > arr[l]) {
            return getPivotInSortedRotated(arr, mid + 1, r);
        } else return getPivotInSortedRotated(arr, l, mid - 1);
    }

    private static int binarySearchInSorted(int[] arr, int val, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (arr[mid] == val) return mid;
        if (arr[mid] < val) {
            return binarySearchInSorted(arr, val, mid + 1, r);
        } else {
            return binarySearchInSorted(arr, val, l, mid - 1);
        }
    }

    static int[] mergeTwoSorted(int[] arr1, int[] arr2) {
        int l = 0, r = 0, f = 0, i = arr1.length, j = arr2.length, k = i + j;
        int[] arr3 = new int[k];
        while (l < i && r < j) {
            if (arr1[l] < arr2[r]) {
                arr3[f++] = arr1[l++];
            } else {
                arr3[f++] = arr2[r++];
            }
        }
        while (l < i) {
            arr3[f++] = arr1[l++];
        }
        while (r < j) {
            arr3[f++] = arr2[r++];
        }
        return arr3;
    }

    static void tripletSum(int[] arr, int sum) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int l = i + 1, r = arr.length - 1;
            int remaining = sum - arr[i];
            while (l < r) {
                int sumInside = arr[l] + arr[r];
                if (sumInside == remaining) {
                    System.out.println("(" + arr[i] + "," + arr[l] + "," + arr[r] + ")");
                    l++;
                    r--;
                } else if (sumInside < remaining) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }

    static int singleNum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return Integer.MIN_VALUE;
    }


    static int findMissing(int[] arr) {
        int n = arr.length;
        int sum = (1 + n + 1) * (n + 1) / 2;
        int sumTemp = 0;
        for (int val : arr) {
            sumTemp += val;
        }
        return sum - sumTemp;
    }

    static void findDuplicates(int[] arr, int duplicateByOrMore) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) >= duplicateByOrMore) {
                System.out.print(key + " ");
            }
        }
    }

    static void findDuplicatesInPlace(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[arr[i] % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= n * 2) {
                System.out.print(i + " ");
            }
        }
    }


    static int maxSumSubArray(int[] arr) {
        int maxSumSoFar = arr[0], maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(arr[i], maxSum + arr[i]);
            maxSumSoFar = Math.max(maxSum, maxSumSoFar);
        }
        return maxSumSoFar;
    }

    static int maxSumSubArrayWithPos(int[] arr) {
        int maxSumSoFar = Integer.MIN_VALUE, maxSum = 0, start = 0, end = 0, temp = 0;
        for (int i = 1; i < arr.length; i++) {
            maxSum += arr[i];
            if (maxSumSoFar < maxSum) {
                maxSumSoFar = maxSum;
                end = i;
                start = temp;
            }
            if (maxSum < 0) {
                maxSum = 0;
                temp = i + 1;
            }
        }
        System.out.println("Start Index: " + start);
        System.out.println("End Index: " + end);
        return maxSumSoFar;
    }

    //Recheck, not verified  :: Verified on 28 jan 21, IT IS Wrong
    static void mergeInterval(Integer[][] arr) {
        Stack<Integer[]> stack = new Stack<>();
        for (Integer[] integers : arr) {
            if (stack.isEmpty()) {
                stack.push(integers);
            } else {
                Integer[] temp = stack.pop();
                if (temp[1] > integers[0] && temp[1] < integers[1]) {
                    temp[1] = integers[1];
                    stack.push(temp);
                } else {
                    stack.push(temp);
                    stack.push(integers);
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(stack.pop()));
        }
    }

    static void stockBuy(int[] arr) {
        int n = arr.length;
        boolean isBought = false;
        for (int i = 0; i < n - 1; i++) {
            if (isBought) {
                if (arr[i] > arr[i + 1]) {
                    System.out.println("Sell at day: " + i);
                    isBought = false;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    System.out.println("Buy at day: " + i);
                    isBought = true;
                }
            }
        }
        System.out.println("Sell at day: " + (n - 1));
    }

    static int trapWater(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = findLeftMax(arr, i);
            int maxRight = findRightMax(arr, i);
            int diff = Math.min(maxLeft, maxRight) - arr[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

    private static int findLeftMax(int[] arr, int curr) {
        int maxLeft = 0;
        for (int j = curr - 1; j >= 0; j--) {
            maxLeft = Math.max(maxLeft, arr[j]);
        }
        return maxLeft;
    }

    private static int findRightMax(int[] arr, int curr) {
        int maxRight = 0;
        for (int j = curr + 1; j < arr.length; j++) {
            maxRight = Math.max(maxRight, arr[j]);
        }
        return maxRight;
    }
}
