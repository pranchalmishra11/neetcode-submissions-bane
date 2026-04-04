class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        Stack<Pair> stp = new Stack<Pair>();
        for(int i=0;i<n;i++){
            int curr = temperatures[i];
            while(!stp.isEmpty() && curr>(stp.peek().temp)){
                Pair p = stp.pop();
                result[p.index] = i-p.index;
            }

            stp.push(new Pair(curr,i));
        }

        return result;

    }

}
class Pair{
    int temp;
    int index;

    public Pair(int temp, int index){
        this.temp=temp;
        this.index=index;
    }
}
