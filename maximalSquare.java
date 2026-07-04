class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
                    if(matrix[i][j]=='1')dp[i][j]=1;
                    else dp[i][j]=0;
                }else{
                    if(matrix[i][j]=='1'){
                        dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                    }
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        
        return max*max;
    }
}