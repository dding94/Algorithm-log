
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (max < list[i]) {
                    max = list[i];
                }else{
                    sum += (max - list[i]);
                }
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb);

    }
}