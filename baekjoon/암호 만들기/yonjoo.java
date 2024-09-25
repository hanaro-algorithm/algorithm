import java.io.*;
import java.util.*;


public class Main {

    static int L, C;
    static char[] chars;
    static List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
    static boolean[] visited;

    private boolean isVowel(char c){
        if(vowels.contains(c)) return true;
        return false;
    }

    private void BFS(int depth, int index, int voCnt, int conCnt){
        if(depth == 0){
            if(voCnt >= 1 && conCnt >= 2){
                for(int i = 0; i < C; i++){
                    if(visited[i]){
                        System.out.print(chars[i]);
                    }
                }
                System.out.println();
            }
        }
        else{
            for(int i = index; i < C; i++){
                visited[i] = true;
                if(isVowel(chars[i])){
                    BFS(depth - 1, i + 1, voCnt + 1, conCnt);
                }else{
                    BFS(depth - 1, i + 1, voCnt, conCnt+1);
                }
                visited[i] = false;
            }
        }
    }
    private void solution(char[] alphs){
        BFS(L, 0, 0, 0);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];


        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());


        for(int i = 0; st.hasMoreTokens(); i++){
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        T.solution(chars);

    }
}
