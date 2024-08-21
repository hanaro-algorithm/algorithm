import java.io.*;
import java.util.*;

class Main {
    static Set<Integer> set = new HashSet<>();
    static int[] arr = new int[]{1, 5, 10, 50};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bt(0, 0, 0);
        System.out.println(set.size());
    }

    static void bt(int depth, int idx, int sum) {
        if (depth == N) { // 현재까지 선택한 로마 개수(depth) == N
            set.add(sum); // 중복X
            return;
        }

        for (int i = idx; i < 4; i++) {
            bt(depth + 1, i, sum + arr[i]); // 로마 하나 더 선택
        }
    }
}
