package org.robotdreams.patterns.lesson4.homework;

// task: https://codeforces.com/contest/1707/problem/A
// source code: https://codeforces.com/contest/1707/submission/164561042

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ResourceBundle;
import java.util.Scanner;

public class simpler {
    public void execute() throws FileNotFoundException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("simpler.input.txt");
        Scanner scanner = new Scanner(resourceAsStream);
        for (int numCases = scanner.nextInt(); numCases > 0; --numCases) {
            int n = scanner.nextInt(), q = scanner.nextInt();
            int[] arr = new int[n];
            int[] bool = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = n - 1, t = 0; i >= 0; --i) {
                if (t < q && arr[i] > t) {
                    t++;
                    bool[i] = 1;
                } else if (arr[i] <= t)
                    bool[i] = 1;
            }
            for (int i : bool) {
                System.out.print(i);
            }
            System.out.println();
        }
        scanner.close();
    }
}
