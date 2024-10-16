import java.util.*;
import java.io.*;

class Main {
    static int[] F;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = new int[N];
        for(int i = 0; i < N; i++)
            F[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(F);

        long cnt = 0;
        for(int i = 0; i < N; i++){
            cnt += bs(i) - i;
        }
        System.out.println(cnt);
    }
    static int bs(int s){
        int lt = s+1, rt = N-1, mid, max = s;
        while(lt<=rt){
            mid = (lt+rt)/2;
            if(F[s] < F[mid]*0.9)
                rt = mid-1;
            else if(F[s] >= F[mid]*0.9){ //기준점 기준 조건(0.9보단 큼)만족 최대 인덱스 구하기
                max = mid;
                lt = mid+1; //더 큰거 있나 찾아봄(존나 혹시 모름)
            }
        }
        return max;
    }
}