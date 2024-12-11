import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sero = scan.nextInt();
        int garo = scan.nextInt();
        int[] height = new int[garo];
        for (int i = 0; i < garo; i++) {
            height[i] = scan.nextInt();
        }

        int total = 0;

        for (int i = 1; i < garo - 1; i++) {
            int leftMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int j = i; j < garo; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int water = Math.min(leftMax, rightMax) - height[i];
            if (water > 0) {
                total += water;
            }
        }

        System.out.println(total);
    }
}
