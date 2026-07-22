class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer>[] graph = new ArrayList[n];
        int[] degree = new int[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }
        int remainingNodes = n;
        while(remainingNodes>2){
            int size = q.size();
            remainingNodes -= size;
            for(int i=0;i<size;i++){
                int leaf = q.poll();
                for(Integer x : graph[leaf]){
                    degree[x]--;
                    if(degree[x] == 1)q.add(x);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll());
        } 
        return list;
    }
}