package 프로그래머스.연습문제;

import java.util.Arrays;
public class ps0315_최솟값만들기 {

    public static void main(String[] args) {

    }

    private static class Solution {

        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++) {
                answer += (A[i] * B[A.length - 1 - i]);
            }

            return answer;
        }
    }

}
