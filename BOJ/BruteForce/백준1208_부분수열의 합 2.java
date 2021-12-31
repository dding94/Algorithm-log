//백준 1208 중간에서 만나기
package Practice;

import java.io.*;
import java.util.*;

public class bj1208 {
	
	static int n,s;
	static long ans;
	static ArrayList<Integer> leftList = new ArrayList<>();
	static ArrayList<Integer> rightList = new ArrayList<>();
	static int arr[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		makeSum(0,0,n/2, leftList);	
		makeSum(0,n/2,n, rightList);
		
		Collections.sort(leftList);
		Collections.sort(rightList);
		
		ans = 0;
		
		findAns();
		
		if(s==0) ans -= 1;
		
		System.out.println(ans);
		
	}
	
	static void findAns() {
		int lPoint = 0;
		int rPoint = rightList.size()-1;
		
		while(lPoint < leftList.size() && rPoint>=0) {
			int lVal = leftList.get(lPoint);
			int rVal = rightList.get(rPoint);
			
			if(lVal + rVal == s) {
				long lCnt = 0;
				while(lPoint < leftList.size() && lVal == leftList.get(lPoint)) {
					lCnt++;
					lPoint++;
				}
				long rCnt = 0;
				while(rPoint >= 0 && rVal == rightList.get(rPoint)) {
					rCnt++;
					rPoint--;
				}
				ans += lCnt * rCnt;	
			}
			if(lVal + rVal > s) {
				rPoint--;
			}
			if(lVal + rVal < s) {
				lPoint++;
			}
		}	
	}
	
	
	static void makeSum(int sum, int start, int end, ArrayList<Integer> list) {
		if(start == end) {
			list.add(sum);
			return;
		}
		makeSum(sum,start+1,end,list);
		makeSum(sum+arr[start], start+1,end,list);
	}
}
