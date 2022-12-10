package 에프랩스터디;


import java.util.LinkedList;
import java.util.Queue;

public class ps1210_다리를지나는트럭 {

    public static void main(String[] args) {

        Solution sol = new Solution();
//        int solution = sol.solution(5, 10, new int[]{1, 1, 10, 1, 1});
//        int solution = sol.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
//        int solution = sol.solution(100, 100, new int[]{10});
        int solution = sol.solution(10000, 10000,
            new int[]{1, 1, 1, 1, 1, 1, 1, 10000, 9999, 9998, 1});


        System.out.println(solution);
    }

    private static class Solution {

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Truck> q = new LinkedList<>();

            int bride_weights = 0;
            int point = 0;

            while (point == 0 || !q.isEmpty()) {
                if (!q.isEmpty() && q.peek().time == bridge_length) {
                    bride_weights -= q.poll().weight;
                }

                if (point != truck_weights.length
                    && bride_weights + truck_weights[point] <= weight) {
                    bride_weights += truck_weights[point];
                    q.add(new Truck(truck_weights[point], 0));
                    point++;
                }

                for (Truck truck : q) {
                    truck.time++;
                }
                answer++;
            }

            return answer;
        }

        private static class Truck {

            int weight;
            int time;

            public Truck(int weight, int time) {
                this.weight = weight;
                this.time = time;
            }
        }
    }

}
