package programmers;

import java.io.*;
import java.util.*;

public class kakao_OpenChatting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	
		su.solution(record);
	}
	
	static class Solution {
	    public String[] solution(String[] record) {
	        String[] answer = {};
	        
	        Map<String, String> idMap= new HashMap<>();
	        List<String> chatLog = new ArrayList<>();
	    
	        for(String str : record) {
	        	StringTokenizer st = new StringTokenizer(str);
	        	String cmd = st.nextToken();
	        	if(cmd.equals("Enter") || cmd.equals("Change")) {
	        		String id = st.nextToken();
	        		String name = st.nextToken();
	        		
	        		idMap.put(id, name);
	        	}        	
	        }
	        
	        for(String str : record) {
	        	StringTokenizer st = new StringTokenizer(str);
	        	String cmd = st.nextToken();
	        	if(cmd.equals("Enter")) {
	        		String id = st.nextToken();
	        		String name = idMap.get(id);
	        		chatLog.add(name + "님이 들어왔습니다.");
	        	}else if(cmd.equals("Leave")) {
	        		String id = st.nextToken();
	        		String name = idMap.get(id);
	        		chatLog.add(name + "님이 나갔습니다.");
	        	}
	        }
	        answer = new String[chatLog.size()];
	        
	        chatLog.toArray(answer);
	        
	        return answer;
	    }
	}
}
