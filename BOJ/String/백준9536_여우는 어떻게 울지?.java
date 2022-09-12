package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0912_9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            while (true) {
                String s = br.readLine();

                if (s.equals("what does the fox say?")) {
                    break;
                }

                String cry = s.split(" ")[2];

                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i).equals(cry)) {
                        list.remove(i);
                    }
                }
            }
        }

        for (String s : list) {
            sb.append(s + " ");
        }

        System.out.println(sb);
    }

}
