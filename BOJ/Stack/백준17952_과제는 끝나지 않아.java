package 백준.PS10월;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PS1010_17952 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        Stack<Exam> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");

            if (split[0].equals("0")) {
                if (!stack.isEmpty()) {
                    stack.peek().T--;
                    if (stack.peek().T == 0) {
                        ans += stack.peek().A;
                        stack.pop();
                    }
                }
            }

            if (split[0].equals("1")) {
                int A = Integer.parseInt(split[1]);
                int T = Integer.parseInt(split[2]) - 1;

                if (T == 0) {
                    ans += A;
                    continue;
                }
                stack.add(new Exam(A, T));
            }
        }

        System.out.println(ans);
    }

    private static class Exam {
        int A;
        int T;

        public Exam(int a, int t) {
            A = a;
            T = t;
        }
    }

}
