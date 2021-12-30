package codingTest2_1;

import java.io.*;
import java.util.*;

public class TwoPointer2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int a[] = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int sum = a[0];
		
		while(left<=right && right<n) {
			if(sum < s) {
				right++;
				sum += a[right];
			}else if(sum == s) {
				int leng = Math.abs(right - left) + 1;
				if(ans > leng) ans = leng;
				right++;
				sum += a[right];
			}else if(sum > s) {
				int leng = Math.abs(right - left) + 1;
				if(ans > leng) ans = leng;
				sum -= a[left];
				left++;
				if(left>right && left<n) {
					right = left;
					sum = a[right];
				}
			}	
		}
		if(ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}

}
