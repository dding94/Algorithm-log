//뮤탈리스크
package 백준.PS8월;

import java.io.*;
import java.util.*;

public class PS0811_12869 {

    static int n;
    static boolean visit[][][];
    static ArrayList<Integer> scvList = new ArrayList<>();
    static PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static int ansCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scvList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = n; i < 3; i++) {
            scvList.add(0);
        }

        visit = new boolean[61][61][61];

        solve(scvList.get(0), scvList.get(1), scvList.get(2), 0);

        System.out.println(ansCount);
    }

    private static void solve(int hp1, int hp2, int hp3, int count) {
        hp1 = Math.max(0, hp1);
        hp2 = Math.max(0, hp2);
        hp3 = Math.max(0, hp3);

        q.add(hp1);
        q.add(hp2);
        q.add(hp3);

        hp1 = q.poll();
        hp2 = q.poll();
        hp3 = q.poll();

        if (hp1 <= 0 && hp2 <= 0 && hp3 <= 0) {
            ansCount = Math.min(count, ansCount);
            return;
        }

        if (ansCount < count) {
            return;
        }

        if (!visit[hp1][hp2][hp3]) {
            visit[hp1][hp2][hp3] = true;
            //9 3 1, 9 1 3, 1 3 9, 1 9 3, 3 1 9 , 3 9 1
            solve(hp1 - 9, hp2 - 3, hp3 - 1, count + 1);
            solve(hp1 - 9, hp2 - 1, hp3 - 3, count + 1);
            solve(hp1 - 3, hp2 - 1, hp3 - 9, count + 1);
            solve(hp1 - 3, hp2 - 9, hp3 - 1, count + 1);
            solve(hp1 - 1, hp2 - 3, hp3 - 9, count + 1);
            solve(hp1 - 1, hp2 - 9, hp3 - 3, count + 1);
        }
    }
}
