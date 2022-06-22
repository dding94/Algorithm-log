package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0622_1755 {
    static String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Alpha> list = new ArrayList<>();

        for (int i = n; i <= m; i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                sb.append(arr[s.charAt(j) - '0']);
                if (s.length() > 1) {
                    sb.append(" ");
                }
            }

            list.add(new Alpha(sb.toString(), i));
        }

        Collections.sort(list, (o1, o2) -> o1.alpha.compareTo(o2.alpha));

        for (int i = 0; i < list.size(); i++) {

            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }

            System.out.print(list.get(i).num + " ");
        }

    }

    static class Alpha {
        String alpha;
        int num;

        public Alpha(String alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }
    }
}
