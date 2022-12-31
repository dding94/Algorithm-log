package 백준.PS12월;

import java.io.*;
import java.util.*;

public class PS1231_좋다 {

    static int ans = 0;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            twoPoint(i);
        }

        System.out.println(ans);
    }

    private static void twoPoint(int i) {
        int left = 0;
        int right = num.length - 1;
        int target = num[i];

        while (left < right) {
            if (left == i) {
                left++;
            } else if (right == i) {
                right--;
            }else {
                if (target > num[left] + num[right]) {
                    left++;
                } else if (target == num[left] + num[right]) {
                    ans++;
                    break;
                } else {
                    right--;
                }
            }
        }
    }
}
