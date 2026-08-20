class Solution {
    public int getSecondLargest(int[] arr) {
        Arrays.sort(arr);
        int secondMax = -1;
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=max && arr[i]>max){
                secondMax = max;
                max=arr[i];
            }
        }
        return secondMax;
    }
}