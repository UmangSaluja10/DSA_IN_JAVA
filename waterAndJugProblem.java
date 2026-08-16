class Solution {
    public static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(target==0)return true;
        if(target>x+y)return false;
        if(target%gcd(x,y)==0)return true;
        return false;
    }
}