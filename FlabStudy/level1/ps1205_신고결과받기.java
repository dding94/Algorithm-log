package 에프랩스터디;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ps1205_신고결과받기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(
            new String[]{"muzi", "frodo", "apeach", "neo"},
            new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
            2
        );


    }

    private static class Solution {

        public int[] solution(String[] id_list, String[] report, int k) {

            Map<String, Integer> emailMap = new HashMap<>();
            Map<String, Set<String>> reportMap = new HashMap<>();
            int[] answer = new int[id_list.length];

            //초기화
            for (String id : id_list) {
                emailMap.put(id, 0);
                reportMap.put(id, new HashSet<>());
            }

            for (String rep : report) {
                StringTokenizer st = new StringTokenizer(rep);
                String[] split = rep.split(",");

                String id = split[0].split(" ")[0];
                String reportId = split[0].split(" ")[1];

                reportMap.get(reportId).add(id);
            }

            for (String mapKey : reportMap.keySet()) {
                Set<String> reportSet = reportMap.get(mapKey);

                if (reportSet.size() >= k) {
                    for (String setKey : reportSet) {
                        emailMap.put(setKey, emailMap.get(setKey) + 1);
                    }
                }
            }

            for (int i = 0; i < id_list.length; i++) {
                answer[i] = emailMap.get(id_list[i]);
            }

            return answer;
        }
    }
}
