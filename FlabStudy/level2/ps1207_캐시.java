package 에프랩스터디;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ps1207_캐시 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int result = sol.solution(
            0,
            new String[]{"a", "a", "a", "a", "a", "a"}
        );

        System.out.println(result);
    }


    private static class Solution {

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            Deque<String> cache = new LinkedList<>();

            //검색할 도시 순회
            //O(100000)
            for (String city : cities) {

                //O(20)
                String temp = city.toLowerCase();

                if (cacheSize == 0) {
                    answer += 5;
                    continue;
                }

                //캐시 확인
                //O(30)
                if (cache.remove(temp)) {
                    cache.addFirst(temp);
                    answer += 1;
                    continue;
                }

                //캐시사이즈 보다 크면
                if (cache.size() >= cacheSize) {
                    cache.pollLast();
                }

                cache.addFirst(temp);
                answer += 5;
            }

            return answer;
        }
    }
}
