package 백준23.PS1월;

import java.io.*;
import java.util.*;

public class PS0204_저울 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] weight = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int target = 0;
        for (int i = 0; i < n; i++) {
            if (target + 1 < weight[i]) {
                break;
            } else {
                target += weight[i];
            }

        }

        System.out.println(target + 1);
    }

}
