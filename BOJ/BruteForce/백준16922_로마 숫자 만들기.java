import java.io.*;

public class Main {

	static int n;
	static int arr[] = {1,5,10,50};
	static boolean visit[];
	static int ans;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visit = new boolean[1001];
		n = Integer.parseInt(br.readLine());
		
		go(0,0,0);
		
		System.out.println(ans);
	}

	static void go(int index,int start,int sum) {
		if(index == n){
			if(visit[sum] == false) {
				visit[sum] = true;
				ans++;
			}
			return;
		}
			
		for(int i=start; i<4 ;i++) {
			go(index+1,i,sum+arr[i]);
		}
		
	}
}
