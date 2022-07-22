package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0722_16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, ArrayList<String>> hm = new HashMap<>();

        while (n-- > 0) {
            String team = br.readLine();
            ArrayList<String> list = new ArrayList<>();
            int cnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < cnt; i++) {
                list.add(br.readLine());
            }
            Collections.sort(list);

            hm.put(team, list);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            int quiz = Integer.parseInt(br.readLine());

            if (quiz == 0) {
                ArrayList<String> list = hm.get(input);
                for (String s : list) {
                    sb.append(s + "\n");
                }
                continue;
            }

            if (quiz == 1) {
                for (String s : hm.keySet()) {
                    if (hm.get(s).contains(input)) {
                        sb.append(s + "\n");
                        break;
                    }
                }
                continue;
            }

        }

        System.out.println(sb);
    }
}
