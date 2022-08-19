package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0819_20920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            if (s.length() < m) {
                continue;
            }

            dictionary.put(s, dictionary.getOrDefault(s, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>(dictionary.keySet());

        Collections.sort(list, (o1, o2) -> {
            int c1 = dictionary.get(o1);
            int c2 = dictionary.get(o2);

            if (c1 == c2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return c2 - c1;
        });

        for (String s : list) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
