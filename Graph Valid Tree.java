public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
    	if (edges == null || edges.length == 0) {
    		return n == 1;
    	}
    	int[] root = new int[n];
    	for (int i = 0; i < n; ++i) {
    		root[i] = i;
    	}
    	for (int i = 0; i < edges.length; ++i) {
    		int u = edges[i][0];
    		int v = edges[i][1];
    		if (find(root, u) != find(root, v)) {
    			union(root, edges[i][0], edges[i][1]);
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
    
    private static void union(int[] root, int u, int v) {
    	int uRoot = find(root, u);
    	int vRoot = find(root, v);
    	if (uRoot != vRoot) {
    		root[Math.min(uRoot, vRoot)] = Math.max(uRoot, vRoot);
    	}
    }
    
    private static int find(int[] root, int label) {
    	if (root[label] != label) {
    		root[label] = find(root, root[label]);
    	}
    	return root[label];
    }
}
