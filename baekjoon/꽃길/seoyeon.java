import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int[] dRow = {-1, 1, 0, 0}; // 상하좌우
    static int[] dCol = { 0, 0,-1, 1};
    public static void backtracking(int N, int[][] map, boolean[][] isSelected, int sum, int count) {
        // 꽃을 3개 심으면 return;
        if(count == 3) {
            result = Math.min(result, sum);
            return;
        }
        // 가장자리는 꽃을 심지 않는다.
        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(possible(i, j, isSelected)) { // 상하좌우 꽃심기가 가능하다면
                    // 꽃을 심고 비용을 더해준다.
                    isSelected[i][j] = true;
                    sum += map[i][j];
                    // 상하좌우 비용
                    for (int index = 0; index < 4; index++) {
                        int next_Row = i + dRow[index];
                        int next_Col = j + dCol[index];
                        isSelected[next_Row][next_Col] = true;
                        sum += map[next_Row][next_Col];
                    }
                    backtracking(N, map, isSelected, sum, count+1);
                    isSelected[i][j] = false;
                    sum -= map[i][j];
                    // 상하좌우 비용
                    for (int index = 0; index < 4; index++) {
                        int next_Row = i + dRow[index];
                        int next_Col = j + dCol[index];
                        isSelected[next_Row][next_Col] = false;
                        sum -= map[next_Row][next_Col];
                    }
                }
            }
        }
    }
    public static boolean possible(int row, int col, boolean[][] isSelected) {
        // 상하좌우 범위에 이미 꽃이 심어져있다면 false
        for (int index = 0; index < 4; index++) {
            int next_Row = row + dRow[index];
            int next_Col = col + dCol[index];
            if(isSelected[next_Row][next_Col] == true)  // 사용중인지만 판단
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // 화단의 한 변의 길이
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] isSelected = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(N, map, isSelected, 0, 0);
        System.out.println(result);
        br.close();
    }
}