import java.util.*;

public class Main {
    static String[] digits = {
            "###" +
                    "#.#" +
                    "#.#" +
                    "#.#" +
                    "###", // 0

            "..#" +
                    "..#" +
                    "..#" +
                    "..#" +
                    "..#", // 1

            "###" +
                    "..#" +
                    "###" +
                    "#.." +
                    "###", // 2

            "###" +
                    "..#" +
                    "###" +
                    "..#" +
                    "###", // 3

            "#.#" +
                    "#.#" +
                    "###" +
                    "..#" +
                    "..#", // 4

            "###" +
                    "#.." +
                    "###" +
                    "..#" +
                    "###", // 5

            "###" +
                    "#.." +
                    "###" +
                    "#.#" +
                    "###", // 6

            "###" +
                    "..#" +
                    "..#" +
                    "..#" +
                    "..#", // 7

            "###" +
                    "#.#" +
                    "###" +
                    "#.#" +
                    "###", // 8

            "###" +
                    "#.#" +
                    "###" +
                    "..#" +
                    "###"  // 9
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        int cols = N / 5;
        String[] grid = new String[5];
        for (int i = 0; i < 5; i++) {
            grid[i] = input.substring(i * cols, (i + 1) * cols);
        }

        StringBuilder result = new StringBuilder();
        int c = 0;
        while (c < cols) {
            if (grid[0].charAt(c) == '.') {
                c++;
                continue;
            }

            if (c + 1 >= cols || (grid[0].charAt(c) == '#' && grid[0].charAt(c + 1) == '.' &&
                    grid[1].charAt(c) == '#' && grid[1].charAt(c + 1) == '.' &&
                    grid[2].charAt(c) == '#' && grid[2].charAt(c + 1) == '.' &&
                    grid[3].charAt(c) == '#' && grid[3].charAt(c + 1) == '.' &&
                    grid[4].charAt(c) == '#' && grid[4].charAt(c + 1) == '.')) {
                result.append(1);
                c += 1;
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                sb.append(grid[i], c, c + 3);
            }

            String pattern = sb.toString();
            for (int i = 0; i < 10; i++) {
                if (digits[i].equals(pattern)) {
                    result.append(i);
                    break;
                }
            }
            c += 3;
        }

        System.out.println(result);
    }
}
