package 프로그래머스.연습문제;

import java.io.BufferedReader;

public class ps0327_서울에서김서방찾기 {

    public static void main(String[] args) {

    }

    private static class Solution {

        public String solution(String[] seoul) {
            String answer = "";

            for (int i = 0; i < seoul.length; i++) {
                if (seoul[i].equals("Kim")) {
                    answer = "김서방은 " + i + "에 있다";
                }
            }

            return answer;
        }
    }
}
