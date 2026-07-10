class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        int diffBit = xor & (-1*xor);
        int num1 = 0;
        int num2 = 0;
        for(int x: nums){
            if((x & diffBit) != 0){
                num1 = num1 ^ x;
            }else{
                num2 = num2 ^ x;
            }
        }
        int[] arr = new int[2];
        arr[0] = num1;
        arr[1] = num2;
        return arr;
    }
}