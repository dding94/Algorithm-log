package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1123_25631 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int ans = 0;
        for (int k = 0; k < n; k++) {
            int now = list.get(k);

            if (check[k]) {
                continue;
            }

            check[k] = true;
            for (int i = 1; i < n; i++) {
                if (now < list.get(i)) {
                    if (!check[i]) {
                        now = list.get(i);
                        check[i] = true;
                    }
                }
            }
            ans++;
        }

        System.out.println(ans);
    }

}
