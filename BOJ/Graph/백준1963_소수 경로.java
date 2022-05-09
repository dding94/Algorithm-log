import java.io.*;
import java.util.*;

public class Main {

    static boolean[] primeNum = new boolean[10000];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        checkPrimeNum();

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a, b);

            sb.append(ans == Integer.MAX_VALUE ? "Impossible" : ans).append('\n');
        }

        System.out.println(sb);
    }

    private static void bfs(int start, int end){
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[10000];
        q.add(new Node(start, 0));
        visit[start] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.number == end) {
                ans = now.count;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 & j == 0) {
                        continue;
                    }
                    int k = change(now.number, i, j);
                    if (!primeNum[k] && !visit[k]) {
                        q.add(new Node(k, now.count + 1));
                        visit[k] = true;
                    }
                }
            }
        }
    }

    private static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char) (j + '0'));

        return Integer.parseInt(sb.toString());
    }

    private static void checkPrimeNum() {
        primeNum[0] = primeNum[1] = true;

        for (int i = 2; i < 10000; i++) {
            if (!primeNum[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    primeNum[j] = true;
                }
            }
        }
    }

    static class Node{
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
