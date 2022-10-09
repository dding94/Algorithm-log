package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1009_1141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (o1, o2) -> o2.length() - o1.length());

        Set<String> hs = new HashSet<>();

        for (String s : list) {
            if (hs.size() == 0) {
                hs.add(s);
                continue;
            }

            boolean check = true;
            for (String h : hs) {
                if (h.indexOf(s) == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                hs.add(s);
            }
        }

        System.out.println(hs.size());
    }

}
