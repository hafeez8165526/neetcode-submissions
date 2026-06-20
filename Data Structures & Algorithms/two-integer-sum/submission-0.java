class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(int i=0;i<nums.length;i++){
            int x=target-nums[i];
            if(map.containsKey(x)){
                if(x==nums[i] && map.get(x).size()>1){
                    return new int[]{i,map.get(x).get(1)};
                }else if(x!=nums[i]) return new int[]{i,map.get(x).get(0)};
            }
        }
        return new int[]{0,0};
    }
}
