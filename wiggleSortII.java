class Solution {
   public void merge(int[] nums, int lb, int mid, int ub) {
        int n1 = mid - lb + 1;
        int n2 = ub - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; i++) l[i] = nums[lb + i];
        for (int j = 0; j < n2; j++) r[j] = nums[mid + 1 + j];

        int i = 0, j = 0, k = lb;

        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }

        while (i < n1) nums[k++] = l[i++];
        while (j < n2) nums[k++] = r[j++];
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
    public void wiggleSort(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        int mid = (nums.length+1)/2;
        int[] res = new int[nums.length];
        int i = mid-1;
        int j = nums.length-1;
        int x=0;
        while(x<res.length){
            if(x%2==0)res[x] = nums[i--];
            if(x%2!=0)res[x] = nums[j--];
            x++;
        }
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}