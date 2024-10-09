import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int lt = 0, rt = 5 * M, mid, ans = -1;

        while (lt <= rt) {
            mid = (lt+rt)/2;
            if(count(mid) == M){
                ans = mid;
                rt = mid-1;
            }
            else if(count(mid) < M)
                lt = mid + 1;
            else
                rt = mid - 1;
        }
        System.out.println(ans);
    }
    static int count(int n){
        int cnt = 0;
        for (int i = 5; i <= n; i *= 5) {
            cnt += n / i;
        }
        return cnt;
    }
}
