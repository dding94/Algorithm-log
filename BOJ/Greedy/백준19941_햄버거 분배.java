package 백준.PS6월;

import java.io.*;
import java.util.*;

public class PS0615_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n];

        char[] data = br.readLine().toCharArray();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = false;

            if(data[i]=='P') {
                for (int j = k; j >= 1; j--) {
                    if(!flag) {
                        if(i-j<0) continue;
                        if(data[i-j]=='H'&&!check[i-j]) {
                            check[i-j] = true;
                            ans++;
                            flag=true;
                        }
                    }
                }
                if(!flag) {
                    for (int j = 1; j <= k; j++) {
                        if(!flag) {
                            if(i+j>=n) continue;
                            if(data[i+j]=='H'&&!check[i+j]) {
                                check[i+j] = true;
                                ans++;
                                flag=true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
