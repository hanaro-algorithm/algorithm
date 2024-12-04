import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine(); // 굉장히 중요!!

        char[][] room = new char[n][n];

        for(int i = 0; i < n; i++){
            String status = scan.nextLine();
            for(int j = 0; j < n; j++){
                room[i][j] = status.charAt(j);
            }
        }

        int garo = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) garo++;
                    count = 0;
                }
            }
            if (count >= 2) garo++;
        }

        int sero = 0;
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) sero++;
                    count = 0;
                }
            }
            if (count >= 2) sero++;
        }

        System.out.println(garo + " " + sero);
    }
}