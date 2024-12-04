import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String S = scan.next();
        String T = scan.next();

        int lengthS = S.length();
        int lengthT = T.length();

        int max = lengthS * lengthT;

        String repeateS = "";
        String repeateT = "";

        while (repeateS.length() < max) {
            repeateS += S;
        }

        while (repeateT.length() < max) {
            repeateT += T;
        }

        if (repeateS.equals(repeateT)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}