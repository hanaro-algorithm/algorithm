import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            if(br.readLine().matches("^[A-F]?A+F+C+[A-F]?$"))
                System.out.println("Infected!");
            else
                System.out.println("Good");
        }
    }
}