import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] guessNumbers = new int[N];
        int[] strikeCounts = new int[N];
        int[] ballCounts = new int[N];

        for (int i = 0; i < N; i++) {
            guessNumbers[i] = scanner.nextInt();
            strikeCounts[i] = scanner.nextInt();
            ballCounts[i] = scanner.nextInt();
        }

        int possibleAnswers = 0;

        for (int number = 123; number <= 987; number++) {
            if (!isValid(number)) continue;

            boolean isCorrect = true;

            for (int i = 0; i < N; i++) {
                int guess = guessNumbers[i];

                int[] result = countStrikeAndBall(number, guess);
                int strike = result[0];
                int ball = result[1];

                if (strike != strikeCounts[i] || ball != ballCounts[i]) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                possibleAnswers++;
            }
        }

        System.out.println(possibleAnswers);
    }

    // 숫자가 유효한지 검사
    public static boolean isValid(int number) {
        int a = number / 100;
        int b = (number / 10) % 10;
        int c = number % 10;

        if (a == 0 || b == 0 || c == 0) return false;
        if (a == b || b == c || a == c) return false;

        return true;
    }

    // 스트라이크와 볼을 계산해서 배열로 리턴
    public static int[] countStrikeAndBall(int answer, int guess) {
        int[] answerDigits = {answer / 100, (answer / 10) % 10, answer % 10};
        int[] guessDigits = {guess / 100, (guess / 10) % 10, guess % 10};

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (answerDigits[i] == guessDigits[i]) {
                strike++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (i != j && answerDigits[i] == guessDigits[j]) {
                        ball++;
                    }
                }
            }
        }

        return new int[]{strike, ball};
    }
}
