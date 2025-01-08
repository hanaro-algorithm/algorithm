import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[] cards = new long[N];

        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextLong();
        }

        Arrays.sort(cards);

        long mostFrequent = cards[0];
        int maxCount = 1, currentCount = 1;

        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1; 
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequent = cards[i];
            }
        }

        System.out.println(mostFrequent);
    }
}
