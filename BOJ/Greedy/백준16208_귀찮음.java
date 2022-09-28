package 백준.PS9월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0928_16208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        long total = 0;
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }

        for (int i = 0; i < n; i++) {
            long temp = arr[i];
            total -= temp;
            ans += temp * total;
        }

        System.out.println(ans);
    }

}
