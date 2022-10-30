package 백준.PS10월;

import java.io.*;
import java.util.*;

public class PS1030_12605 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");

            for (int j = 0; j < split.length; j++) {
                stack.add(split[j]);
            }

            sb.append("Case #" + (i + 1) + ": ");
            for (int j = 0; j < split.length; j++) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
