import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public boolean binarySearch(int[] arr, int target){
        int lt = 0;
        int rt = arr.length-1;
        int mid;

        //!주의! 맨 끝 원소 포함해서 찾으려면 == 해야함
        while(lt <= rt){
            mid = (lt + rt)/2;
            if(arr[mid] == target) return true;

            if(arr[mid] < target) lt = mid + 1;
            else if(arr[mid] > target) rt = mid-1;
        }

        return false;
    }

   public int[] solution(final int[] cards, final int[] numbers){

       //sortedNumbers for binary-search
       int[] sortedNums = Arrays.copyOf(numbers, numbers.length);
       Arrays.sort(sortedNums);

       Map<Integer, Integer> map = new HashMap<>();

       //count numbers
       for(int card : cards){
           
           //이분탐색
           if(binarySearch(sortedNums, card)){
               map.put(card, map.getOrDefault(card, 0) + 1);
           }
       }

       //return result
       int[] ans = new int[numbers.length];
       for(int i = 0; i < ans.length; i++){
           ans[i] = map.getOrDefault(numbers[i], 0);
       }
       return ans;
   }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        //get cards
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }


        //get numbers
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[m];
        for(int i = 0; i < m; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        //main
//        System.out.println(T.solution(cards, numbers));
        int[] res = T.solution(cards, numbers);
        for(int num : res){
            sb.append(num + " ");
        }

        System.out.println(sb.toString());
    }
}
