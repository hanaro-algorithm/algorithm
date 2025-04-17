import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int i = 0;
        boolean isValid = true;

        while (i < s.length()) {
            int w = 0, o = 0, l = 0, f = 0; // 각 문자의 개수

            while (i < s.length() && s.charAt(i) == 'w') {
                w++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == 'o') {
                o++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == 'l') {
                l++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == 'f') {
                f++;
                i++;
            }

            if (w == 0 || w != o || o != l || l != f) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? 1 : 0);
    }
}
