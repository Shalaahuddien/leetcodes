class Solution {
    // int[] arr;
    Boolean[][] cache;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        // arr = nums;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        //we need even sum
        int half = sum / 2;
        cache = new Boolean[nums.length][half + 1];
        for(int row = 0; row < cache.length; row++){
            cache[row][0] = true;
        }
        for(int curSum = 1; curSum < cache[0].length; curSum++){
            if(curSum == nums[0]){
                cache[0][curSum] = true; 
            }else{
                cache[0][curSum] = false;
            }
        }
        for(int curNumIndex = 1; curNumIndex < cache.length; curNumIndex++){
            for(int curSum = 1; curSum < cache[0].length; curSum++){
                boolean take = false;
                int diff = curSum - nums[curNumIndex];
                if(diff >= 0){
                    take = cache[curNumIndex -1][diff];
                }
                boolean skip = cache[curNumIndex -1][curSum];
                cache[curNumIndex][curSum] = skip || take;
            }
        }
        return cache[nums.length -1][half];
        // return helper(half, 0);
    }
    // private boolean helper(int sum, int index){
    //     if(index >= arr.length || sum < 0) return false;
    //     if(sum == 0) return true;
    //     if(cache[index][sum]){
    //         return cache[index][sum];
    //     }
    //     boolean take = helper(sum - arr[index], index + 1);
    //     boolean skip = helper(sum, index + 1);
    //     cache[index][sum] = take || skip
    //     return take || skip;
    // }
}