import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/13023
public class Main {

    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] flag = new boolean[N + 1];

        int cnt = 0;
        for(int i = 2; i <= N; i++){
            if(!flag[i]){
                int m = 2;
                for(int j = i; j <= N; j = i * (m++)){
                    if(!flag[j]){
                        flag[j] = true;
                        cnt++;
                        if(cnt == K){
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }

}
