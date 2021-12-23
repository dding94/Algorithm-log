package Practice;

import java.io.*;
import java.util.*;

public class boj1904 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int mod = 15746;
		long d[] = new long[1000001];
		
		d[0] = 0; d[1] = 1; d[2] = 2;
		for(int i=3; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] %= mod;
		}
		
		System.out.println(d[n]);
	}
}