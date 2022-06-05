package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0605_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); //조카 수
        int n = Integer.parseInt(st.nextToken()); //과자 수

        int[] snack = new int[n];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }


        int left = 1;
        int right = max;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (snackCount(mid, snack) < m){
                right = mid - 1;
            }else{
                left = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);

    }

    private static int snackCount(int mid, int[] snack) {
        int count = 0;

        for (int i : snack) {
            count += i / mid;
        }

        return count;
    }
}
