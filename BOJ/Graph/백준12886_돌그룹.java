//백준 12886 돌그룹
import java.io.*;
import java.util.*;

public class Main{
	static boolean check[][] = new boolean[1500][1500];
	static int answer=0;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		sum = a+b+c;
		if(sum % 3 != 0) {
			System.out.println("0");
			return;
		}
		
		check[a][b] = true;
		dfs(a,b);
		System.out.println(answer);
	}
	
	static void dfs(int a, int b) {
		int c = sum - a - b;
		if(a==b && b==c) {
			answer = 1;
			return;
		}
		
		go(a,b);
		go(a,c);
		go(b,c);
	}
	
	static void go(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		
		if(!check[big - small][small*2] || !check[small*2][big - small]) {
			check[big-small][small*2] = check[small*2][big-small] = true;
			dfs(big-small,small*2);
		}
	}
}
