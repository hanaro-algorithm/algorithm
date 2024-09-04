import java.io.*;

class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new long[101];

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(P(N));
        }
    }
    static long P(int n){
        if(n == 1 || n == 2 || n == 3)
            return 1;
        if(dp[n] > 0)
            return dp[n];
        return dp[n] = P(n - 3) + P(n - 2);
    }

}