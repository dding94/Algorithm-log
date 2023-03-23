package 백준23.PS3월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PS0323_CostumeParty {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (arr[i] + arr[j] <= s) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }

        System.out.println(count);
    }
}
