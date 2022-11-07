package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1107_12845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, (o1, o2) -> o2 - o1);

        int maxLevel = list.get(0);
        int sum = 0;

        if (n == 1) {
            System.out.println(maxLevel);
            return;
        }

        for (int i = 1; i < n; i++) {
            sum += maxLevel + list.get(i);
        }

        System.out.println(sum);
    }

}
