//나무 자르기 - 복습
package 백준;

import java.util.*;
import java.io.*;

class test {
    static int[] tree;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);


        int start = 0;
        int end = tree[n - 1];
        int ans = 0;
        //높이 기준으로 찾기
        while (start <= end) {
            int mid = (start + end) / 2;

            if(sawTree(mid) >= m){
                start = mid + 1;
                ans = mid;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static int sawTree(int mid) {
        int sum = 0;
        for (int x : tree) {
            if (x > mid) {
                sum += (x - mid);
            }

        }
        return sum;
    }
}