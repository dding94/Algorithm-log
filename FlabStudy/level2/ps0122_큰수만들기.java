package 프로그래머스.고득점킷;

public class ps0122_큰수만들기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("4177252841", 4);
    }

    private static class Solution {

        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int now = 0;
            int len = number.length() - k;
            int index = 0;

            for (int i = 0; i < len; i++) {
                int max = 0;
                for (int j = now; j <= i + k; j++) {
                    int temp = number.charAt(j) - '0';
                    System.out.println(temp);
                    if (max < temp) {
                        index = j;
                        max = temp;
                    }
                }
                answer.append(max);
                now = index + 1;
            }

            return answer.toString();
        }
    }
}
