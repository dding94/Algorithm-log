package 백준.PS2월;

import java.util.*;
import java.io.*;

public class PS0214_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] loc = new int[n];
        int[] rankLoc = new int[n];

        HashMap<Integer, Integer> hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
            rankLoc[i] = loc[i];
        }

        Arrays.sort(rankLoc);

        int rank = 0;
        for (int i : rankLoc) {
            if (!hm.containsKey(i)) {
                hm.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : loc) {
            sb.append(hm.get(i) + " ");
        }

        System.out.println(sb);

    }
}
