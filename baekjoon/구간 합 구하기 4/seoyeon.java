import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // n값
        int M = scan.nextInt(); // m값
        int arr[] = new int[N + 1];     // 부분 누적 합 미리 저장
        arr[0] = 0;
        for (int i = 0; i < N; i++) {
            arr[i + 1] = arr[i] + scan.nextInt();
        }
        for (int i = 0; i < M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            System.out.println(arr[b] - arr[a - 1]);
        }
    }
}