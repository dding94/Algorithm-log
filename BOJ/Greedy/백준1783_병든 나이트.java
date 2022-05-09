import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = 0;
        if(n == 1) ans = 1;
        if(n == 2) ans = Math.min(4, (m+1) / 2);
        if(n >= 3) {
            if(m >= 7) {
                ans = m - 2;
            }else {
                ans = Math.min(4, m);
            }
        }
        System.out.println(ans);
    }
}