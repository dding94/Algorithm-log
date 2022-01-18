import java.util.*;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashMap<String, HashSet<String>> reportMemberList = new HashMap<>();
		HashMap<String, Integer> getMailCount = new HashMap<>();

		//초기화 작업
		for(String id: id_list) {
			getMailCount.put(id, 0);
			reportMemberList.put(id, new HashSet<>());
		}

		for(String rep: report) {
			StringTokenizer st = new StringTokenizer(rep);
			String id = st.nextToken();
			String reportTarget = st.nextToken();
			reportMemberList.get(reportTarget).add(id);
		}

		for(String key: reportMemberList.keySet()) {
			HashSet<String> reporters = reportMemberList.get(key);
			if(reporters.size()>= k) {
				for(String reporter: reporters) {
					Integer getMail = getMailCount.get(reporter);
					getMailCount.put(reporter, getMail+1);
				}
			}
		}

		for(int i=0; i<answer.length; i++) {
			answer[i] = getMailCount.get(id_list[i]);
		}


		return answer;
	}
}