package 백준23.PS1월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PS0205_수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] counting = new int[10001];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
            counting[list[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counting.length; i++) {

            while (counting[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

}
