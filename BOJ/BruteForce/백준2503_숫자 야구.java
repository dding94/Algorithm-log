//숫자야구
package 백준.PS4월;

import java.io.*;
import java.util.*;

public class PS0415_2503 {
    static class Question{
        String Quest;
        int strike;
        int ball;

        public Question(String quest, int strike, int ball) {
            Quest = quest;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static boolean[] check;
    static int[] num;
    static ArrayList<Question> list = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        num = new int[10];
        check = new boolean[10];

        for (int i = 0; i < 10; i++) {
            num[i] = i;
        }

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String Quest = st.nextToken();
            int Strike = Integer.parseInt(st.nextToken());
            int Ball = Integer.parseInt(st.nextToken());

            list.add(new Question(Quest, Strike, Ball));
        }

        dfs(0, "");

        System.out.println(count);

    }

    static void dfs(int depth, String num) {
        if (depth == 3) {
            compareQuest(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(depth + 1, num + i);
                check[i] = false;
            }
        }
    }

    static void compareQuest(String num) {
        for (Question question : list) {
            int strikeCnt = countStrike(question.Quest, num);
            int ballCnt = countBall(question.Quest, num);

            if (strikeCnt != question.strike || ballCnt != question.ball) {
                return;
            }
        }

        count++;
    }

    static int countStrike(String Quest, String num){
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == Quest.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    static int countBall(String Quest, String num) {
        int count = 0;

        for (int i = 0; i < num.length(); i++) {
            for (int j = 0; j < Quest.length(); j++) {
                if(i==j) {
                    continue;
                }

                if (num.charAt(i) == Quest.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
