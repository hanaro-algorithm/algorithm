import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int roomCount = 0; // 사용중인 회의실 개수
        int maxRoom = 0; // 가장 많이 필요했던 회의식 개수
        int startIndex = 0, endIndex = 0; // 시작, 종료 비교 인덱스

        while (startIndex < n) {
            if(start[startIndex] < end[endIndex]) {
                // 새로운 회의 시작 -> 회의실 추가
                roomCount++;
                maxRoom = Math.max(maxRoom, roomCount);
                startIndex++;
            } else{
                // 기존 회의 종료 -> 회의실 빼기
                roomCount--;
                endIndex++;
            }
        }

        System.out.println(maxRoom);
    }
}
