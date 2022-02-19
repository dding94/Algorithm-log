package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0219_2805 {

    static int[] tree;
    static int n, m;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); //target

        tree = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int start = 0;
        int end = tree[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            sum = 0;

            for (int i : tree) {
                if (i > mid) {
                    sum += i - mid;
                }
            }

            if (sum >= m) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
