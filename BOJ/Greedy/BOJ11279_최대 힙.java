import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			int cmd = Integer.parseInt(br.readLine());
			
			if(cmd == 0) {
				if(q.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					sb.append(q.poll()).append('\n');
				}
			}
			if(cmd > 0) {
				q.add(cmd);
			}				
		}
		
		System.out.println(sb);
	}

}
