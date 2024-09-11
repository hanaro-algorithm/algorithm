private static int lowerBound(int[] arr, int key) {
    int lo = 0; 
    int hi = arr.length; 
  
    while (lo < hi) {
  
       int mid = (lo + hi) / 2; // 중간위치를 구한다.

       if (key <= arr[mid]) {
          hi = mid;
       }
  
       else {
          lo = mid + 1;
       }
  
    }
    return lo;
 }
  
 private static int upperBound(int[] arr, int key) {
    int lo = 0; 
    int hi = arr.length; 
  
    while (lo < hi) {
  
       int mid = (lo + hi) / 2; 

       if (key < arr[mid]) {
          hi = mid;
       }
       
       else {
          lo = mid + 1;
       }
    }
    return lo;
 }