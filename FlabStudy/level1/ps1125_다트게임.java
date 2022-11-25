package 에프랩스터디;

public class ps1125_다트게임 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("10S*10T*10S"));
    }


    private static class Solution {

        public int solution(String dartResult) {
            int answer = 0;
            int game = 3;
            int[] dart = new int[game];

            int point = 0;

            for (int i = 0; i < dartResult.length(); i++) {

                if (Character.isDigit(dartResult.charAt(i))) {
                    if (i + 1 < dartResult.length() && Character.isDigit(dartResult.charAt(i + 1))) {
                        dart[point] = 10;
                        point++;
                        i++;
                        continue;
                    }
                    dart[point] = dartResult.charAt(i) - '0';
                    point++;
                }

                if (dartResult.charAt(i) == 'D') {
                    dart[point - 1] = (int) Math.pow(dart[point - 1], 2);
                }

                if (dartResult.charAt(i) == 'T') {
                    dart[point - 1] = (int) Math.pow(dart[point - 1], 3);
                }

                if (dartResult.charAt(i) == '*') {
                    dart[point - 1] *= 2;
                    if (point - 2 >= 0) {
                        dart[point - 2] *= 2;
                    }
                }

                if (dartResult.charAt(i) == '#') {
                    dart[point - 1] *= -1;
                }
            }

            for (int i = 0; i < game; i++) {
                answer += dart[i];
            }

            return answer;
        }
    }
}
