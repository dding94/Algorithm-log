package 프로그래머스.연습문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ps0325_자연수뒤집어배열로만들기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(1000000000);
    }

    private static class Solution {

        public List<Integer> solution(long n) {

            String s = String.valueOf(n);
            List<Integer> list = new ArrayList<>();

            for (int i = s.length() - 1; i >= 0; i--) {
                list.add(s.charAt(i) - '0');
            }


            return list;
        }
    }
}
