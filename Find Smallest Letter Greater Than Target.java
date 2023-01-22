class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(letters[n - 1] <= target || target < letters[0]){
            return letters[0];
        }
        int L = 0, R = n - 1;
        while(L + 1 < R){
            int Mid = L + (R - L)/2;
            if(letters[Mid] <= target){
                L = Mid;
            }else{
                R = Mid;
            }
        }
        return letters[R];
    }
}