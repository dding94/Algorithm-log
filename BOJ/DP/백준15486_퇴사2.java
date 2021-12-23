//백준 15486 퇴사 2
import java.io.*;
import java.util.*;

public class Main {
	static int ans = Integer.MIN_VALUE; 
	static int n;
	static int t[],p[];
	static long d[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	
		n = Integer.parseInt(br.readLine());
		t = new int[n];
		p = new int[n];
		d = new long[n+1];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<n; i++) {
			if(i+t[i] <= n) {
				d[i+t[i]] = Math.max(d[i+t[i]], d[i] + p[i]);
			}
			d[i+1] = Math.max(d[i+1], d[i]);
		}
			
		System.out.println(d[n]);
	}
}

