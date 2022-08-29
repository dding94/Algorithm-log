package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0829_1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> ts = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ts.remove(Integer.parseInt(st.nextToken()));
        }

        sb.append(ts.size() + "\n");
        for (Integer val : ts) {
            sb.append(val + " ");
        }

        System.out.println(sb);
    }

}
