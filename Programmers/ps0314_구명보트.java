package 프로그래머스.연습문제;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ps0314_구명보트 {

    public static void main(String[] args) {

    }

    private static class Solution {

        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int index = 0;

            for (int i = people.length - 1; i >= index; i--) {
                if (people[i] + people[index] <= limit) {
                    index++;
                }
                answer++;
            }

            return answer;
        }
    }
}
