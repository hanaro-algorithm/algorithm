import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int n = input.length();
        String[] suffixArray = new String[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = input.substring(i);
        }

        Arrays.sort(suffixArray);

        int maxLength = 0;
        for (int i = 0; i < n - 1; i++) {
            int lcpLength = getLCP(suffixArray[i], suffixArray[i + 1]);
            maxLength = Math.max(maxLength, lcpLength);
        }

        System.out.println(maxLength);
    }

    private static int getLCP(String str1, String str2) {
        int length = 0;
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}
