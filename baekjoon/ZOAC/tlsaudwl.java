import java.io.*;

public class Main {
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        visited = new boolean[arr.length];

        solve(0, arr.length - 1);
    }

    static void solve(int start, int end) throws IOException {
        if (start > end) return;

        int minIdx = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }

        visited[minIdx] = true;
        printCurrent();

        // 왼쪽 부분 재귀 호출
        solve(minIdx + 1, end);
        // 오른쪽 부분 재귀 호출
        solve(start, minIdx - 1);
    }

    static void printCurrent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
