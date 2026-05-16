class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int component = n;
        for(int[] edge: edges){
            if(union(edge[0], edge[1])){
                component--;
            }
        }
        return component;
    }

    private int find(int node){
        if(parent[node]==node){
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }

    private boolean union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1==root2){
            return false;
        }
        parent[root1] = root2;
        return true;
    }
}
