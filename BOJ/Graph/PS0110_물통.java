package 백준23.PS1월;

import java.io.*;
import java.util.*;

public class PS0110_물통 {

    static final int maxL = 201;
    static boolean[][][] check;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        check = new boolean[maxL][maxL][maxL];

        bfs(a, b, c);

        answer.sort((o1, o2) -> o1 - o2);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }

    }

    private static void bfs(int a, int b, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, c));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (check[now.a][now.b][now.c]) {
                continue;
            }

            if (now.a == 0) {
                answer.add(now.c);
            }

            check[now.a][now.b][now.c] = true;

            //a->b
            if (now.a + now.b <= b) {
                q.add(new Node(0, now.a + now.b, now.c));
            } else {
                q.add(new Node(now.a - (b - now.b), b, now.c));
            }
            //b->a
            if (now.b + now.a <= a) {
                q.add(new Node(now.b + now.a, 0, now.c));
            } else {
                q.add(new Node(a, now.b - (a - now.a), now.c));
            }
            //a->c
            if (now.a + now.c <= c) {
                q.add(new Node(0, now.b, now.a + now.c));
            } else {
                q.add(new Node(now.a - (c - now.c), now.b, c));
            }
            //c->a
            if (now.c + now.a <= a) {
                q.add(new Node(now.a + now.c, now.b, 0));
            } else {
                q.add(new Node(a, now.b, now.c - (a - now.a)));
            }
            //b->c
            if (now.b + now.c <= c) {
                q.add(new Node(now.a, 0, now.b + now.c));
            } else {
                q.add(new Node(now.a, now.b - (c - now.c), c));
            }
            //c->b
            if (now.c + now.b <= b) {
                q.add(new Node(now.a, now.b + now.c, 0));
            } else {
                q.add(new Node(now.a, b, now.c - (b - now.b)));
            }

        }

    }


    private static class Node {

        int a;
        int b;
        int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
