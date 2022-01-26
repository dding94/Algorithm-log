package 백준;

import java.io.*;

public class BOJ1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long sum = 0;


        for(int i=1; ; i++){
            sum += i;
            if(sum > s){
                System.out.println(i-1);
                break;
            }
        }

    }
}
