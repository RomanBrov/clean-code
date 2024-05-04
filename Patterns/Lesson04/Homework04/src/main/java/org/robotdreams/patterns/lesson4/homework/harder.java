package org.robotdreams.patterns.lesson4.homework;

// task: https://codeforces.com/contest/1676/problem/F
// source code: https://codeforces.com/contest/1676/submission/223702663

import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class harder {

    // static Scanner sc = new Scanner(System.in);
    static Set<Integer> set = new HashSet<>();
    static FastReader sc = new FastReader();

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("harder.input.txt");
            br = new BufferedReader(new
                    InputStreamReader(resourceAsStream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0)
            return b;

        // a is greater

        return gcd(b % a, a);
    }

    public static void solve() {

        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int i = 0, ans = 0, start = 0;
        while (i < n) {
            int s = arr[i];
            int ele = s;
            while (i < n) {
                int t = ele;
                int c = 0;
                for (; i < n; i++) {
                    if (ele == arr[i])
                        c++;
                    else
                        break;
                }
                if (c >= k) {
                    ele++;
                } else {

                    break;
                }
            }
            if (ans < ele - s) {
                ans = ele - s;
                start = s;
            }
        }
        if (ans == 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(start + " " + (start + ans - 1));
    }

    public static void execute() {
        int t = sc.nextInt();
        // call();
        // System.out.println((3 | 5 | 6 | 2) ^ 15);
        while (t > 0) {
            t--;
            solve();
        }
        // sc.close();

    }
}
