package codingTest2_1;

import java.io.*;
import java.util.*;

public class TwoPointer1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int a[] = new int[n+1];		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = a[0];
		int left = 0;
		int right = 0;
		int ans = 0;
		
		while(left <= right && right <n) {
			if(sum < m) {
				right += 1;
				sum += a[right];
			}else if(sum == m) {
				ans+=1;
				right += 1;
				sum += a[right];
			}else if(sum > m) {
				sum -= a[left];
				left+=1;
				if(left>right && left < n) {
					right = left;
					sum = a[left];
				}
			}
		}
		System.out.println(ans);
	}

}
