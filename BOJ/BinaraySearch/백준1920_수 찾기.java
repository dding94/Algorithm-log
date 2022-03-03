//수 찾기 - 복습
package 백준;

import java.util.*;
import java.io.*;

class test {
    static int[] a;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        int[] findNum = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            findNum[i] = Integer.parseInt(st.nextToken());
        }

        for (int target : findNum) {
            sb.append(search(0, n - 1, target) + "\n");
        }
        System.out.println(sb);

    }

    static int search(int start, int end, int target) {

        while (start <= end) {
            int mid = (start + end) / 2;
            if(a[mid] > target){
                end = mid - 1;
            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}