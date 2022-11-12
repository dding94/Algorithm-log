package 백준.PS11월;

import java.io.*;
import java.util.StringTokenizer;

public class PS1112_1817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] books = new int[n];

        if(n == 0){
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            books[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        int weight = 0;

        for(int i = 0 ; i < n; i++){
            weight += books[i];
            if(weight > m){
                ans++;
                weight = books[i];
            }
        }

        System.out.println(ans);
    }
}
