class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] parts = preorder.split(",");
        int slots = 1;
        for(int i=0;i<parts.length;i++){
            slots--;
            if(slots<0)return false;
            if(!parts[i].equals("#"))slots+=2;
        }
        return slots==0;
    }
}