import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int rowCnt = 0;
        int colCnt= 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i+1 < n) {
                    if(arr[i][j] == '.' && arr[i+1][j] == '.' && (i + 2 >= n || arr[i+2][j] =='X')) {
                        colCnt++;
                    }
                }
                if(j+1 < n) {
                    if(arr[i][j] == '.' && arr[i][j+1] == '.' && (j + 2 >= n || arr[i][j+2] =='X')) {
                        rowCnt++;
                    }
                }
            }
        }

        System.out.println(rowCnt + " " + colCnt);




    }
}