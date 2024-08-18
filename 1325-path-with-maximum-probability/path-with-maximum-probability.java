class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        ArrayList<ArrayList<double[]>> lt=new ArrayList<>();
        for(int i=0;i<n;i++){
            lt.add(new ArrayList<>());
        }
        int k=0;
        for(int[] edge:edges){
            lt.get(edge[0]).add(new double[]{succProb[k],edge[1]});
            lt.get(edge[1]).add(new double[]{succProb[k],edge[0]});
            k++;
        }
        double[] ans=new double[n];
        ans[start_node] = 1.0;
        pq.add(new double[]{1.0,start_node});
        while(!pq.isEmpty()){
            double[] top=pq.poll();
            int node=(int)top[1];
            double d=top[0];
            if(node==end_node) return d;
            for (double[] neighbor : lt.get(node)) {
                int neighbourNode =(int) neighbor[1];
                double dist = neighbor[0];
                
                if (ans[neighbourNode] < d * dist) {
                    ans[neighbourNode] = d * dist;
                    pq.add(new double[]{ans[neighbourNode], neighbourNode});
                }
            }
        }
        return 0.0;
    }
}

