//나는야 포켓몬 마스터 이다솜
package 백준;

import java.util.*;
import java.io.*;

public class PS2022_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> hs = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            String number = Integer.toString(i + 1);

            hs.put(name, number);
            hs.put(number, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(hs.get(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }
}
