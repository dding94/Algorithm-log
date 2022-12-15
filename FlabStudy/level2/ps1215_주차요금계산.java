package 에프랩스터디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ps1215_주차요금계산 {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.solution(new int[]{180, 5000, 10, 600},
//            new String[]{
//                "05:34 5961 IN",
//                "06:00 0000 IN",
//                "06:34 0000 OUT",
//                "07:59 5961 OUT",
//                "07:59 0148 IN",
//                "18:59 0000 IN",
//                "19:09 0148 OUT",
//                "22:59 5961 IN",
//                "23:00 5961 OUT"}
//        );
        sol.solution(new int[]{1, 461, 1, 10},
            new String[]{
                "00:00 1234 In"}
        );

    }

    private static class Solution {

        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};

            int lastTime = (23 * 60) + 59;
            Map<String, Integer> parkingTime = new HashMap<>();
            Map<String, Integer> parkingCar = new HashMap<>();
            List<String> carList = new ArrayList<>();

            //O(1000)
            for (String record : records) {
                String[] timeSplit = record.split(" ")[0].split(":");
                String[] recordSplit = record.split(" ");
                String carNumber = recordSplit[1];

                int minTime = (Integer.parseInt(timeSplit[0]) * 60) + Integer.parseInt(timeSplit[1]);

                //O(1000)
                if (parkingCar.containsKey(carNumber)) {
                    int time = minTime - parkingCar.get(carNumber);

                    parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + time);
                    parkingCar.remove(carNumber);
                } else {
                    parkingCar.put(carNumber, minTime);
                    if (parkingTime.get(carNumber) == null) {
                        carList.add(carNumber);
                    }
                }
            }

            Collections.sort(carList);
            answer = new int[carList.size()];

            //O(1000)
            for (int i = 0; i < carList.size(); i++) {
                String key = carList.get(i);

                int totalParkingTime = parkingTime.getOrDefault(key, 0);
                int totalPrice = fees[1];


                if (parkingCar.get(key) != null) {
                    totalParkingTime += (lastTime - parkingCar.get(key));
                }

                //기본시간 내 사용하면 기본요금만 지불한다.
                if (totalParkingTime > fees[0]) {
                    int unitTime = (int) Math.ceil((double) (totalParkingTime - fees[0]) / fees[2]);
                    totalPrice += unitTime * fees[3];
                }
                answer[i] = totalPrice;
            }

            return answer;
        }
    }
}
