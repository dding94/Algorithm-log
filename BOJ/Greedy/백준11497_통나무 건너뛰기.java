//통나무 건너뛰기
package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0523_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] ans = new int[n];
            int left = 0;
            int right = arr.length - 1;
            boolean check = false;
            for (int i = 0; i < arr.length; i++) {
                if (!check) {
                    ans[left++] = arr[i];
                    check = true;
                } else {
                    ans[right--] = arr[i];
                    check = false;
                }
            }

            int ansLevel = Math.abs(ans[0] - ans[ans.length - 1]);

            for (int i = 1; i < n; i++) {
                int temp = Math.abs(ans[i] - ans[i - 1]);

                if (ansLevel < temp) {
                    ansLevel = temp;
                }
            }


            sb.append(ansLevel + "\n");
        }

        System.out.println(sb);
    }
}
