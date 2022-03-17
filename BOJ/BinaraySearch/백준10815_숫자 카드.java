package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0317_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] person = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = person.length - 1;
            boolean check = false;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (card > person[mid]) {
                    start = mid + 1;
                } else if (card < person[mid]) {
                    end = mid - 1;
                }
                if (card == person[mid]) {
                    sb.append(1 + " ");
                    check = true;
                    break;
                }
            }

            if (!check) {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }
}
