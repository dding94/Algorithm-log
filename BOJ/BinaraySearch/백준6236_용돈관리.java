package 백준.PS4월;

import java.util.*;
import java.io.*;

public class PS0402_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a[] = new int[n];
        int left = 0;
        int right = 0;

        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            left = a[i] > left ? a[i] : left;
            right += a[i];
        }

        while(left <= right) {
            int mid = (left + right)/2;
            int sum = 0;
            int cnt = 0;
            for(int i=0; i<n; i++) {
                if(sum + a[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += a[i];
            }
            if(sum != 0) cnt++;
            if(cnt <= m) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left);
    }
}


