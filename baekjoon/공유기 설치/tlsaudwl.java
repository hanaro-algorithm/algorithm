import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static int[] house;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        house = new int[N];

        for(int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);


        int min = 1; // 최소 거리가 가질 수 있는 최솟값
        int max = house[N - 1] - house[0] + 1;	// 최소 거리가 가질 수 있는 최댓값

        while(min < max) {
            int mid = (max + min) / 2;

            if(canInstall(mid) < M) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    public static int canInstall(int distance) {
        int count = 1;
        int lastLocate = house[0];

        for(int i = 1; i < house.length; i++) {
            int locate = house[i];

            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }
}