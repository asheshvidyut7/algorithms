package Graph.Algorithms;

import java.util.Arrays;

/*
    Connected Component in Undirected Graph with Union Find Algorithm
 */

public class ConnectedComponentsUnionFind{
    public int n;
    public int id[];
    public int weight[];
    public ConnectedComponentsUnionFind(int n){
        this.n = n;
        this.id = new int[n];
        this.weight = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
        Arrays.fill(weight, 1);
    }
    public boolean connected(int p, int q){
        if(find(q) == find(p))
            return true;
        return false;
    }
    public int find(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }
    public void union(int i, int j){
        int id_i = find(i);
        int id_j = find(j);
        if(id_i == id_j)
            return ;
        if(weight[id_i] > weight[id_j]){
            id[id_j] = id_i;
            weight[id_i] += weight[id_j];
        }
        else{
            id[id_i] = id_j;
            weight[id_j] += weight[id_i];
        }
    }
    public static void main(String[] args) {
        ConnectedComponentsUnionFind ufob = new ConnectedComponentsUnionFind(10);
        ufob.union(2,4);
        ufob.union(3,4);
        ufob.union(5,4);
        ufob.union(1,6);
        ufob.union(2,7);
        for(int i = 0; i < 10; i++){
            System.out.println("i = "+i+" is in group with id= "+ufob.find(i));
        }
    }
}

