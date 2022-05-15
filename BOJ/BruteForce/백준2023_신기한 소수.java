package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0515_2023 {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            dfs(0, i, n);
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static void dfs(int depth, int num, int n) {
        //소수가 아니면
        if (!checkPrime(num)) {
            return;
        }

        if (depth == n - 1) {
            list.add(num);
            return;
        }


        for (int i = 0; i < 10; i++) {
            dfs(depth + 1, num * 10 + i, n);
        }

    }

    private static boolean checkPrime(int n) {
        if(n < 2){
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
