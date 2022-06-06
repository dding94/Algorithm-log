package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0606_7490 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];
            arrayList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list[i] = i + 1;
            }

            dfs(1, n, list, "1");

            Collections.sort(arrayList);
            for (String s : arrayList) {
                sb.append(s + "\n");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int n, int[] list, String s) {
        if (depth == n) {

            if (getSum(s) == 0) {
                arrayList.add(s);
            }

            return;
        }


        dfs(depth + 1,  n, list, s + "+" + list[depth]);
        dfs(depth + 1,  n, list, s + "-" + list[depth]);
        dfs(depth + 1,  n, list, s + " " + list[depth]);
    }



    private static int getSum(String s) {
        String replaceStr = s.replaceAll(" ", "");
        String[] split = replaceStr.split("\\+|\\-");
        Queue<Character> q = new LinkedList<>();


        for (int i = 0; i < replaceStr.length(); i++) {
            if (replaceStr.charAt(i) == '+' || replaceStr.charAt(i) == '-') {
                q.add(replaceStr.charAt(i));
            }
        }

        int sum = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i++) {
            Character op = q.poll();

            if (op == '+') {
                sum += Integer.parseInt(split[i]);
            }else{
                sum -= Integer.parseInt(split[i]);
            }
        }
        return sum;
    }
}
