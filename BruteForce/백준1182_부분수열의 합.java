//백준 1182 부분수열의 합
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BruteForce2 {
	
	static int a[];
	static int n,s,ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		a = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		go(0,0);
		if(s == 0) ans-=1; //부분수열이 양수가 아닐경우
		System.out.println(ans);
	}
	
	static void go(int index, int sum) {
		if(index == n) {
			if(sum == s) {
				ans++;
				return;
			}		
		}
		
		go(index+1, sum+a[index]);
		go(index+1,sum);
	}

}
