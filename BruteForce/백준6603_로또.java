//백준 6603 로또
package codingTest2_1;

import java.io.*;
import java.util.*;

public class BruteForce1 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> lotto = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			int a[] = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			go(a,0,0);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void go(int a[], int index, int cnt) {	
		//정답을 찾은 경우
		if(cnt == 6) {
			for(int ans : lotto) {
				sb.append(ans + " ");
			}
			sb.append('\n');
			return;
		}
		//불가능한 경우
		if(index == a.length) return;
		//다음 경우 호출
		lotto.add(a[index]); //선택 한경우 추가
		go(a,index+1,cnt+1);
		lotto.remove(lotto.size()-1); //맨 마지막으로 선택된것 제거
		go(a,index+1,cnt);	
		
	}

}
