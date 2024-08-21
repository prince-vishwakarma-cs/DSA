class NumArray {
    int tree[];
    int n;
    int arr[];

    public NumArray(int[] nums) {
        n=nums.length;
        arr=nums;
        tree=new int[n*4];
        buildtree(0,0,n-1,nums);
    }
    
    public int sumRange(int left, int right) {
        return findintree(0,0,n-1,left,right,arr);
    }

    public void buildtree(int i,int l,int r,int[] num){
        if(l==r){
            tree[i]=num[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildtree(2*i+1,l,mid,num);
        buildtree(2*i+2,mid+1,r,num);
        tree[i]=tree[2*i+1]+tree[2*i+2];
    }

    public int findintree(int i,int l,int r,int st,int end,int[] num){
        if(l>end || r<st) return 0;
        if(l>=st && r<=end) return tree[i];
        int mid=l+(r-l)/2;
        return findintree(2*i+1,l,mid,st,end,num) + findintree(2*i+2,mid+1,r,st,end,num);
    }
}