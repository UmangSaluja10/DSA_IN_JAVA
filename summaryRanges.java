class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length==0)return list;
        int start = nums[0];
        int end = nums[nums.length-1];
        int i=1;
        while(i<nums.length){
            if(nums[i]-nums[i-1]==1){
                i++;
                continue;
            }else{
                StringBuilder str = new StringBuilder();
                if(start!=nums[i-1])str.append(start).append("->").append(nums[i-1]);
                else str.append(start);
                list.add(str.toString());
                start = nums[i];
                i++;
            }
        }
        if(start == nums[nums.length-1]){
                list.add(String.valueOf(start));
        }else{
            StringBuilder str = new StringBuilder();
            str.append(start).append("->").append(end);
            list.add(str.toString());
        }
        return list;
    }
}