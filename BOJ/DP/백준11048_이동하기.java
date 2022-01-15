import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int d[][] = new int[n+1][m+1];
        int a[][] = new int[n+1][m+1];

        for(int i=1; i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                d[i][j] = Math.max(Math.max(d[i - 1][j - 1], (d[i - 1][j])), d[i][j - 1]) + a[i][j];
            }
        }

        System.out.println(d[n][m]);
    }
}
