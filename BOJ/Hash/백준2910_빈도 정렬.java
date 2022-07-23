package 백준.PS7월;

import java.io.*;
import java.util.*;

public class PS0718_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> hm = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            hm.put(input, hm.getOrDefault(input, 0) + 1);
        }

        ArrayList<Integer> keyList = new ArrayList<>(hm.keySet());
        Collections.sort(keyList, (o1, o2) -> hm.get(o2) - hm.get(o1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyList.size(); i++) {
            for (int j = 0; j < hm.get(keyList.get(i)); j++) {
                sb.append(keyList.get(i) + " ");
            }
        }
        System.out.println(sb);
    }
}
