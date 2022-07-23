package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0628_13904 {

    static class assignment {
        int deadLine;
        int score;

        public assignment(int deadLine, int score) {
            this.deadLine = deadLine;
            this.score = score;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<assignment> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new assignment(deadLine, score));
        }

        //마감일수 내림차순
        Collections.sort(list, (o1, o2) -> o2.deadLine - o1.deadLine);

        int nowDay = list.get(0).deadLine;
        int sum = 0;

        for (int i = nowDay; i > 0; i--) {
            sum += getMaxScore(list, i);
        }

        System.out.println(sum);

    }

    private static int getMaxScore(ArrayList<assignment> list, int nowDay) {
        int nowPoint = -1;
        int maxScore = 0;

        for (int i = 0; i < list.size(); i++) {
            if (nowDay <= list.get(i).deadLine && maxScore < list.get(i).score) {
                maxScore = list.get(i).score;
                nowPoint = i;
            }
        }

        if (maxScore == 0) {
            return 0;
        }

        list.remove(nowPoint);
        return maxScore;
    }

}
