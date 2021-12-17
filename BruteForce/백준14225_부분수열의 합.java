//백준 14225 부분수열의 합
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BruteForce3 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int max = 2000000;
	static int a[];
	static boolean c[];
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n =Integer.parseInt(br.readLine());
		a = new int[n];
		c = new boolean[max];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		go(0,0);
	
		for(int i=1; i<=max; i++) {
			if(c[i] == false) {
				System.out.println(i);
				break;
			}
		}
	}
	static void go(int index, int sum) {
		if(index == n) {
			if(sum != 0) {
				c[sum] = true;	
				return;		
			}
		}
		if(index == n) return;
		
		
		go(index+1, sum+a[index]);
		go(index+1, sum);
	}
}
