import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static List<String> list;
    static boolean[] visited;
    static String[] out;
    static String[] words;

    private void DFS(int depth, int n){
        if(depth == n){
            Set<String> set = new HashSet<>(List.of(words));
            for(String s : out){
                set.remove(s);
            }

            for(int i = 0; i < 3; i++){
                String target = "" + out[0].charAt(i) + out[1].charAt(i) + out[2].charAt(i);
                if(set.contains(target)){
                    set.remove(target);
                }
            }
            if(set.isEmpty()){
                for(String si : out){
                    System.out.println(si);
                }
                System.exit(0);
            }

            return;
        }

        for(int i = 0; i < 6; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = words[i];
                DFS(depth + 1, n);
                visited[i] = false;
            }
        }
    }

    private void solution(){
        DFS(0, 3);
        System.out.println(0);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        words = new String[6];

        for(int i = 0; i < 6; i++){
            words[i] = br.readLine();
        }

        out = new String[3];
        visited = new boolean[6];

        Arrays.sort(words);

        T.solution();



    }
}