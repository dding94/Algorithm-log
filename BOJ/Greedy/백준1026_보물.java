import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Integer[] b = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(a);
		Arrays.sort(b, new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				return -(o1 - o2);
			}
		});
		
		int ans=0;
		for(int i=0; i<n; i++) {
			ans += a[i]*b[i];
		}
		
		System.out.println(ans);
		
	}

}
