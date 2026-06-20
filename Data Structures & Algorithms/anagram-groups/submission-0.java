class Array{
    int[] arr;
    public Array(int [] arr){
        this.arr=arr;
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(arr);
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Array)) return false;
        Array other=(Array) o;
        return Arrays.equals(this.arr,other.arr);
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Array,List<String>> map=new HashMap<>();
        for(String s:strs){
            int[] ar=new int[26];
            for(char ch:s.toCharArray()){
                int index=ch-'a';
                ar[index]++;
            }
            Array a=new Array(ar);
            if(!map.containsKey(a)) map.put(a,new ArrayList<>());
            map.get(a).add(s);
        }
        // System.out.println(map.toString());
        return map.values().stream().map(i->i).collect(Collectors.toList());
    }
}
