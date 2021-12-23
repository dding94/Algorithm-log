//백준 20500 Ezreal 여눈부터 가네 ㅈㅈ
package baekjoon;

import java.io.*;
import java.util.*;
public class bj20500 {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long d[][] = new long[4][1516];
		int mod = 1000000007;
		
		// 1의 자리를 5로 고정하면서 한자리씩늘려가면서 3으로 나눈 나머지 0,1,2 의 개수를 기록
		// d[i][j] = j개수의 자리로 이루어지면서 3으로 나눈 나머지가 i인 수
	
		d[0][1] = 0; d[0][2] = 1; d[1][2] = 1; d[2][3] = 1;
		
		for(int i=3; i<=n; i++) {
			d[0][i] = d[1][i-1] + d[2][i-1];
			d[1][i] = d[0][i-1] + d[2][i-1];
			d[2][i] = d[0][i-1] + d[1][i-1];
			
			d[0][i] %= mod;
			d[1][i] %= mod;
			d[2][i] %= mod;
		}
		
		System.out.println(d[0][n]);
	}

}
