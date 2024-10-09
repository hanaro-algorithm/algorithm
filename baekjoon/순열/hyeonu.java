import java.util.*;
import java.io.*;

class Main{
    static String str;
    static int n, cnt;
    static boolean[] visit;
    static boolean find;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            str = input.split(" ")[0];
            n = Integer.parseInt(input.split(" ")[1]);
            visit = new boolean[str.length()];
            cnt = 0;
            find = false;
            char[] arr = new char[str.length()];
            bt(0, arr);
            if (!find) {
                sb.append(str + " " + n + " = " + "No permutation");
            }
            System.out.println(sb);
            sb = new StringBuilder();
        }
    }
    static void bt(int len, char[] arr){
        if(len == str.length()){
            cnt++;
            if(cnt == n){
                find = true;
                sb.append(str + " " + n + " = ");
                for(char c : arr)
                    sb.append(c);
            }
            return;
        }

        for(int i = 0; i < str.length(); i++){
            if (!visit[i]) {
                visit[i] = true;
                arr[len] = str.charAt(i);
                bt(len+1, arr);
                visit[i] = false;
            }
        }
    }
}
