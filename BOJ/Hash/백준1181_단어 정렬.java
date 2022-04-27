package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0427_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        while (n-- > 0) {
            hs.add(br.readLine());
        }


        ArrayList<String> list = new ArrayList<>(hs);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
