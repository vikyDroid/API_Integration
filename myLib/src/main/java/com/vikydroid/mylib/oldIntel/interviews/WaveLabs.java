package com.vikydroid.mylib.oldIntel.interviews;

/*
* Write a recursive function that takes an integer and shuffles it.
*  Shuffle one digit from the front and one digit from the back,
*  then the second from the front and the second from the back,
* and so on until the shuffled number is the same as that original.

For example, 123456 would print as 162534
* */
public class WaveLabs {
    public static void main(String[] args) {
        int a = 123456;
        //162345
        //162534

        //6
        //100000  // 10^n-1
        //10000   //10^n-2  // remainder as 2
        //n-1
        //12345   6
        //1(first)*10 + 6(last) = 16 * 10 + 2 (reaminder)  // 162

        //n-3
        //10^n-3  //1000

        //n-2
        //123456
        System.out.println(output(a)); //162534
    }

    private static int output(int a) {
        //base case
        if (a <= 0) return 0;
        int n = String.valueOf(a).length();//6
        int t = a;
        t /= (int) Math.pow(10, n - 1);
        int last = a % 10;
        int res = (t * 10 + last) * ((int) Math.pow(10, n - 2)) + output((a % (int) Math.pow(10, n - 2)) / 10); //16
        return res;
    }
}
