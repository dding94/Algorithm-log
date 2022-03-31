package 백준.PS3월;
import java.util.*;
import java.io.*;

public class PS0331_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int a=0; a<t; a++){
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                list[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(list);
            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){

                int left = 0, right = n, val = Integer.parseInt(st.nextToken());
                boolean find = false;

                while(left <= right){
                    int mid = (left + right) / 2;

                    if(list[mid] == val){
                        find = true;
                        break;
                    }
                    else if(list[mid] < val)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }

                sb.append(find? 1 : 0).append("\n");
            }

            System.out.print(sb);
        }
    }
}
