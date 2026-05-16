class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent = new int[n+1];

        for(int i=0;i<n+1;i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            // Try to union the two nodes. 
            // If union() returns false, it means they already had the same root!
            // We found the cycle! Return this edge immediately.
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }

    private boolean union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        if(root1 == root2){
            return false;
        }
        parent[root1] = root2;
        return true;
    }
}
