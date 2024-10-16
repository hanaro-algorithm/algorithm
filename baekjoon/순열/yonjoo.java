import java.io.*;
import java.util.*;

public class Main {


    static int cnt;
    private static void DFS(int depth, final String input, int index, boolean[] visited, StringBuilder sb){

        if(depth == input.length()){
            cnt++;
            if(cnt == index){
                String s = "";
                for(int i = 0; i < visited.length; i++){
                    if(visited[i]){
                        s += input.charAt(i);
                    }
                }
                sb.append(input + " " + index + " = " + s  + "\n");
            }

            return;
        }
        for(int i = 0; i < input.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(depth + 1, input, index,  visited, sb);
                visited[i] = false;
            }
        }
    }

    private static void solution(String input, int index, StringBuilder sb){
        boolean[] visited = new boolean[input.length()];

        DFS(0,input, index,  visited, sb);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = new String();
        while((input =  br.readLine()) != null && !input.isEmpty()){
            StringTokenizer st = new StringTokenizer(input);
            String str = st.nextToken();
            Integer index = Integer.parseInt(st.nextToken());

            int tmp = 1;
            for(int i = 2; i <= str.length(); i++){
                tmp = i * tmp;
            }
            if(tmp < index) {
                sb.append(str + " " + index + " = " + "No Permutation\n");
            }

            cnt = 0;
            T.solution(str, index, sb);
        }

        System.out.println(sb.toString());
    }
}
