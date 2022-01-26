import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
	StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

 
        Arrays.sort(times, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1]; 
            else return o1[0] - o2[0];
        });


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int start = times[i][0];
            int end = times[i][1];
            if (!queue.isEmpty() && queue.peek() <= start) { 
                queue.poll();
            }
            queue.offer(end);
        }
        System.out.println(queue.size());
    }
}