class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false; // tree has n-1 edge
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
        boolean hasCycle = hasCycle(0, -1, visited, graph);

        if(hasCycle) return false;
        
        return visited.size()==n;
    }

    private boolean hasCycle(int node, int parent, Set<Integer> visited, List<List<Integer>> graph){
        visited.add(node);

        for(int neighbor: graph.get(node)){
            if(neighbor == parent) continue; //parent
            // Already visited -> cycle
            if(visited.contains(neighbor)) return true;
            
            if(hasCycle(neighbor, node, visited, graph)){
                return true;
            }
        }
        return false;
    }
}
