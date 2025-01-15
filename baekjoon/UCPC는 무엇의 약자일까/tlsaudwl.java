import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String target = "UCPC";
        int targetIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == target.charAt(targetIndex)) {
                targetIndex++;
                if (targetIndex == target.length()) {
                    System.out.println("I love UCPC");
                    return;
                }
            }
        }

        System.out.println("I hate UCPC");
    }
}
