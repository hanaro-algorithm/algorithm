import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] in = new String[N];
        for(int i = 0; i < N; i++){
            in[i] = br.readLine();
        }

        Map<String, Integer> out = new HashMap<>();
        for(int i = 0; i < N; i++){
            out.put(br.readLine(), i);
        }

        int cnt = 0;
        for(int i = 1; i < N; i++){ // 1등은 추월 불가
            for(int j = 0; j < i; j++){
                if(out.get(in[j]) > out.get(in[i])){ // 드갈때 앞에 있던 놈이 나올때 뒤에 있다면
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
