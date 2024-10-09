import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 일단 입력 받고

        if(str.contains("::")){
            str = str.replace("::", ":zero:");  // 0으로만 된 애들 처리
        }
        String[] split = str.split(":");    // : 를 기준으로 분리

        ArrayList<String> input = new ArrayList<>();    // 분리한 ip 주소를 담을
        ArrayList<String> answer = new ArrayList<>();   // 처리한 문자열

        for(int i = 0; i < split.length; i++){
            input.add(split[i]);                        // input 에 담아주고
        }
        for(int i = 0; i < input.size(); i++){
            String tmp = input.get(i);                  // 하나씩 봐줄건데,
            if(tmp.isEmpty()){                          // 비어있으면 continue, 맨 앞이 :: 이었다면 분리할 때 공백
                continue;
            }
            while(tmp.length() < 4){                    // 4자리가 안 되면 앞에 0 생략된만큼 붙여주고
                tmp = "0" + tmp;
            }
            answer.add(tmp);    // 처리 목록에 추가하면서 끝까지 봐준다
        }

        String[] ip = new String[8];            // 진짜 정답을 담을 배열 ip
        int zeroCnt = 8 - answer.size() + 1;    // 0000으로 바꿔야 할 개수(공백 or 생략)
        int idx = 0;

        for(int i = 0; i < answer.size(); i++){
            if(answer.get(i).equals("zero")){   // 만약 answer 중에 zero 가 있으면,
                while (zeroCnt-- > 0){
                    ip[idx] = "0000";           // 해당 인덱스를 0000으로 바꿔주고 다음으로 넘기기
                    idx++;
                }
            } else {
                ip[idx] = answer.get(i);        // 없으면 ip의 해당 idx 에 answer 의 i번째 값 넣어주고
                idx++;                          // 다음으로 넘기기
            }
        }

        for(int i = 0; i < 7; i++){             // 출력 형식에 맞춰서 출력
            bw.write(ip[i] + ":");
        }
        bw.write(ip[7] + "\n");

        bw.flush();
        bw.close();
    }
}