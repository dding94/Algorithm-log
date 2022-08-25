package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0825_1263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] work = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] ts = br.readLine().split(" ");
            work[i][0] = Integer.parseInt(ts[0]);
            work[i][1] = Integer.parseInt(ts[1]);
        }

        Arrays.sort(work, (o1, o2) -> o2[1] - o1[1]);

        int answer = work[0][1] - work[0][0];

        for (int i = 1; i < n; i++) {
            if (work[i][1] < answer) {
                answer = work[i][1];
            }
            answer -= work[i][0];
        }

        System.out.println(answer > 0 ? answer : -1);
    }
}
