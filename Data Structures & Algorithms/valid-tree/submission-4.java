class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        // 3. Process every edge to build the graph
        for(int[] edge: edges){
            // If union() returns false, it means we found a cycle!
            if(!union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }
    // FIND: recursively climb the chain of command to find the ultimate boss
    private int findNode(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = findNode(parent[node]);
        return parent[node];
    }
    // UNION: merge two nodes into the same family
    private boolean union(int node1, int node2){
        int root1 = findNode(node1);
        int root2 = findNode(node2);
        // CYCLE DETECTED: They already have the same boss!
        if(root1 == root2){
            return false;
        }
        parent[root1] = root2;
        return true;
    }


}
