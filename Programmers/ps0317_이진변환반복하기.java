package 프로그래머스.연습문제;

public class ps0317_이진변환반복하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("110010101001");
    }

    private static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            while (s.length() > 1) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {

                    if (s.charAt(i) == '0') {
                        answer[1]++;
                    } else {
                        count++;
                    }
                }

                s = Integer.toBinaryString(count);
                answer[0]++;
            }

            return answer;
        }
    }

}
