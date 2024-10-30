import java.util.*;
import java.io.*;

class Main {
    static List<String> ans = new ArrayList<>();
    static String[] word = new String[6];
    static boolean[] visit = new boolean[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 6; i++) {
            word[i] = br.readLine();
        }
        dfs(0, "");
        Collections.sort(ans);
        if(ans.isEmpty())
            System.out.println(0);
        else{
            for(String s : ans.get(0).split(" "))
                System.out.println(s);
        }
    }

    static void dfs(int dep, String sum) {
        if (dep == 3) { // 3 row
            int cnt = 0;
            boolean[] colv = visit.clone();
            String[] rows = sum.trim().split(" "); // 가로 단어를 배열로 나눔
            String[] cols = new String[3]; // 세로 단어를 저장할 배열

            for (int i = 0; i < 3; i++) {
                cols[i] = "" + rows[0].charAt(i) + rows[1].charAt(i) + rows[2].charAt(i); // 세로 단어 조합
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    if (colv[k]) continue;

                    if (cols[j].equals(word[k])) {
                        cnt++;
                        colv[k] = true; // 방문 표시
                        break;
                    }
                }
            }

            if (cnt == 3) {
                ans.add(sum.trim());
            }
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(dep + 1, sum + " " + word[i]);
            visit[i] = false;
        }
    }
}
