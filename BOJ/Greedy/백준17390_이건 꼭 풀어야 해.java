package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0913_17390 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        ArrayList<Integer> sumList = new ArrayList<>();
        sumList.add(0);
        sumList.add(list.get(0));
        for (int i = 1; i < n; i++) {
            sumList.add(list.get(i) + sumList.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(sumList.get(r) - sumList.get(l - 1));
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
