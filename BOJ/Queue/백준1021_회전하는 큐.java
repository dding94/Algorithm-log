//회전하는 큐
package 백준.PS4월;

import java.util.*;
import java.io.*;

public class PS0403_1021 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static LinkedList<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] temp = new int[m];
        for(int i = 0; i < m; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++)
            q.add(i);

        for(int i = 0; i < m; i++) {

            if(check(temp[i])) {
                while(temp[i]!=q.get(0)) {
                    q.addLast(q.pollFirst());
                    count++;
                }
            }else {
                while(temp[i]!=q.get(0)) {
                    q.addFirst(q.pollLast());
                    count++;
                }
            }

            q.poll();
        }


        System.out.println(count);

    }
    public static boolean check(int a) {

        for(int i = 0 ; i <= q.size()/2 ; i++) {
            if(a == q.get(i))
                return true;
        }

        return false;
    }

}
