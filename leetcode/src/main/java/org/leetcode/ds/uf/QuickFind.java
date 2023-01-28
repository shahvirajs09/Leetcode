package org.leetcode.ds.uf;

public class QuickFind implements UF{
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components
    public QuickFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }



    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if(pid == qid) return;
        for (int i=0; i<id.length; i++)
            if(id[i]==pid) id[i]=qid;
            count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p]==id[q];
    }

    @Override
    public int count() {
        return count;
    }
    public static void main(String[] args) {
        int n = 10;
        QuickFind uf = new QuickFind(n);
        uf.union(6,5);
        uf.union(5,0);
        uf.union(0,1);
        uf.union(2,1);
        uf.union(7,1);
        uf.union(4,3);
        uf.union(3,8);
        uf.union(9,8);
        System.out.println("Is 7 and 3 connected? "+uf.connected(7,3));
        System.out.println("Is 2 and 7 connected? "+uf.connected(2,7));
    }
}
