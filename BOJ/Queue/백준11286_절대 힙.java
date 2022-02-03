//절대 힙
package 백준;

import java.util.*;
import java.io.*;

public class PS0203_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(q.isEmpty()){
                    sb.append("0").append('\n');
                }else{
                    sb.append(q.poll()).append('\n');
                }
            }else{
                q.add(x);
            }
        }

        System.out.println(sb);
    }
}
