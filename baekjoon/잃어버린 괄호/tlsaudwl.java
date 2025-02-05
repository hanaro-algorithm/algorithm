import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sik = sc.nextLine();
        String[] parts = sik.split("-");

        int result = 0;

        String[] firstPart = parts[0].split("\\+");
        for (String num : firstPart) {
            result += Integer.parseInt(num);
        }

        for (int i = 1; i < parts.length; i++) {
            String[] subParts = parts[i].split("\\+");
            for (String num : subParts) {
                result -= Integer.parseInt(num);
            }
        }

        System.out.println(result);
    }
}
