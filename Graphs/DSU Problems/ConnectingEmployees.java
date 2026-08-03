
class DSU1 {
    int n;
    int[] parent;
    int[] size;

    DSU1(int _n) {
        n = _n;
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int i) {
        if (i == parent[i]) return i;

        return parent[i] = findParent(parent[i]);
    }

    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }

        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class ConnectingEmployees {
    public static void main(String[] args) {
        int n = 3;
        int q = 3;

        DSU1 dsu = new DSU1(n + 1);

        System.out.println(dsu.size[dsu.findParent(1)]);

        dsu.unionBySize(2, 3);

        System.out.println(dsu.size[dsu.findParent(3)]);

    }
}