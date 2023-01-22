class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        int counter = 0;
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(pre[1] > intervals[i][0]){
                //there is overlapping
                counter++;
                if(pre[1] > intervals[i][1]){
                    pre = intervals[i];
                }
            }else{
                pre = intervals[i];
            }
        }
        return counter;
    }
}
//[1,2],[2,3]