package 에프랩스터디;

//1차 비밀지도
public class ps1123_비밀지도 {


    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.solution(16, new int[]{65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535},
            new int[]{65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535, 65535});
    }

    // 16 * 16 * log(16)
    private static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            StringBuilder sb;

            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();

                int result = arr1[i] | arr2[i];
                String temp = Long.toBinaryString(result);

                temp = String.format("%0" + n + "d", Long.parseLong(temp));

                //16
                for (int j = 0; j < n; j++) {
                    if (temp.charAt(j) == '1') {
                        sb.append("#");
                    } else {
                        sb.append(" ");
                    }
                }

                answer[i] = sb.toString();
            }

            return answer;
        }
    }
}
