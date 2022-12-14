package 에프랩스터디;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ps1214_압축 {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] result = sol.solution("KAKAO");
//        int[] result = sol.solution("TOBEORNOTTOBEORTOBEORNOT\t");
//        sol.solution("ABABABABABABABAB");
        sol.solution("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    private static class Solution {
        public int[] solution(String msg) {
            int[] answer = {};
            Map<String, Integer> hm = new HashMap<>();

            for (int i = 'A'; i <= 'Z'; i++) {
                hm.put(String.valueOf((char) i), i - 64);
            }

            List<Integer> list = new ArrayList<>();
            //매번 새로운 문자 객체를 생성하지 않기 위함
            StringBuilder sb = new StringBuilder();

            //O(1000)
            for (int i = 0; i < msg.length(); i++) {

                //point => for 문 i와 별개로 문자열을 지정할 인덱스용
                int point = i;
                sb.append(msg.charAt(point));

                if (point + 1 < msg.length()) {
                    point++;
                    sb.append(msg.charAt(point));

                    //압축된 키가 있으면 다음 문자열을 만들어 검사를 해본다.
                    //O(1000)
                    while (hm.containsKey(sb.toString())) {
                        i++;
                        point++;
                        if (point == msg.length()) {
                            //의미 없는 수를 하나 넣고 탈출한다. flag 변수를 따로 만들어도 괜찮았을 듯
                            sb.append(0);
                            break;
                        }
                        sb.append(msg.charAt(point));
                    }

                    hm.put(sb.toString(), hm.size() + 1);
                    //추가하기 전 문자열로 셋팅을 한다.
                    sb.setLength(sb.length() - 1);
                }

                list.add(hm.get(sb.toString()));
                sb.setLength(0);
            }

            answer = new int[list.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }
}
