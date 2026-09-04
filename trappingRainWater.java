class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pMax = new int[height.length];
        int[] sMax = new int[height.length];
        pMax[0] = height[0];
        sMax[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            pMax[i] = Math.max(pMax[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            sMax[i] = Math.max(sMax[i+1],height[i]);
        }
        int amount=0;
        for(int i=0;i<n;i++){
            int current = height[i];
            int min = Math.min(pMax[i],sMax[i]);
            if(current<min){
                amount+=min-current;
            }
        }
        return amount;
    }
}