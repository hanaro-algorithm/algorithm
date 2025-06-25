import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            String[] types = new String[30];
            int[] count = new int[30];
            int kindCount = 0;

            for (int i = 0; i < n; i++) {
                String name = sc.next();
                String type = sc.next();

                boolean found = false;
                for (int j = 0; j < kindCount; j++) {
                    if (types[j].equals(type)) {
                        count[j]++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    types[kindCount] = type;
                    count[kindCount] = 1;
                    kindCount++;
                }
            }

            int answer = 1;
            for (int i = 0; i < kindCount; i++) {
                answer *= (count[i] + 1);
            }

            System.out.println(answer - 1);
        }

    }
}
