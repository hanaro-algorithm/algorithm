import java.util.*;
import java.io.*;

class Main{
    static boolean[] visit;
    static int A, B, length, max = -1;
    static String str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        length = str.length();
        A = Integer.parseInt(str);
        B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        visit = new boolean[length];
        bt(0, sb);
        System.out.println(max);
    }

    static void bt(int len, StringBuilder C){
        if (len == length) {
            int num = Integer.parseInt(C.toString());
            if(num < B && num > max)
                max = num;
            return;
        }
        for(int i = 0; i < length; i++){
            if (!visit[i]) {
                if(len == 0 && str.charAt(i) == '0')
                    continue;
                visit[i] = true;
                C.append(str.charAt(i));
                bt(len + 1, C);
                visit[i] = false;
                C.delete(C.length()-1, C.length());
            }
        }

    }
}
