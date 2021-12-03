//백준 1309 동물원
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mod = 9901;
		long d[][] = new long[n+1][3];
		
		d[1][0] = 1; d[1][1] =1; d[1][2] =1; 
		for(int i=2; i<=n; i++) {
			d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
			d[i][1] = d[i-1][0] + d[i-1][2];
			d[i][2] = d[i-1][0] + d[i-1][1];
			
			d[i][0] %= mod;
			d[i][1] %= mod;
			d[i][2] %= mod;
		}
		
		System.out.println((d[n][0] + d[n][1] + d[n][2])%mod);
	}

}
