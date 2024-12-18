import java.io.*;
import java.util.*;
public class Main{
    static int N,k,arr[];
    static HashSet<String> card = new HashSet<>();
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());
        arr=new int[N];
        visit=new boolean[N];


        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        back(0,"");
        System.out.println(card.size());

    }

    public static void back(int depth, String a){
        if(depth==k){
            card.add(a);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i]=true;
                back(depth+1,a+arr[i]);
                visit[i]=false;
            }
        }
    }
}