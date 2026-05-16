class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        Set<Integer> visited = new HashSet<>();
        int component =0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                component++;
                dfs(i, visited, graph);
            }
        }
        return component;
    }

    private void dfs(int node, Set<Integer> visited, List<List<Integer>> graph){
        visited.add(node);
        for(int neighbor: graph.get(node)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, visited, graph);
            }
        }
    }
}
