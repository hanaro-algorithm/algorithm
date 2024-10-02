import java.io.*;
import java.util.*;

public class Main {

    private int solution(int N, int M) {
        // 중복 조합 공식: H(N, M) = C(N + M - 1, M)
        return comb(N + M - 1, M);
    }

    int comb(int n, int r) {
        if (r == 0 || n == r) {
            return 1; 
        }
        return comb(n - 1, r - 1) + comb(n - 1, r); 
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  
        int M = Integer.parseInt(br.readLine());  

        System.out.println(T.solution(N, M));  
    }
}
