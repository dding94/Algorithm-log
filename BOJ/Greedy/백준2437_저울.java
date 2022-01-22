import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a); //무게 오름차순 정렬
        int sum = 0;
        for(int i=0; i<n; i++){
            if (sum+1 < a[i]){ //현재 저울이 측정할 수 있는 무게 + 1보다 추의 무게가 높을 경우
                break; // 해당 무게 sum+1)는 측정할 수 없다.
            }
            sum+=a[i];
        }

        System.out.println(sum+1);
    }
}
