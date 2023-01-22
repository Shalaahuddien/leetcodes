class Solution {
    int[] arr;
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length == 0) return res;
        arr = nums;
        res[0] = findLeft(target);
        res[1] = findRight(target);
        return res;
    }
    private int findLeft(int target)
    {
        int L = 0, R = arr.length - 1;
        while(L + 1 < R)
        {
            int mid = L + (R - L)/2;
            if(arr[mid] < target)
            {
                L = mid;
            }else{
                R = mid;
            }
        }
        if(arr[L] == target) return L;
        if(arr[R] == target) return R;
        return -1;
    }
    private int findRight(int target)
    {
        int L = 0, R = arr.length - 1;
        while(L + 1 < R)
        {
            int mid = L + (R - L)/2;
            if(arr[mid] <= target)
            {
                L = mid;
            }else{
                R = mid;
            }
        }
        if(arr[R] == target) return R;
        if(arr[L] == target) return L;
        return -1;
    }
}

/**

5,7,7,8,8,10,8

3,3,3,3,3

 */