import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int floor;
		int button; 
		Node(int floor, int button){
			this.floor = floor;
			this.button = button;
		}
	}
		
	static int f,s,g,u,d;
	static boolean check[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
	
		check = new boolean[f+1];
		bfs();
		
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(s, 0));
		check[s] = true;
		
		while(!q.isEmpty()) {
			Node p = q.poll();
			int now = p.floor;
			int button = p.button;
			
			if(now == g) {
				System.out.println(button);
				return;
			}
			
			if(1<= now+u && now+u <= f && !check[now+u]) {
				q.add(new Node(now+u,button+1));
				check[now+u] = true;
			}
			
			if(1<= now-d && now-d <= f && !check[now-d]) {
				q.add(new Node(now-d,button+1));
				check[now-d] = true;
			}
		}
		
		System.out.println("use the stairs");
	}
	
}
