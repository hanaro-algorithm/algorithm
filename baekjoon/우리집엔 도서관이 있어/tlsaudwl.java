import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] books = new int[N];

        for (int i = 0; i < N; i++) {
            books[i] = sc.nextInt();
        }

        int need = N;

        for (int i = N - 1; i >= 0; i--) {
            if (books[i] == need) {
                need--;
            }
        }

        System.out.println(need);
    }
}
