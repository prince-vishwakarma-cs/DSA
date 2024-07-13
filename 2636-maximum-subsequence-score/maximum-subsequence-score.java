class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] arr=new int[nums1.length][2];
        for(int i=0;i<arr.length;i++){
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }
        Arrays.sort(arr,(a,b)->(b[1]-a[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i][0];
            pq.add(arr[i][0]);
        }
        long ans=(long)sum*arr[k-1][1];
        long c=0;
        for(int i=k;i<arr.length;i++){
            if(arr[i][0]>pq.peek()){
                sum-=pq.poll();
                sum+=arr[i][0];
                pq.add(arr[i][0]);
                c=sum*arr[i][1];
                ans=Math.max(c,ans);
            }
        }
        return ans;
    }
}