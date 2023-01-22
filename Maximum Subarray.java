class Solution {
    public int maxSubArray(int[] nums) {
        int maxSumSoFar = nums[0], curMaxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            curMaxSum = Math.max(nums[i], curMaxSum + nums[i]);
            maxSumSoFar = Math.max(curMaxSum, maxSumSoFar);
        }
        return maxSumSoFar;
    }
}

/**

-2,1,-3,4,-1,2,1,-5,4
-2,1,-2,4,3,5,6,1,4
Max(premaxsum + num, num)

 */