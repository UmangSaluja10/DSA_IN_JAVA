class Solution {
    public static long BitMap(String s) {
        long result = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result |= (1L << (c - 'a'));
            }
        }
        return result;
    }
    public int maxProduct(String[] words) {
        long[] mask = new long[words.length];
        int[] len = new int[words.length];
        int max = 0;
        for(int i=0;i<words.length;i++){
            mask[i] = BitMap(words[i]);
            len[i] = words[i].length();
        }
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i] & mask[j]) == 0){
                    if(max<len[i]*len[j]){
                        max = len[i]*len[j];
                    }
                }
            }
        }
        return max;
    }
}