package 백준.PS3월;

import java.io.*;
import java.util.*;

public class PS0310_5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(br.readLine());
            }

            Collections.sort(list);

            boolean flag = false;
            for (int i = 1; i < n; i++) {

                if (list.get(i).startsWith(list.get(i - 1))) {
                    flag = true;
                    break;
                }
            }

            if(flag){
                sb.append("NO" + "\n");
            }else{
                sb.append("YES" + "\n");
            }

        }

        System.out.println(sb);

    }
}
