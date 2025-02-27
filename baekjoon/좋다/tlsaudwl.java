import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isGoodNumber(arr, N, i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isGoodNumber(int[] arr, int N, int index) {
        int target = arr[index];
        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (left == index) {
                left++;
                continue;
            }
            if (right == index) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
