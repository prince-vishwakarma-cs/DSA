class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            else return a[0]-b[0];
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
        }
        long ans=0;
        Set<Integer> set=new HashSet<>();
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && set.contains(pq.peek()[1])) pq.poll();
            if(!pq.isEmpty()){
                int[] top=pq.poll();
                set.add(top[1]+1);
                set.add(top[1]-1);
                set.add(top[1]);
                ans+=top[0];
            }
        }
        return ans;
    }
}