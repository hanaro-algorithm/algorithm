//import java.io.*;
//import java.util.*;
//
//
//public class Main {
//    
//    public static void main(String[] args) throws IOException {
//        Main T = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int L = Integer.parseInt(st.nextToken());
//        int water[] = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<N; i++) {
//            water[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(water);
//        double left = water[0] - 0.5;
//        int cnt = 1;
//        for(int i=0; i<N; i++) {
//            if(left+L < water[i]) {
//                cnt++;
//                left = water[i] - 0.5;
//            }
//        }
//        System.out.println(cnt);
//    }
//}
