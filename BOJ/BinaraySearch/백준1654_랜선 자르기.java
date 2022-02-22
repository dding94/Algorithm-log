//랜선 자르기
package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0222_1654 {
    static int[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        lan = new int[k];

        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        //최소 길이
        int start = 1;
        //최대 길이
        int end = lan[k - 1];

        while (start < end) {
            int mid = (start + end) / 2;

            if (lanCount(mid) < n) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(end - 1);
    }

    private static int lanCount(int mid) {
        int count = 0;

        for (int i : lan) {
            count += (i / mid);
        }

        return count;
    }
}
