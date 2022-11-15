package 백준.PS11월;

import java.io.*;
import java.util.*;

public class PS1115_25707 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, (o1, o2) -> o2 - o1);

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += (list.get(i) - list.get(i + 1));
        }

        sum += (list.get(0) - list.get(list.size() - 1));

        System.out.println(sum);
    }

}
