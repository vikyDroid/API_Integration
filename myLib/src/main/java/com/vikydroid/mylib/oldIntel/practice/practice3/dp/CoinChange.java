package com.vikydroid.mylib.oldIntel.practice.practice3.dp;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=Y0ZqKpToTic  : this link is to find minimum num of coins
public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1};
        int sum = 7;
        System.out.println(getTotalSol(arr, sum));
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(getMinCoinsNeeded(arr, sum, map));
    }

    private static int getMinCoinsNeeded(int[] coins, int sum, Map<Integer, Integer> map) {
        if (sum == 0) return 0;
        if (map.containsKey(sum)) return map.get(sum);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > sum) continue;
            int val = getMinCoinsNeeded(coins, sum - coin, map);
            min = Math.min(min, val);
        }
        min = (min == Integer.MAX_VALUE ? min : min + 1);
        map.put(sum, min);
        return min;
    }

    /**
     * Correct code from github but need to check for:
     * [2, 5, 10] and amount=6, the method should return -1
     * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
     */
    public static int minimumCoinTopDown(int total, int[] coins, Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if (total == 0) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if (map.containsKey(total)) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //if value of coin is greater than total we are looking for just continue.
            if (coins[i] > total) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if (val < min) {
                min = val;
            }
        }

        //if min is MAX_VAL don't change it. Just result it as is. Otherwise add 1 to it.
        min = (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }

    /**
     * Incomplete
     */
    private static int getMinCoinsNeeded(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i]) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - arr[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][sum];
    }

    private static int getTotalSol(int[] arr, int sum) {
        int n = arr.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= sum; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[sum];
    }
    /*private static int getTotalSol(int sum, int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (sum % arr[i] == 0) {
//                sum/arr[i]
                res++;
            } else {

            }
        }

        int[] dp = new int[sum + 1];

        return res;
    }*/
}
