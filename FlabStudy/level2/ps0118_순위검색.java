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
        static String[] language = new String[]{"cpp", "java", "python", "-"};
        static String[] job = new String[]{"backend", "frontend", "-"};
        static String[] year = new String[]{"junior", "senior", "-"};
        static String[] food = new String[]{"chicken", "pizza", "-"};

        public int[] solution(String[] info, String[] query) {
            int[] answer = {};
            List<Integer> answerList = new ArrayList<>();
            makeMap();

            for (String s : info) {
                String[] split = s.split(" ");
                String people = split[0] + split[1] + split[2] + split[3];

                for (String key : hm.keySet()) {
                    String[] splitKeys = key.split("-");
                    int temp = splitKeys.length;
                    int count = 0;
                    for (String splitKey : splitKeys) {
                        if (people.contains(splitKey)) {
                            count++;
                        }
                    }

                    if (temp == count) {
                        hm.get(key).add(Integer.parseInt(split[4]));
                    }

                 }

            }


            for (String q : query) {
                String[] peopleInfo = q.split(" and ");
                String[] foodAndScore = peopleInfo[3].split(" ");

                String people = peopleInfo[0] + peopleInfo[1] + peopleInfo[2] + foodAndScore[0];
                List<Integer> list = hm.get(people);
                int count = 0;
                for (Integer i : list) {
                    if (i >= Integer.parseInt(foodAndScore[1])) {
                        count++;
                    }
                }
                answerList.add(count);
            }

            answer = new int[answerList.size()];

            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        static void makeMap() {
            for (String lan : language) {
                for (String job : job) {
                    for (String year : year) {
                        for (String food : food) {
                            String make = lan + job + year + food;
                            hm.put(make, new ArrayList<>());
                        }
                    }
                }
            }
        }
    }
}
