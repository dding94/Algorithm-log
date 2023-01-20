package 에프랩스터디;

import java.util.*;

public class ps0118_순위검색 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            new String[]{
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
            },
            new String[]{
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"}
        );


    }

    private static class Solution {

        static Map<String, List<Integer>> hm = new HashMap<>();

        public int[] solution(String[] info, String[] query) {

            int[] answer = new int[query.length];

            //각 info 가 만들 수 있는 쿼리 전부 생성
            for (int i = 0; i < info.length; i++) {
                dfs("", 0, info[i].split(" "));
            }

            //저장 된 점수 오름차순 정렬
            for (List<Integer> list : hm.values()) {
                Collections.sort(list);
            }

            int i = 0;
            //이분탐색으로 점수를 찾지 않으면 시간초과가 난다.
            for (String q : query) {
                String[] peopleInfo = q.split(" and ");
                String[] foodAndScore = peopleInfo[3].split(" ");

                String people = peopleInfo[0] + peopleInfo[1] + peopleInfo[2] + foodAndScore[0];

                if (hm.containsKey(people)) {
                    List<Integer> list = hm.get(people);

                    int left = 0;
                    int right = list.size() - 1;

                    while (left <= right) {
                        int mid = (left + right) / 2;

                        if (list.get(mid) < Integer.parseInt(foodAndScore[1])) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    answer[i] = list.size() - left;
                }
                i++;
            }

            return answer;
        }

        private static void dfs(String key, int depth, String[] info) {
            if (depth == 4) {
                List<Integer> list = hm.getOrDefault(key, new ArrayList<>());
                list.add(Integer.valueOf(info[4]));
                hm.put(key, list);
                return;
            }

            dfs(key + "-", depth + 1, info);
            dfs(key + info[depth], depth + 1, info);
        }
    }
}
