package 프로그래머스.연습문제;

public class ps0319_JadenCase문자열 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("3people  unFollowed me");

    }

    private static class Solution {

        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            String[] split = s.split(" ");

            for (String word : split) {
                word = word.toLowerCase();

                if (word.equals("")) {
                    sb.append(" ");
                    continue;
                }
                sb.append(Character.toUpperCase(word.charAt(0)));

                for (int i = 1; i < word.length(); i++) {
                    sb.append(word.charAt(i));
                }

                sb.append(" ");
            }

            if (s.charAt(s.length() - 1) == ' ') {
                return sb.toString();
            } else {
                return sb.substring(0, sb.length() - 1);
            }
        }
    }

}
