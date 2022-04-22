package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0422_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensor = new int[n];
        int[] diff = new int[n - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        for (int i = 1; i < n; i++) {
            diff[i - 1] = sensor[i] - sensor[i - 1];
        }

        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < diff.length - k + 1; i++) {
            ans += diff[i];
        }

        System.out.println(ans);

    }
}
