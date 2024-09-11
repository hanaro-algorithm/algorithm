import java.io.*;
import java.util.*;

class Main {
    static int[][] A;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        map.put(-1, 0);
        map.put(0, 0);
        map.put(1, 0);
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }
        P(0, 0, N);
        System.out.println(map.get(-1));
        System.out.println(map.get(0));
        System.out.println(map.get(1));
    }

    static void P(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (A[r][c] != A[i][j]) {
                    int x = r;
                    for (int k = 0; k < 3; k++) {
                        int y = c;
                        for (int l = 0; l < 3; l++) {
                            P(x, y, n / 3);
                            y += n / 3;
                        }
                        x += n / 3;
                    }
                    return;
                }
            }
        }
        map.put(A[r][c], map.get(A[r][c]) + 1);

    }
}
