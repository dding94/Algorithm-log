package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0821_19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Type> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            list.add(new Type(name, power));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());

            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (power > list.get(mid).power) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(list.get(left).name + "\n");

        }

        System.out.println(sb);

    }

    static class Type {
        String name;
        int power;

        public Type(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

}
