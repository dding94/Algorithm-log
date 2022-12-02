package 에프랩스터디;

public class ps1202_숫자문자열과영단어 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution("fourfourfourfourfourfour");

        System.out.println(result);
    }

    private static class Solution {

        public int solution(String s) {
            String[] words = new String[]{
                "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"
            };

            int answer = 0;
            // n = words 길이, m = 50 (문자열 길이)
            // O(nm)
            // O(9) * O(50) = O(450)
            for (int i = 0; i <= 9; i++) {
                s = s.replaceAll(words[i], String.valueOf(i));
            }

            String a = "aa";

            System.out.println(System.identityHashCode(a));

            String b = "aa";

            System.out.println(System.identityHashCode(b));

            Integer bb = 10;
            System.out.println(System.identityHashCode(bb));

            bb = 100000000;
            System.out.println(System.identityHashCode(bb));

            answer = Integer.parseInt(s);

            return answer;
        }
    }
}
