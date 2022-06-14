package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0614_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < w; i++) {
            q.add(0);
        }

        int time = 0;
        int weight = 0;
        while (!q.isEmpty()) {
            time++;
            weight -= q.poll();

            if (!truck.isEmpty()) {
                if (truck.peek() + weight <= l) {
                    weight += truck.peek();
                    q.add(truck.poll());
                } else {
                    q.add(0);
                }
            }
        }

        System.out.println(time);

    }
}
