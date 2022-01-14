package BFS;

import java.io.*;
import java.util.*;

public class BOJ14395 {

	static class Node{
		long num;
		String cmd;
		Node(long num, String cmd){
			this.num = num;
			this.cmd = cmd;
		}
	}
	
	static final long limit = 1000000000L;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		long s = Integer.parseInt(st.nextToken());
		long t = Integer.parseInt(st.nextToken());
		
		if(s == t) {
			System.out.println(0);
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		HashSet<Long> check = new HashSet<Long>();
		q.add(new Node(s,""));
		check.add(s);
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			long num = p.num;
			String cmd = p.cmd;
			
			if(num == t) {
				System.out.println(cmd);
				return;
			}
			
			if(0<= num*num && num*num <= limit && !check.contains(num*num)) {
				q.add(new Node(num*num,cmd+"*"));
				check.add(num*num);
			}
			if(0<= num+num && num+num <= limit && !check.contains(num+num)) {
				q.add(new Node(num+num,cmd+"+"));
				check.add(num+num);
			}
			if(0<= num-num && num-num <= limit && !check.contains(num-num)) {
				q.add(new Node(num-num,cmd+"-"));
				check.add(num*num);
			}
			if(num != 0 && 0<= num/num && num/num <= limit && !check.contains(num/num)) {
				q.add(new Node(num/num,cmd+"/"));
				check.add(num/num);
			}
		}
		
		System.out.println(-1);
			
	}
		
}
