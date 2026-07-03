class Solution {
    public static int robLinear(int[] nums, int start, int end){
        int prev1 = 0,prev2 = 0;
        for(int i=start;i<=end;i++){
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int case1 = robLinear(nums,0, nums.length-2);
        int case2 = robLinear(nums,1, nums.length-1);
        return Math.max(case1, case2);
    }
}