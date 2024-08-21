import java.util.Scanner;

public class Main {

    static int list[] = {1, 5, 10, 50};
    static boolean visit[] = new boolean[1001];    // 방문 여부
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // n값
        scan.close();

        dfs(n, 0, 0);
        sb.append(answer);
        System.out.println(sb);
    }
    private static void dfs(int n, int idx, int sum){
        if (n == 0){
            if(!visit[sum]){
                answer++;
                visit[sum] = true;
            }
            return;
        }
        for (int i = idx; i < 4; i++){
            dfs(n-1, i, sum + list[i]);
        }
    }
}