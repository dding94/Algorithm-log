//나3곱2
package 백준;

import java.io.*;
import java.util.*;
public class PS0127_16936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            long num = Long.parseLong(st.nextToken());
            arr[i][0] = num;
            while(num % 3 == 0){
                arr[i][1]++;
                num /= 3;
            }
        }

        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] == o2[1]) {
                    return Long.compare(o1[0], o2[0]);
                }else{
                    return Long.compare(o2[1], o1[1]);
                }

            }
        });

        for(int i=0; i<n; i++){
            System.out.print(arr[i][0] +" ");
        }

    }



}
