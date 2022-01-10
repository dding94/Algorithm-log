import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		/*
		 * time[][0] = 회의시작시간
		 * time[][1] = 회의종료시간
		 */
		int[][] time = new int[n][2];

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) { //회의 종료시간이 같다면
					return o1[0] - o2[0]; //시작시간을 기준으로 정렬한다.
				}
				return o1[1] - o2[1]; //회의 종료시간 정렬
			}
		});

//		Arrays.sort(time, comp); //다른 방법

		int count = 0;
		int prev_end_time = 0;

		for (int i = 0; i < n; i++) {
			if (prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}

		System.out.println(count);

	}
//
//	public static Comparator<int[]> comp = new Comparator<int[]>() {
//		
//		@Override
//		public int compare(int[] o1, int[] o2) {
//			if(o1[1] == o2[1]) {
//				return o1[0] - o2[0];
//			}
//			return o1[1] - o2[1];
//		}
//	};
}
