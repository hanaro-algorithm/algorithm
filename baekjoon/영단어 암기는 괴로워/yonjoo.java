import java.io.*;
import java.util.*;


/*
    Map.Entry<key, val> map 에서 map.getValue() 걸리는 시간 보다
    map.get(key) 이게 훨씬 오래 걸림
 
    전자는 그냥 객체 탐색이고, 후자는 map 에서 get 가져오는 거라서
 */


public class Main {

    class Word{
        String word;
        int cnt;

        Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }

    private String[] solution4(int N, int M, String[] words){

        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Comparator
                .comparing((Map.Entry<String, Integer> entry ) -> -entry.getValue())
                .thenComparing((Map.Entry<String, Integer> entry) -> -entry.getKey().length())
                .thenComparing((Map.Entry<String, Integer> entry) -> entry.getKey())
        );

        String[] ans = new String[entries.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = entries.get(i).getKey();
        }
        return ans;

    }

    private String[] solution3(int N, int M, String[] words){

        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Word> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(new Word(key, map.get(key)));
        }

        list.sort(Comparator
                .comparing((Word word) -> -word.cnt)
                .thenComparing((Word word) -> -word.word.length())
                .thenComparing((Word w) -> w.word)
        );

        String[] ans = new String[list.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = list.get(i).word;
        }
        return ans;

    }

    private String[] solution2(int N, int M, String[] words){

        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            if(word.length() >= M){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator
                .comparing((String word) -> -map.get(word)) //get 엄청 오래 걸림, 시간초과 뜸
                .thenComparing((String word) -> -word.length()) //내림차순 정렬을 이렇게도 할 수 있음
                .thenComparing(String::compareTo)
        );

        String[] ans = keys.toArray(new String[0]);
        return ans;

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String input = "";
        String[] words = new String[N];
        for(int i= 0; i < N; i++){
            input = br.readLine();
            words[i] = input;
        }

        StringBuilder sb = new StringBuilder();
        String[] answer = T.solution4(N, M, words);
        for(String str : answer){
            sb.append(str + "\n");
        }

        System.out.println(sb.toString());
    }
}
