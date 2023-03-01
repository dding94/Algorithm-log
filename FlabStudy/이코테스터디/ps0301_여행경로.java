package 에프랩스터디.이코테;

import java.util.ArrayList;
import java.util.List;

public class ps0301_여행경로 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
            }
        );
    }

    private static class Solution {

        static List<String> trips;
        static boolean[] visit;

        public String[] solution(String[][] tickets) {
            String[] answer = {};

            trips = new ArrayList<>();
            visit = new boolean[tickets.length];
            dfs(0, "ICN", "ICN", tickets);

            trips.sort(String::compareTo);

            String[] split = trips.get(0).split(" ");
            return split;
        }


        private static void dfs(int depth, String now, String path, String[][] tickets) {
            if (depth == tickets.length) {
                trips.add(path);
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (!visit[i] && now.equals(tickets[i][0])) {
                    visit[i] = true;
                    dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                    visit[i] = false;
                }
            }
        }
    }
}
