package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1126_19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> enter = new HashSet<>();
        Set<String> exit = new HashSet<>();
        Set<String> nameSet = new HashSet<>();

        String str = null;

        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            String time = s[0];
            String name = s[1];

            nameSet.add(name);
            if (S.compareTo(time) >= 0) {
                enter.add(name);
            } else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                exit.add(name);
            }
        }

        int ans = 0;

        for (String s : nameSet) {
            if (enter.contains(s) && exit.contains(s)) {
                ans++;
            }
        }

        System.out.println(ans);

    }
}
