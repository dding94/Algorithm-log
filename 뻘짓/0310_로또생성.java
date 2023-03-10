import java.io.*;
import java.util.*;

public class 로또생성 {

    static final Integer LOTTO_NUMBER = 45;
    static final Integer LOTTO_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int playGame = Integer.parseInt(br.readLine());

        Random random = new Random();

        for (int i = 0; i < playGame; i++) {
            makeLotto(random);
        }
    }

    private static void makeLotto(Random random) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LOTTO_LENGTH) {
            int number = random.nextInt(LOTTO_NUMBER) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        numbers.sort((o1, o2) -> o1-o2);

        for (Integer number : numbers) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }
}
