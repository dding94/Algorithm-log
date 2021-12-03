//백준 11057 오르막수
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 10007;
		
		int n = Integer.parseInt(br.readLine());
		long d[][] = new long[n+1][10];
		
		d[0][0] =1;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				for(int l=0; l<=j; l++) {
					d[i][j] += d[i-1][j-l];
					d[i][j] %= mod;
				}
			}
		}
		
		int ans =0;
		for(int i=0; i<=9; i++) {
			ans += d[n][i];
			ans %= mod;
		}
		System.out.println(ans);
		
	}

}
