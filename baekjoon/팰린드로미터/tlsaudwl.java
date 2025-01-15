import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            int currentNumber = Integer.parseInt(input);
            int minDistance = 0;

            while (!isPalindromeNumber(currentNumber, input.length())) {
                currentNumber++;
                minDistance++;
            }

            System.out.println(minDistance);
        }

    }

    private static boolean isPalindromeNumber(int number, int length) {
        int[] digits = new int[length];
        int temp = number;

        for (int i = length - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        for (int i = 0; i < length / 2; i++) {
            if (digits[i] != digits[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
