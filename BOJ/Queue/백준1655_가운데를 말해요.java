//가운데를 말해요
package 백준.PS2월;

import java.io.*;
import java.util.*;

public class PS0215_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minQ.size() == maxQ.size()){
                maxQ.add(num);
            }else{
                minQ.add(num);
            }

            if (!minQ.isEmpty() && !maxQ.isEmpty()) {
                if (minQ.peek() < maxQ.peek()) {
                    int temp = minQ.poll();
                    minQ.add(maxQ.poll());
                    maxQ.add(temp);
                }
            }
            sb.append(maxQ.peek() + "\n");
        }
        System.out.println(sb);
    }
}
