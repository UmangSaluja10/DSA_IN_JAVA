class Solution {
    public int maxProfit(int[] prices) {
        int[] hold = new int[prices.length+1];
        int[] sold = new int[prices.length+1];
        int[] rest = new int[prices.length+1];
        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;
        for(int i=0;i<prices.length;i++){
            hold[i+1] = Math.max(hold[i],rest[i]-prices[i]);
            sold[i+1] = hold[i] + prices[i];
            rest[i+1] = Math.max(rest[i],sold[i]);
        }
        return Math.max(sold[prices.length],rest[prices.length]);
    }
}