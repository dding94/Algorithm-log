package 백준.PS9월;

import java.io.*;
import java.util.*;

public class PS0923_11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointList.add(new Point(x, y));
        }

        Collections.sort(pointList, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });

        StringBuilder sb = new StringBuilder();
        pointList.forEach(point -> sb.append(point.x + " " + point.y + "\n"));

        System.out.println(sb);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
