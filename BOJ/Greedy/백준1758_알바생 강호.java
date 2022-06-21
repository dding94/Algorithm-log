//알바생 강호
package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0621_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> tip = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tip.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(tip, Collections.reverseOrder());

        long ans = 0;

        for (int i = 0; i < n; i++) {

            if (tip.get(i) - i > 0) {
                ans += tip.get(i) - i;
            }
        }

        System.out.println(ans);
    }
}
