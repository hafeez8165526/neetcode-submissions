class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        int index=0;
        List<Integer>[] dp=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        for(int i=nums.length;i>=0;i--) dp[i]=new ArrayList<>();
        for(int key:map.keySet()){
            dp[map.get(key)].add(key);
        }
        for(int i=nums.length;i>=0;i--){
            for(int num:dp[i]){
                res[index++]=num;
                if(index>=k) return res;
            }
        }
        return new int[]{};
    }
}
