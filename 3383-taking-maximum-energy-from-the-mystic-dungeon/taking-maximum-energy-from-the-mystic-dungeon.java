class Solution {
    public int maximumEnergy(int[] energy, int k) {
        for(int i=k;i<energy.length;i++){
            energy[i]=Math.max(energy[i],energy[i]+energy[i-k]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=energy.length-k;i<energy.length;i++){
            max=Math.max(max,energy[i]);
        }
        return max;
    }
}