import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int cnt = 0;

        //찾는 글자크기 전까지 인덱스 안튀나오게
        for (int i = 0; i <= doc.length() - word.length(); i++) {
            boolean check = true;
            for (int j = 0; j < word.length(); j++) {
                if (doc.charAt(i + j) != word.charAt(j)) {
                    check = false;
                    break;
                }
            }
            //검색 단어 찾은경우
            if (check) {
                //찾은 단어는 스킵
                //i++ 처리되니까 -1
                i += word.length() - 1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}