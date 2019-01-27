import java.util.HashSet;
import java.util.Set;
public class FriendCircles {

    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i

    /**
     *
     * @param M the adjacency matrix of friends
     * @return number of friend circles
     */
    public int findCircleNum(int[][] M) {
        // TODO: implement this method
        int size = M.length; 
        parent = new int[size]; 
        rank = new byte[size]; 
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        for (int j = 0; j < size; j++) {
            for (int k = j+1; k < size; k++ ) {
                if (M[j][k] == 1) {
                    union(j, k); 
                }
            }
        }
        Set<Integer> answer = new HashSet<Integer>(); 

        for (int i = 0; i < size; i++) {
            answer.add(find(i)); 
        }
        return answer.size();
    }


    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one site
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]]; //one line to improve 
            p = parent[p];
        }
        return p; 
    }


    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        // TODO: implement this method
        if (find(p) == find(q)) {
            return true;
        }
        else {
            return false; 
        }
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        // TODO: implement this method
        /*int i = find(p);
        int j = find(q);
        if (i != j) {
            parent[i] = parent[j];
        }*/
        int i = find(p);
        int j = find(q);
        if (i != j) {
            if (rank[j] > rank[i]) {
                parent[i] = j;
            }
            if (rank[j] < rank[i]){
                parent[j] = i;
            }
            if (rank[j] == rank[i]) {
                parent[j] = i;
                rank[i]++;
            }
        }
    }

    public static void main(String[] args) {

    }

}