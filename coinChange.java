class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)return 0;
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++)dp[i] = amount+1;
        for(int i=1;i<=amount;i++){
            for(int coin: coins){
                if(coin <= i)dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }
        return dp[amount] == (amount+1)?-1:dp[amount];
    }
}