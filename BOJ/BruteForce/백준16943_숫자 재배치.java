//숫자 재배치
package 백준;

import java.io.*;
import java.util.*;

public class PS0127_16943 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] a = st.nextToken().toCharArray();
        int b = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        int ans = -1;

        do {
            int number = toNum(a);
            if(a[0] != '0' && number < b){
                if (ans == -1 || ans < number) {
                    ans = number;
                }
            }
        } while (nextPermutation(a));

        System.out.println(ans);
    }

    static int toNum(char[] a){
        int ans = 0;

        for (char c : a) {
            ans = ans * 10 + (c - '0');
        }

        return ans;
    }


    static boolean nextPermutation(char[] a){
        int i = a.length-1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if(i <= 0) return false;

        int j = a.length-1;

        while (a[i - 1] >= a[j]) {
            j--;
        }

        char temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;

        while(i<j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return true;
    }

}
