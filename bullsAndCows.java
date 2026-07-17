class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bulls=0, cows=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                if(count[secret.charAt(i)-'0']<0)cows++;
                if(count[guess.charAt(i)-'0']>0)cows++;
                count[secret.charAt(i)-'0']++;
                count[guess.charAt(i)-'0']--;
            }
        }
        StringBuilder str = new StringBuilder();
        str.append(bulls).append('A').append(cows).append('B');
        return str.toString();
    }
}