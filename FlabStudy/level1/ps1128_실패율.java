package 에프랩스터디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ps1128_실패율 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});

        for (int i : result) {
            System.out.print(i + " ");
        }

    }


    private static class Solution {

        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];

            //각 스테이지 별 유저
            int[] stageUser = new int[N + 2];
            List<Stage> list = new ArrayList<>();

            for (int stage : stages) {
                stageUser[stage]++;
            }

            //20만이라 int
            int totalUser = stages.length;

            for (int i = 1; i <= N; i++) {
                int failUser = stageUser[i];
                double failRate = 0.0;

                if (totalUser == 0) {
                    failRate = 0.0;
                } else {
                    failRate = (double) failUser / (double) totalUser;
                }
                totalUser -= failUser;

                list.add(new Stage(failRate, i));

            }

            Collections.sort(list, (o1, o2) -> {
                if (Double.compare(o1.failRate, o2.failRate) == 0) {
                    return o1.nowStage - o2.nowStage;
                }
                return Double.compare(o2.failRate, o1.failRate);
            });

            for (int i = 0; i < N; i++) {
                answer[i] = list.get(i).nowStage;
                System.out.println("실패율 >>>" + list.get(i).failRate);
            }

            return answer;
        }

        private static class Stage {

            double failRate;
            int nowStage;

            public Stage(double failRate, int nowStage) {
                this.failRate = failRate;
                this.nowStage = nowStage;
            }
        }
    }
}
