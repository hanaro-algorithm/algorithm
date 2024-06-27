import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int binarySearch (int[] list, int from, int to){
        int length = list.length;
        int start = 0;
        int end = length - 1;
        int mid;

        while(start <= end){
            mid = (start + end)/2;
            if(list[mid] < from){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        int minIndex = start;

        start = 0;
        end = length - 1;
        while(start <= end){
            mid = (start + end)/2;
            if(list[mid] > to){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        int maxIndex = end;

        return maxIndex - minIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] input = br.readLine().split(" ");
        Integer n = Integer.parseInt(input[0]);
        Integer m = Integer.parseInt(input[1]);


        String pointString = br.readLine();
//        List<Integer> points = Arrays.stream(pointString.split(" ")).map(o-> Integer.parseInt(o)).collect(Collectors.toList());
        int[] points = new int[n];

        points = Arrays.stream(pointString.split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < m; i++){
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = binarySearch(points, start, end) + 1;
            System.out.println(count);
        }


    }
}
