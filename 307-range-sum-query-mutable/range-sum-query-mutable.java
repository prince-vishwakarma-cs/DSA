class NumArray {
    int tree[];
    int arr[];
    int n;

    public NumArray(int[] nums) {
        n=nums.length;
        tree=new int[4*n];
        arr=nums;
        buildtree(0,0,n-1);
    }
    
    public void update(int index, int val) {
        updateintree(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return findintree(0,0,n-1,left,right);
    }
    public void buildtree(int i,int l,int r){
        if(l==r){
            tree[i]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildtree(2*i+1,l,mid);
        buildtree(2*i+2,mid+1,r);
        tree[i]=tree[2*i+1]+tree[2*i+2];
    }
    public int findintree(int i,int l,int r,int start,int end){
        if(l>end || r<start) return 0;
        else if(l>=start && r<=end) return tree[i];
        int mid=l+(r-l)/2;
        return findintree(2*i+1,l,mid,start,end)+findintree(2*i+2,mid+1,r,start,end);
    }
    public void updateintree(int i,int l,int r,int index,int val){
        if(l==r && l==index){
            arr[l]=val;
            tree[i]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(index<=mid) updateintree(2*i+1,l,mid,index,val);
        else updateintree(2*i+2,mid+1,r,index,val);
        tree[i]=tree[2*i+1]+tree[2*i+2];
    }
}