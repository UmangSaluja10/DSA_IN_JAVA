class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i=1;i<n;i++){
            long nextUgly = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                long product = (long)primes[j]*ugly[index[j]];
                nextUgly = Math.min(nextUgly,product);
            }
            for(int j=0;j<primes.length;j++){
                long product =(long) primes[j]*ugly[index[j]]; 
                if(product == nextUgly){
                    index[j]++;
                }
            }
            ugly[i] = (int)nextUgly;
        }
        return ugly[n-1];
    }
}