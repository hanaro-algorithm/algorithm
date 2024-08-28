//import java.io.*;
//import java.util.*;
//
//
//public class Main {
//
//    static int N,K;
//    static char[] list;
//    static boolean[] ate;
//    
//
//    public static void main(String[] args) throws IOException {
//        Main T = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        String str = br.readLine();
//        list = new char[N];
//        ate = new boolean[N];
//        for(int i=0; i<N; i++){
//            list[i] = str.charAt(i);
//        }
//
//        int answer = 0;
//
//        for(int i=0; i<N; i++){
//            if(list[i]=='P') {
//                int startIndex = Math.max(i-K,0);
//                int endIndex = Math.min(i+K,N-1);
//                for(int j=startIndex; j<=endIndex; j++){
//                    if(list[j]=='H' && !ate[j]){
//                        ate[j] = true;
//                        answer++;
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(answer);
//    }
//}
