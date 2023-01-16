package 에프랩스터디;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ps0116_단어변환 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            "hit",
            "cog",
            new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        );
    }

    private static class Solution {

        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            boolean flag = false;

            for (String word : words) {
                if (word.equals(target)) {
                    flag = true;
                }
            }

            if (!flag) {
                return 0;
            }

            answer = bfs(begin, target, words);

            return answer;
        }


        private static int bfs(String begin, String target, String[] words) {
            Queue<Node> q = new LinkedList<>();
            Set<String> check = new HashSet<>();
            check.add(begin);
            q.add(new Node(begin, 0));

            while (!q.isEmpty()) {
                Node now = q.poll();

                if (now.temp.equals(target)) {
                    return now.dist;
                }

                //O(24)
                for (int k = 'a'; k <= 'z'; k++) {
                    //O(10)
                    for (int i = 0; i < now.temp.length(); i++) {
                        StringBuilder temp = new StringBuilder(now.temp);
                        //O(50)
                        temp.setCharAt(i, (char) k);

                        for (String word : words) {
                              if (temp.toString().equals(word)) {
                                if (check.add(temp.toString())) {
                                    q.add(new Node(temp.toString(), now.dist + 1));
                                }
                            }
                        }
                    }
                }
            }

            return 0;
        }

        private static class Node {
            String temp;
            int dist;

            public Node(String temp, int dist) {
                this.temp = temp;
                this.dist = dist;
            }
        }
    }
}
