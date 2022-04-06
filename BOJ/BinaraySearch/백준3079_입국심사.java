package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0406_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] list = new long[n];

        for (int i = 0; i < n; i++) {
            list[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(list);

        long left = 1;
        long right = m * list[list.length - 1];

        while (left <= right) {
            long mid = (left + right) / 2;

            long people = 0;
            for (int i = 0; i < n; i++) {
                people += (mid / list[i]);
            }

            if (people < m) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
