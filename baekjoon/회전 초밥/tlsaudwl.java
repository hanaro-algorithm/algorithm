import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] check = new int[d+1];

        for(int i=0;i<N;i++) A[i]=Integer.parseInt(br.readLine());

        int res=1;
        check[c]++;
        for(int i=0;i<k;i++) {
            if(check[A[i]]==0) res++;
            check[A[i]]++;
        }

        int cnt=res;
        for(int i=1;i<N;i++) {
            int pop = A[i-1];
            check[pop]--;
            if(check[pop]==0) cnt--;

            int add = A[(i+k-1)%N];
            if(check[add]==0) cnt++;
            check[add]++;

            res = Math.max(res,cnt);
        }

        System.out.println(res);
    }

}