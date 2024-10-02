import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //중복허용조합 nHr = n+r-1Cr
        //r개의 공 나열과 n-1개의 막대로 공의 종류를 구분한다고 생각

        //nHm이지만 무조건 1개 이상 뽑아야함 -> nHm-n
        //n+m-n-1Cm-n = m-1Cm-n
        System.out.println(comb(M - 1, M - N));

    }

    static int comb(int n, int r){
        if(n == r || r == 0)
            return 1;
        //nCr = n-1Cr-1 + n-1Cr
        return comb(n - 1, r - 1) + comb(n - 1, r);
    }

}