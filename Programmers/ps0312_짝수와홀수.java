package 프로그래머스.연습문제;

public class ps0312_짝수와홀수 {

    public static void main(String[] args) {

    }

    private static class Solution {

        public String solution(int num) {
            if (num % 2 == 0) {
                return "Even";
            } else {
                return "Odd";
            }
        }
    }
}
