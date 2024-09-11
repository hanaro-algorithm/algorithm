import java.io.*;
import java.util.*;

public class Main {

    static int[] count = new int[3];

    static int[][] arr;
    void solution(int x, int y, int width){
        int number = arr[y][x];
        if(check(x, y, width, number)){
            count[number + 1] += 1; //오.. 어차피 최소값이 -1이니까 index값 +1 시켜서 값 증가
            return;
        }

        int newWidth = width/3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                solution(x +  i * newWidth , y + j * newWidth, newWidth);
            }
        }

    }

    boolean check(int x, int y, int width, int number){
        for(int i = x; i < x + width; i++){
            for(int j = y; j < y + width; j++){
                if(arr[j][i] != number){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] in = br.readLine().split(" ");
            for(int j = 0; j < in.length; j++){
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }
        T.solution(0,0,N);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
}
