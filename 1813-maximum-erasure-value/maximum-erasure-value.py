class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        n=len(nums)
        global_max=0
        curr_max=0
        st = set()
        j=0
        for i in range(n):
            while nums[i] in st:
                curr_max-=nums[j]
                st.discard(nums[j])
                j+=1
            curr_max+=nums[i]
            st.add(nums[i])
            global_max= max(curr_max,global_max)
        return global_max
            