class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int widthA  = ax2 - ax1;
        int heightA = ay2 - ay1;
        int areaA   = widthA * heightA;
        int widthB  = bx2 - bx1;
        int heightB = by2 - by1;
        int areaB   = widthB * heightB;
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = 0;
        if(overlapWidth <= 0 || overlapHeight <= 0){
            overlapArea = 0;
        }
        else{
            overlapArea = overlapWidth*overlapHeight;
        }
        return areaA + areaB - overlapArea;
    }
}