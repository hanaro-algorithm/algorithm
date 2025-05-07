import java.util.*;
import java.io.*;

public class BOJ_G5_20055_컨베이어벨트위의로봇 {
    static int N, K, ans;
    static int [] A;
    static boolean [] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2*N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        simul();

        System.out.println(ans);

    }

    private static void simul() {

        while (checkHP()) {
            int tmp = A[A.length-1];
            
            for (int i = A.length-1; i > 0; i--) {
                A[i] = A[i-1];
            }
            
            A[0] = tmp;

            for (int i = N-1; i > 0; i--) {
                robot[i] = robot[i-1];
            }
            
            robot[0] = false;
            robot[N-1] = false;

            for (int i = N-1; i > 0; i--) {
                if (robot[i-1] && !robot[i] && A[i] >= 1) {
                    robot[i-1] = false;
                    robot[i] = true;
                    A[i]--;
                }
            }

            if (A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }

            ans++;
        }
    }

    private static boolean checkHP() {
        int cnt = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) cnt++;
        }
        
        return cnt >= K ? false : true;
    }

}