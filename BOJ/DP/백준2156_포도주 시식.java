//백준 2156 포도주 시식
package codingTest1_2;

import java.io.*;
import java.util.*;

public class dp_5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		int a[] = new int[n+1];
		int d[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		d[1] = a[1];
		if(n>=2) d[2] = a[1] + a[2]; // n이 1일경우
		
		
		for(int i=3; i<=n; i++) {
			d[i] = Math.max(Math.max(d[i-1], d[i-2]+a[i]), d[i-3]+a[i-1]+a[i]);
		}
			
		System.out.println(d[n]);
	}
}
