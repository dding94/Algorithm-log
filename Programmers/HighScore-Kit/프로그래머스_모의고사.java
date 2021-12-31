//프로그래머스_모의고사
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int person1[] = {1,2,3,4,5};
		int person2[] = {2,1,2,3,2,4,2,5};
		int person3[] = {3,3,1,1,2,2,4,4,5,5};
		int ans[] = new int[3];
        
        for(int i=0; i<answers.length; i++) {
			if(person1[i%5] == answers[i]) ans[0]++;
			if(person2[i%8] == answers[i]) ans[1]++;
			if(person3[i%10] == answers[i]) ans[2]++;
		}
        
        ArrayList<Integer> rank = new ArrayList<>();
        int max = Math.max(ans[0], Math.max(ans[1], ans[2]));

        for(int i=1; i<=3; i++) {
			if(max == ans[i-1]) rank.add(i);
		}
        answer = new int[rank.size()];
        
        for(int i=0; i<rank.size(); i++) {
			answer[i] = rank.get(i);
		}
        
        return answer;
    }
}