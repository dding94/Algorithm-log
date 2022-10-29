package 백준.PS10월;

import java.io.*;

public class PS1029_10820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;

        Character[][] map = new Character[5][15];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] == null) {
                    continue;
                }
                sb.append(map[j][i]);
            }
        }

        System.out.println(sb);
    }

}
