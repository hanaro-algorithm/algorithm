import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            int x = scan.nextInt();
            int y = scan.nextInt();

            int count = 0;
            while (x <= y) {
                String number = Integer.toString(x);
                int score = 0;
                for (int i = 0; i < number.length() - 1; i++) {
                    for (int j = i + 1; j < number.length(); j++) {
                        if (number.charAt(i) == number.charAt(j)) {
                            score++;
                            break;
                        }
                    }
                }
                if (score == 0)
                    count++;
                x++;
            }
            System.out.println(count);
        }

    }
}