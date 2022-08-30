package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0830_12018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ArrayList<Integer> subject = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) {
                subject.add(Integer.parseInt(st.nextToken()));
            }

            if (p < l) {
                ansList.add(1);
            } else {
                Collections.sort(subject, (o1, o2) -> o2 - o1);
                ansList.add(subject.get(l - 1));
            }
        }

        Collections.sort(ansList);
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += ansList.get(i);
            if (temp > m) {
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }

}
