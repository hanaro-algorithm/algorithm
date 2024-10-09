import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static String a, b, c;
    static int A, B, C;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = st.nextToken();
        c = "";

        A = Integer.parseInt(a);
        B = Integer.parseInt(b);
        C = -1;

        visited = new boolean[a.length()];
        dfs();
        System.out.println(C);
    }
    private static void dfs(){
        if(c.length() == a.length()){
            if(Integer.parseInt(c) < B){
                C = Math.max(C, Integer.parseInt(c));
            }
            return;
        }
        for(int i = 0; i < a.length(); i++){
            if((c.isEmpty() && a.charAt(i) == '0') || visited[i]){
                continue;
            }
            visited[i] = true;
            c += a.charAt(i);
            dfs();
            visited[i] = false;
            c = c.substring(0, c.length() - 1);
        }
    }
}