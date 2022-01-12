import java.util.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		Queue<Long> q = new PriorityQueue<Long>();

		for(int i=0; i<scoville.length; i++) {
			q.add((long) scoville[i]);
		}

		while(true) {

			if(q.size()>1) {
				Long temp1 = q.poll();
				Long temp2 = q.poll();

				if(temp1 >= K && temp2 >= K) {
					break;
				}

				q.add(temp1 + (temp2 * 2));

				answer++;
			}else {
				return q.poll() >= K ? answer : -1;
			}
		}

		return answer;
	}
}