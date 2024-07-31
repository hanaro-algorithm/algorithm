import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //듣
        Set<String> n = new HashSet<>();
        //듣보
        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i < N; i++){
            n.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            //보
            String str = br.readLine();
            //듣에 보 있으면
            if(n.contains(str)){
                //듣보
                ans.add(str);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(String s : ans){
            System.out.println(s);
        }
    }
}