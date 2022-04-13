package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0413_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            PriorityQueue<Integer> maxQ = new PriorityQueue<>();
            PriorityQueue<Integer> minQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                }

                if (cmd.equals("D")) {
                    if (!map.isEmpty()) {
                        if (value == 1) {
                            int maxKey = map.lastKey();
                            if (map.get(maxKey) == 1) {
                                map.remove(maxKey);
                            }else{
                                map.put(maxKey, map.get(maxKey) - 1);
                            }
                        }
                        if (value == -1) {
                            int minKey = map.firstKey();
                            if (map.get(minKey) == 1) {
                                map.remove(minKey);
                            }else{
                                map.put(minKey, map.get(minKey) - 1);
                            }
                        }
                    }
                }

            }
            if (map.isEmpty()) {
                sb.append("EMPTY" + "\n");
            }else{
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb);

    }
}
