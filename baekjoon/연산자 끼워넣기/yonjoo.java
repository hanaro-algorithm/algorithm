import java.io.*;
import java.util.*;

public class Main {

    static int[] numbers;
    static int[] operands;
    static int[] out;
    static int[] visited;

    //static List<Integer> list; // 비효율적, 몇 개까지 경우의 수가 나올지 모르기 때문
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    private void permutation(int depth){
        if(depth == 0){
            int sum = numbers[0];
            for(int i = 0; i < out.length; i++){
                if(out[i] == 0){ // plus
                    sum += numbers[i + 1];
                }else if(out[i] == 1){ //minus
                    sum -= numbers[i + 1];
                }
                else if(out[i] == 2){ // multiply
                    sum *= numbers[i + 1];
                }
                else if (out[i] == 3){ // divide
                    sum /= numbers[i + 1];
                }
            }

            list.add(sum);
            return;
        }

        for(int i = 0; i < operands.length; i++){
            if(visited[i] != 0){
                visited[i] -= 1;
                out[depth-1] = i;
                permutation(depth-1);
                visited[i] += 1;
            }
        }

    }
    private void solution(int N){

        //순열 문제
        permutation(N - 1);
        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operands = new int[4];
        out = new int[N-1];
        list = new ArrayList<>();
        visited = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            operands[i++] = Integer.parseInt(st.nextToken());
        }

        visited = Arrays.copyOf(operands, operands.length);
        T.solution(N);

    }

}
