class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int n:nums){
            pq.add((long)n);
        } 
        int s=0;
        while(pq.size()>1){
            Long min=pq.poll();
            if(min>=k) break;
            Long max=pq.poll();
            Long num=min*2+max;
            pq.add(num);
            s++;
        }
        return s;
    }
}