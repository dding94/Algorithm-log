package 프로그래머스;

public class Kakao_2018_Dart {

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.solution("1D2S#10S");
    }

    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            int[] round = new int[3]; //0, 1, 2
            int idx = -1; //라운드 체크
            char[] charDarts = dartResult.toCharArray();


            for (int i = 0; i < dartResult.length(); i++) {
                if (charDarts[i] >= '0' && charDarts[i] <= '9') {
                    idx++;
                    round[idx] = Integer.parseInt(String.valueOf(charDarts[i]));

                    if (i+1 < dartResult.length() && charDarts[i] == '1' && charDarts[i + 1] == '0') {
                        round[idx] = 10;
                        i++;
                    }
                }else{
                    if (charDarts[i] == 'D') {
                        round[idx] *= round[idx];
                    }
                    if (charDarts[i] == 'T') {
                        round[idx] = (int) Math.pow(round[idx], 3);
                    }
                    if (charDarts[i] == '*') {
                        if (idx > 0) {
                            round[idx - 1] *= 2;
                        }
                        round[idx] *= 2;
                    }
                    if (charDarts[i] == '#') {
                        round[idx] *= -1;
                    }
                }
            }

            answer = round[0] + round[1] + round[2];

            return answer;
        }
    }
}
