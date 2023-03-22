package 백준23.PS3월;

import java.io.*;
import java.util.StringTokenizer;

public class PS0322_수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int maxSum = 0;
        int temp = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            temp += arr[i];
        }

        maxSum = temp;
        int left = 0;
        int right = k;

        while (right < n) {
            temp -= arr[left++];
            temp += arr[right++];
            maxSum = Math.max(maxSum, temp);
        }

        System.out.println(maxSum);
    }

}
