package 프로그래머스.연습문제;

import java.util.Arrays;

public class ps0329_핸드폰번호가리기 {

    public static void main(String[] args) {

    }

    private static class Solution {

        public String solution(String phone_number) {
            char[] chars = phone_number.toCharArray();

            for (int i = 0; i < chars.length - 4; i++) {
                chars[i] = '*';
            }

            return Arrays.toString(chars);
        }
    }
}
