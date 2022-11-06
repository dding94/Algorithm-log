package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1106_25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        //y, f ,o  2 ,3 , 4 명

        Set<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }

        if (s.equals("Y")) {
            System.out.println(hs.size());
        }

        if (s.equals("F")) {
            System.out.println(hs.size() / 2);
        }

        if (s.equals("O")) {
            System.out.println(hs.size() / 3);
        }
    }

}
