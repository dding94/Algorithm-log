package 백준;

import java.io.*;
import java.util.*;

public class PS0208_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> hm = new HashMap<>();
        int maxValue = 1;

        for (int i = 0; i < n; i++) {
            Long key = Long.parseLong(br.readLine());
            if (!hm.containsKey(key)) {
                hm.put(key, 1);
            }else{
                hm.put(key, hm.get(key) + 1);
                if (maxValue < hm.get(key)) {
                    maxValue = hm.get(key);
                }
            }
        }

        long ans = 0;
        ArrayList<Long> list = new ArrayList<>();
        for (Map.Entry<Long, Integer> m : hm.entrySet()) {
            if (maxValue == m.getValue()) {
                list.add(m.getKey());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
