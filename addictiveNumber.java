class Solution {
    public static String addString(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0'; 
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; 
                j--;
            }
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }
    public boolean isAdditiveNumber(String num) {
        for(int i=0;i<num.length()-2;i++){
            String a = num.substring(0,i+1);
            if(a.charAt(0)=='0' && a.length()>1)break;
            for(int j=i+1;j<num.length()-1;j++){
                String b = num.substring(i+1,j+1);
                if(b.charAt(0)=='0' && b.length()>1)break;
                int start = j+1;
                String x = a;
                String y = b;
                while(start<num.length()){
                    String sum = addString(x,y);
                    if(start + sum.length() <= num.length() && sum.equals(num.substring(start,start+sum.length()))){
                        start = start+sum.length();
                        x=y;
                        y=sum;
                    }
                    else{
                        break;
                    }
                }
                if(start == num.length()) return true;
            }
        }
        return false;
    }
}