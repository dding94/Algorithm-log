import java.util.*;
import java.io.*;

public class Main {

	static class Node{
		long n;
		long dist;
		Node(long n, long dist){
			this.n = n;
			this.dist = dist;
		}
	}
	static long a, b, ans;
	static final long limit = 1000000001L;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
				

		ans = -1;
		bfs();
		System.out.println(ans);
		
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(a,1));
		int cnt=1;
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(now.n == b) {
				ans = now.dist;
				return;
			}
			
			if(now.n*2 <= b) {
				q.add(new Node(now.n*2, now.dist+1));
			}
			
			if((now.n*10)+1 <= b) {
				q.add(new Node(now.n*10+1, now.dist+1));
				
			}	
		}
	}
}

