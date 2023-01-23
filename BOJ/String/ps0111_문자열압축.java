package 에프랩스터디;

public class ps0111_문자열압축 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("abcabcabcabcdededededede");

    }

    private static class Solution {

        public int solution(String s) {
            int answer = s.length();
            int length = s.length();

            //압축할 개수
            //O(500)
            for (int i = 1; i <= length / 2; i++) {
                String[] split = s.split("(?<=\\G.{" + i + "})");

                StringBuilder sb = new StringBuilder();
                //해당 부분은 공간복잡도를 낮추려면 StringBuilder 를 사용하는것도 방법일듯₩
                String temp = split[0];
                int count = 1;

                //O(log(1000)) 정도 압축 크기가 클수록 엄청난 수로 줄어들음
                for (int k = 1; k < split.length; k++) {
                    if (temp.equals(split[k])) {
                        count++;
                    } else {
                        if (count != 1) {
                            sb.append(count);
                        }
                        sb.append(temp);
                        temp = split[k];
                        count = 1;
                    }
                }

                if (count != 1) {
                    sb.append(count);
                }
                sb.append(temp);

                System.out.println(sb);
                answer = Math.min(answer, sb.length());
            }

            return answer;
        }
    }
}
