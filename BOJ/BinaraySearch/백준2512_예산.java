package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0223_2512 {
    static int[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        city = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(city);

        long start = 0;
        long end = city[n - 1] + 1;

        long answer = 0;

        while (start < end) {
            long mid = (start + end) / 2;

            if(money(mid) > m){
                end = mid;
            }else{
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }

    private static long money(long mid) {
        long sum = 0;

        for (int i : city) {
            if (i >= mid) {
                sum += mid;
            }else{
                sum += i;
            }
        }
        return sum;
    }
}
