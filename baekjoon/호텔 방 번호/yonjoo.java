import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt = 0;

            for (int i = n; i <= m; i++) {
                String str = String.valueOf(i);
                boolean[] flag = new boolean[10];
                int j = 0;
                for(; j < str.length(); j++){
                    int num = str.charAt(j) - '0';
                    if(!flag[num]){
                        flag[num] = true;
                    }else{
                        break;
                    }
                }

                if(j == str.length()) cnt++;
            }
            sb.append(cnt).append('\n');
//            System.out.println(cnt);
        }

        System.out.println(sb.toString());




    }
}