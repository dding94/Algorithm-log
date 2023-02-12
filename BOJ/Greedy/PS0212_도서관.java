package 백준23.PS2월;

import java.io.*;
import java.util.*;

public class PS0212_도서관 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> plusBook = new ArrayList<>();
        ArrayList<Integer> minusBook = new ArrayList<>();

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            max = Math.max(max, Math.abs(input));

            if (input > 0) {
                plusBook.add(input);
            } else {
                minusBook.add(Math.abs(input));
            }
        }

        plusBook.sort(Collections.reverseOrder());
        minusBook.sort(Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < plusBook.size(); i++) {
            if (i % m == 0) {
                ans += (plusBook.get(i) * 2);
            }
        }

        for (int i = 0; i < minusBook.size(); i++) {
            if (i % m == 0) {
                ans += Math.abs(minusBook.get(i) * 2);
            }
        }

        System.out.println(ans - max);
    }
}
