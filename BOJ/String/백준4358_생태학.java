package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0407_4358 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> hm = new HashMap<>();
        hm = new HashMap<String, Integer>();
        int allCount = 0;

        while (true) {
            String str = br.readLine();

            if (str == null || str.length() == 0) {
                break;
            }

            hm.put(str, hm.getOrDefault(str, 0) + 1);
            allCount++;
        }

        Object[] treeList = hm.keySet().toArray();
        Arrays.sort(treeList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treeList.length; i++) {
            Integer count = hm.get(treeList[i]);
            sb.append(treeList[i] + " " + String.format("%.4f", (count * 100) * 1.0 / allCount) + "\n");
        }

        System.out.println(sb);
    }
}
