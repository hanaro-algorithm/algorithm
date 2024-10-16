import java.io.*;
import java.util.*;

public class Main {

    private String solution(String input){
        String answer = "";

        if(!input.matches("^[A-F]?(A+)(F+)(C+)[A-F]?$")){
            return "Good";
        }
        return "Infected!";
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; sb.append(T.solution(br.readLine())).append("\n"), i++){}

        System.out.println(sb.toString());

    }


}
