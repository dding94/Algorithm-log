package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0815_1544 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String>[] arr = new ArrayList[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
            String cur = br.readLine();

            for (int j = 0; j < cur.length(); j++) {
                arr[i].add(cur.substring(j) + cur.substring(0, j));
            }

            boolean chk = true;
            for (int j = 0; chk && j <= i - 1; j++) {
                for (int k = 0; chk && k < arr[j].size(); k++) {
                    if (cur.equals(arr[j].get(k))) {
                        chk = false;
                    }
                }
            }

            if (chk) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
