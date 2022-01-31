import java.io.*;
import java.util.*;
public class Main {
    
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		
        while(kim != lim) {			
                kim = kim/2 + kim%2;		
                lim = lim/2 + lim%2;	
                ans++;  
        }
        System.out.println(ans);
    }
}
