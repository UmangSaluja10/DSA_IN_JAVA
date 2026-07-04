class Solution {
    public static void combination(int k, int n, int start, List<Integer> current, int currentsum, int currentsize, List<List<Integer>> res){
        if(currentsize>k)return;
        if(currentsum>n)return;
        if(currentsize==k && currentsum==n){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=9;i++){
            current.add(i);
            currentsum+=i;
            currentsize+=1;
            combination(k,n,i+1,current,currentsum,currentsize,res);
            current.remove(current.size()-1);
            currentsum-=i;
            currentsize--;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combination(k,n,1,new ArrayList<>(),0,0,res);
        return res;
    }
}