class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i < phone_book.length - 1; i++){
            int j = i + 1;
            String target = phone_book[i];
            for(; j < phone_book.length; j++ ){
                if(phone_book[j].contains(target)) return false;
            }
        }
        return true;
    }
}