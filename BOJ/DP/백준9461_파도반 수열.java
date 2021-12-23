package Practice;


import java.io.*;
import java.util.*;
public class bj9461 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		long d[] = new long[101];
		
		d[1] = d[2] = d[3] = 1;
		
		for(int i=3; i<=100; i++) {
			d[i] = d[i-2] + d[i-3];
		}
		
		
		while(t-->0){
			int n = Integer.parseInt(br.readLine());
			
			sb.append(d[n]).append('\n');
		}
		
		System.out.println(sb);
	}

}
