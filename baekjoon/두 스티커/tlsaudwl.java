import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int H = scan.nextInt();
        int W = scan.nextInt();

        int N = scan.nextInt();

        int[][] stickers = new int[N][2];

        for (int i = 0; i < N; i++) {
            stickers[i][0] = scan.nextInt();
            stickers[i][1] = scan.nextInt();
        }

        int maxArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 스티커 i와 j의 가능한 두 가지 회전 상태를 확인
                for (int[] sticker1 : getRotations(stickers[i])) {
                    for (int[] sticker2 : getRotations(stickers[j])) {
                        // 가로로 배치
                        if (sticker1[0] + sticker2[0] <= W && Math.max(sticker1[1], sticker2[1]) <= H) {
                            maxArea = Math.max(maxArea, sticker1[0] * sticker1[1] + sticker2[0] * sticker2[1]);
                        }
                        // 세로로 배치
                        if (sticker1[1] + sticker2[1] <= H && Math.max(sticker1[0], sticker2[0]) <= W) {
                            maxArea = Math.max(maxArea, sticker1[0] * sticker1[1] + sticker2[0] * sticker2[1]);
                        }
                    }
                }
            }
        }


        System.out.println(maxArea);

        scan.close();
    }


    public static int[][] getRotations(int[] sticker) {
        return new int[][] {
                {sticker[0], sticker[1]},
                {sticker[1], sticker[0]}
        };
    }
}
