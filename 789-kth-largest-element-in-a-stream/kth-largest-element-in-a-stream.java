class KthLargest {
    int num;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        num = k;
        pq = new PriorityQueue<>(k);
        
        for (int el : nums) {
            pq.add(el);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > num) {
            pq.poll();
        }
        return pq.peek();
    }
}
