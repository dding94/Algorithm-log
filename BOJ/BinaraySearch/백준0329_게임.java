package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0329_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = (y * 100) / x;

        if(z >= 99){
            System.out.println(-1);
        }else{
            long left = 0;
            long right = 2000000000;
            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;

                result = 100 * (y + mid) / (x + mid);
                if ( result > z) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }

    }
}
