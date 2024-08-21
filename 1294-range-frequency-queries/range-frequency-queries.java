class RangeFreqQuery {
    Map<Integer, Integer> tree[];
    int n;
    int nums[];

    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        nums = arr;
        tree = new HashMap[n * 4];
        for (int i = 0; i < n * 4; i++) {
            tree[i] = new HashMap<>();
        }
        buildtree(0, 0, n - 1);
    }

    public int query(int left, int right, int value) {
        return findintree(0, 0, n - 1, left, right, value);
    }

    public void buildtree(int i, int l, int r) {
        if (l == r) {
            tree[i] = new HashMap<Integer, Integer>();
            tree[i].put(nums[l], 1);
            return;
        }
        int mid = l + (r - l) / 2;
        buildtree(2 * i + 1, l, mid);
        buildtree(2 * i + 2, mid + 1, r);
        tree[2 * i + 1].forEach((k, v) -> {
            tree[i].put(k,v+ tree[i].getOrDefault(k, 0));
        });
        tree[2 * i + 2].forEach((k, v) -> {
            tree[i].put(k,v+ tree[i].getOrDefault(k, 0));
        });
    }

    public int findintree(int i, int l, int r, int st, int end, int val) {
        if (l > end || r < st)
            return 0;
        if (l >= st && r <= end)
            return tree[i].getOrDefault(val, 0);
        int mid = l + (r - l) / 2;
        return findintree(2 * i + 1, l, mid, st, end, val) + findintree(2 * i + 2, mid + 1, r, st, end, val);
    }

}