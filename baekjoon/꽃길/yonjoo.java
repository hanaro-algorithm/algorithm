import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] flag;
    static int N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int MIN = Integer.MAX_VALUE;

    // 꽃을 심을 수 있는지 확인하고 비용 계산
    int getCost(int x, int y) {
        int cost = arr[y][x];  // 중심의 비용
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || flag[ny][nx]) return Integer.MAX_VALUE;  // 범위를 벗어나거나 이미 꽃이 있는 경우
            cost += arr[ny][nx];  // 꽃잎의 비용을 더함
        }
        return cost;
    }

    void placeFlower(int x, int y, boolean state) {
        flag[y][x] = state;  // 중심을 방문 처리
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            flag[ny][nx] = state;  // 꽃잎을 방문 처리
        }
    }

    void solution(int L, int totalCost) {
        if (L == 3) {
            MIN = Math.min(MIN, totalCost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                int cost = getCost(j, i);  // 현재 위치에서 꽃을 심을 수 있는지 확인하고 비용 계산 (최대값이면 못 심음)
                if (cost != Integer.MAX_VALUE) {  // 꽃을 심을 수 있으면
                    placeFlower(j, i, true);  // 꽃을 심음
                    solution(L + 1, totalCost + cost);
                    placeFlower(j, i, false);  
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        flag = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        T.solution(0, 0);
        System.out.println(MIN);
    }
}
