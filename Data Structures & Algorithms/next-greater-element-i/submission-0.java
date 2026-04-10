class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int res[] =new int[nums1.length];
        Arrays.fill(res,-1);
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }

        Stack<Integer> st = new Stack<>();

        for(int x:nums2){
            while(!st.isEmpty() && x>st.peek()){
                int val = st.pop();
                int index = map.get(val);
                res[index]=x;
            }

            if(map.containsKey(x)){
                st.push(x);
            }
        }

        return res;

    }
}