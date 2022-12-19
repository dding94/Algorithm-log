package 에프랩스터디;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ps1219_오픈채팅방 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
            }
        );
    }

    private static class Solution {

        public String[] solution(String[] record) {
            String[] answer = {};
            List<String> list = new ArrayList<>();
            Map<String, String> hm = new HashMap<>();

            //O(10만)
            for (String s : record) {
                //O(30 + 1)
                String[] split = s.split(" ");
                String first = split[0];
                String uid = split[1];

                if (first.equals("Change") || first.equals("Enter")) {
                    String nickName = split[2];
                    hm.put(uid, nickName);
                }
            }

            //O(10만)
            for (String s : record) {
                //O(30 + 1)
                String[] split = s.split(" ");
                String first = split[0];
                String uid = split[1];
                String nickName = hm.get(uid);

                if (first.equals("Enter")) {
                    list.add(nickName + "님이 들어왔습니다.");
                }

                if (first.equals("Leave")) {
                    list.add(nickName + "님이 나갔습니다.");
                }
            }

            //O(10만)
            answer = new String[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
