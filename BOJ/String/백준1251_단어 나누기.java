package 백준.PS7월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PS0729_1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        String[] st = new String[3];

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                st[0] = s.substring(0, i);
                st[1] = s.substring(i, j);
                st[2] = s.substring(j, s.length());

                StringBuilder sb = new StringBuilder();

                for (int k = 0; k < 3; k++) {
                    for (int l = st[k].length() - 1; l >= 0; --l) {
                        sb.append(st[k].charAt(l));
                    }
                }

                list.add(sb.toString());
                sb.setLength(0);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
