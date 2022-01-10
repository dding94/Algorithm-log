import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int grade[][] = new int[n][2]; //0: 서류 순위 , 1 : 면접순위
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				grade[i][0] = Integer.parseInt(st.nextToken());
				grade[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(grade, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int ans = 1;
			int prevGrade = grade[0][1]; //서류 1순위는 합격한걸로 한다.
			for(int i=1; i<n; i++) {
				if(grade[i][1] < prevGrade) {//면접"등수"가 더 높으면
					prevGrade = grade[i][1]; //뽑은사람의 면접등수를 가진다.
					ans++;
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
		
	}

}
