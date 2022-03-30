//백준 2493 탑
package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0330_2493 {
    static class Top{
        int height;
        int point;

        public Top(int height, int point){
            this.height = height;
            this.point = point;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Top> topStack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!topStack.isEmpty() && topStack.peek().height <= height) {
                topStack.pop();
            }

            if (topStack.isEmpty()) {
                sb.append(0 + " ");
            }else{
                sb.append(topStack.peek().point + " ");
            }

            topStack.add(new Top(height, i + 1));
        }

        System.out.println(sb);
    }
}
