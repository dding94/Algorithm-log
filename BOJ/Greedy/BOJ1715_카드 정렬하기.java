import java.io.*;
import java.util.*;

public class BOJ1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Long> q = new PriorityQueue<Long>();
		

		for(int i=0; i<n; i++) {
			q.add(Long.parseLong(br.readLine()));	
		}
		
		long sum = 0;
		while(q.size()>1) { 
			long temp1 = q.poll();
			long temp2 = q.poll();
			
			sum += (temp1+temp2);
			
			q.add(temp1+temp2);	
		}
		
		System.out.println(sum);
	}

}
