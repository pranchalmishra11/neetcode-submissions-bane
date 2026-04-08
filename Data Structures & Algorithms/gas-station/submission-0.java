class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0;
        int totalcost=0;

        for(int g:gas){
            totalgas+=g;
        }

        for(int c:cost){
            totalcost+=c;
        }

        if(totalgas<totalcost){// we evaluate the total gas and total cost if gas available less than cost , no chance of completing this clockwise journey
            return -1;
        }

        int n=gas.length;
        int st_index=0;// initialize starting index ans from 0
        int total=0;
        for(int i=0;i<n;i++){
            total+=(gas[i]-cost[i]);// keep adding the difference between gas availability at each station and gas cost , if total is -ve, cant start from there, move to next index, rest total to 0
            if(total<0){
                total=0;
                st_index=i+1;
            }
        }

        return st_index;// move till get such index from where we always have ags in surplus and diff never turn -ve hence a clockwise journey can happen
        
    }
}
