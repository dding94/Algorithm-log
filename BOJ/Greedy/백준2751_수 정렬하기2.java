package 백준.PS2월;

import java.util.*;
import java.io.*;

public class PS0214_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(a);

        for (Integer ans : a) {
            sb.append(ans).append('\n');
        }

        System.out.println(sb);

    }
}
