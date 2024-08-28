import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = new char[N];
        String str = br.readLine();

        for(int i = 0; i < N; i++){
            arr[i] = str.charAt(i);
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] == 'P'){ // 사람임
                for(int j = K; j >= -K; j--){
                    if(i - j >= 0 && i - j < N && arr[i - j] == 'H'){
                        cnt++;
                        arr[i - j] = 'C'; // Clear. 먹음
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}
