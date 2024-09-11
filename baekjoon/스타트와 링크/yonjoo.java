import java.io.*;
import java.util.*;

public class Main {

    static int MIN = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] team; //팀 아직 배정 안 된 상태 : 0, 팀 A : -1, 팀 B : 1
    static int N;
    void solution(int member, int L){
        if(L == N/2){ // 다 나눠지면
            calcDiff();
            return;
        }

        for (int i = member; i < N; i++) {
            if (team[i] == 0) {  // 아직 팀에 배정되지 않았을 때
                team[i] = -1;  // 팀 A로 배정
                solution(i + 1, L + 1);
                team[i] = 1;  // 팀 B로 배정
                solution(i + 1, L + 1);
                team[i] = 0;  // 빼
            }
        }

    }

    void calcDiff() {
        int A = 0, B = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] == -1 && team[j] == -1) {
                    A += arr[i][j];  // 팀 A
                } else if (team[i] == 1 && team[j] == 1) {
                    B += arr[i][j];  // 팀 B
                }
            }
        }

        int diff = Math.abs(A - B);
        MIN = Math.min(MIN, diff);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        team = new int[N];
        for(int i = 0; i < N; i++){
            String[] in = br.readLine().split(" ");
            for(int j = 0; j < in.length; j++){
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }

        T.solution(0,0);
        System.out.println(MIN);
    }
}
