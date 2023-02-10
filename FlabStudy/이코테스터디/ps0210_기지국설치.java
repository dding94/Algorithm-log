package 에프랩스터디.이코테;

public class ps0210_기지국설치 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(13, new int[]{3, 7, 11}, 1));
    }

    private static class Solution {

        public int solution(int n, int[] stations, int w) {
            int answer = 0;

            int now = 1;
            int wide = (w * 2) + 1;

            //O(10000)
            for (int i = 0; i < stations.length; i++) {
                int start = stations[i] - w;
                int end = stations[i] + w + 1;

                if (now < start) {
                    int lange = start - now;
                    answer += (lange / wide);

                    if (lange % wide > 0) {
                        answer++;
                    }
                }

                now = end;
            }

            if (now <= n) {
                int lange = n - now + 1;
                answer += (lange / wide);

                if (lange % wide > 0) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
