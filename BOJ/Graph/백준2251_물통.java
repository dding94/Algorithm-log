package 백준.PS5월;

import java.io.*;
import java.util.*;

public class PS0512_2251 {
    static final int maxLiter = 201;
    static boolean[][][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        check = new boolean[maxLiter][maxLiter][maxLiter];
        ArrayList<Integer> ans = bfs(a, b, c);

        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }

    static private ArrayList<Integer> bfs(int bucketA, int bucketB, int bucketC) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, bucketC));
        ArrayList<Integer> answerList = new ArrayList<>();

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (check[now.a][now.b][now.c]) {
                continue;
            }

            if (now.a == 0) {
                answerList.add(now.c);
            }

            check[now.a][now.b][now.c] = true;

            //a->b
            if (now.a + now.b <= bucketB) {
                q.add(new Node(0, now.a + now.b, now.c));
            }else {
                q.add(new Node(now.a - (bucketB - now.b), bucketB, now.c));
            }
            //b->a
            if (now.b + now.a <= bucketA) {
                q.add(new Node(now.b + now.a, 0, now.c));
            }else {
                q.add(new Node(bucketA, now.b - (bucketA - now.a), now.c));
            }
            //a->c
            if (now.a + now.c <= bucketC) {
                q.add(new Node(0, now.b, now.a + now.c));
            }else {
                q.add(new Node(now.a - (bucketC - now.c), now.b, bucketC));
            }
            //c->a
            if (now.c + now.a <= bucketA) {
                q.add(new Node(now.a + now.c,  now.b, 0));
            }else {
                q.add(new Node(bucketA, now.b, now.c - (bucketA - now.a)));
            }
            //b->c
            if (now.b + now.c <= bucketC) {
                q.add(new Node(now.a, 0, now.b + now.c));
            }else {
                q.add(new Node(now.a, now.b - (bucketC - now.c), bucketC));
            }
            //c->b
            if (now.c + now.b <= bucketB) {
                q.add(new Node(now.a, now.b + now.c, 0));
            }else {
                q.add(new Node(now.a, bucketB, now.c - (bucketB - now.b)));
            }

        }

        Collections.sort(answerList, (o1, o2) -> o1 - o2);
        return answerList;
    }

    static private class Node{
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
