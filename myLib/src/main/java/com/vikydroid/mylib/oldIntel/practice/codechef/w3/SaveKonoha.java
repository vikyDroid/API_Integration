package com.vikydroid.mylib.oldIntel.practice.codechef.w3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class SaveKonoha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int Z = scanner.nextInt();
            int[] arr = new int[N];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
                pq.add(arr[i]);
            }
            int count = 0;
            while (Z > 0 && (pq.peek() != null && pq.peek() > 0)) {
                int k = pq.poll();
                count++;
                pq.add(k / 2);
                Z -= k;
            }
            if (Z > 0) System.out.println("Evacuate");
            else System.out.println(count);
        }

    }
}
