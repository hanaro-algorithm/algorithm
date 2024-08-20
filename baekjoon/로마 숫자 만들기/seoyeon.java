import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static int[] visited=new int[10001]; // 수의 합의 중복을 체크하는 배열
    static int n,answer=0;
    static int[] arr= {1,5,10,50};
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        dfs(0,0,0);
        sb.append(answer);

        System.out.println(sb);
    }
    static void dfs(int depth, int start, int sum) {
        if(depth==n) {
            // 수의 합이 이전에 나온적 없는 수라면 count
            if(visited[sum]==0) {
                answer++;
                visited[sum]=1;
            }
            return;
        }

        // 수의 선택의 중복을 피하기 위해 start 부터 탐색 시작
        for(int i=start;i<4;i++) {
            dfs(depth+1,i,sum+arr[i]);
        }
    }
}