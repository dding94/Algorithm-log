package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1117_3077 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), i);
        }

        String[] split = br.readLine().split(" ");

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map.get(split[i]) < map.get(split[j])) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt + "/" + n * (n - 1) / 2);
    }

}
