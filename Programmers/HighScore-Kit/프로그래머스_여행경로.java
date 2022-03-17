import java.util.ArrayList;
import java.util.Collections;

class Solution {

    static boolean[] ticketUsed;
    static ArrayList<String> pathList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ticketUsed = new boolean[tickets.length];

        dfs("ICN", "ICN", 0, tickets);

        Collections.sort(pathList);

        return pathList.get(0).split(" ");
    }

    static void dfs(String now, String path, int count, String[][] tickets) {
        if (count == tickets.length) {ㄴㅋ
            pathList.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!ticketUsed[i] && tickets[i][0].equals(now)) {
                ticketUsed[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], count + 1, tickets);
                ticketUsed[i] = false;
            }
        }
    }
}