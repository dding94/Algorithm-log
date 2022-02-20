package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0220_10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] user = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            user[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(user);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(user, num) - lowerBound(user, num)).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBound(int[] user, int num) {
        int low = 0;
        int high = user.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (num <= user[mid]) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    static int upperBound(int[] user, int num) {
        int low = 0;
        int high = user.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (num < user[mid]) {
                high = mid;
            }else{
                low = mid + 1;
            }

        }
        return low;
    }
}
