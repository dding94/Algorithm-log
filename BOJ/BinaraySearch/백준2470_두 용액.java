package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1019_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int left = 0;
        int right = list.length - 1;
        int diff = Integer.MAX_VALUE;

        int ans1 = 0;
        int ans2 = 0;
        while (left < right) {
            int sum = list[left] + list[right];

            if (Math.abs(sum) < diff) {
                ans1 = list[left];
                ans2 = list[right];
                diff = Math.abs(sum);
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }

}
