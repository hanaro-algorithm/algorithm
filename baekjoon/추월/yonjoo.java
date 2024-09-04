import java.io.*;
import java.util.*;

public class Main {

    int solution(String[] arr1, String[] arr2){
        int answer = 0;

        for(int i = 0; i < arr2.length; i++){
            for(int j = 0; j < arr1.length; j++){
                if(!arr2[i].equals(arr1[j])) continue;

                if(i > j) {answer++; break;}
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr1 = new String[N];
        String[] arr2 = new String[N];
        for(int i = 0; i < N; i++){
            arr1[i] = br.readLine();
        }
        for(int i = 0; i < N; i++){
            arr2[i] = br.readLine();
        }
        System.out.println(T.solution(arr1, arr2));
    }
}
