class Solution {
    Map<String,List<String>> adjlist;
    List<String> output;
    int targetLen;
    public List<String> findItinerary(List<List<String>> tickets) {
        adjlist = new HashMap<>();// for adjacency list
        output = new ArrayList<>();// for output keeping
        targetLen = tickets.size()+1;// keeping targetLen saved
        for(List<String> ticketList:tickets){
            String currTicket = ticketList.get(0);
            if(!adjlist.containsKey(currTicket) || adjlist.get(currTicket)==null){
                adjlist.put(currTicket,new ArrayList<>());
            }
        }

        tickets.sort((a,b)->a.get(1).compareTo(b.get(1)));// lexicographical sorting of ticket list, as DFS will move so we keep it already sorted

        for(List<String> ticket:tickets){// fill adjacency list
            adjlist.get(ticket.get(0)).add(ticket.get(1));
        }

        output.add("JFK");// add source to output

        if(dfs("JFK")){// start dfs from source if returns true output is filled with all nodes searched
            return output;
        }

        return new ArrayList<>();// if not return empty list
        
    }


    private boolean dfs(String ticketSrc){
        if(output.size()==targetLen){// top condition check if output is filled with all nodes traversed with passing over each edge/ticket exactly once, +1 here means source 'JFK' itself is counted
            return true;
        }

        if(!adjlist.containsKey(ticketSrc) || adjlist.get(ticketSrc).isEmpty()){// if in graph src has empty list, need to return false and backtrack
            return false;
        }

        List<String> temp = adjlist.get(ticketSrc);
        for(int i=0;i<temp.size();i++){// dfs movement
            String v = temp.get(i);
            adjlist.get(ticketSrc).remove(i);// remove from adjacency list as its covered
            output.add(v);// add to output
            if(dfs(v)){// if finally dfs is success, output is matched to targetLen then return true
                return true;
            }

            adjlist.get(ticketSrc).add(i,v);// backtracking code if we hit the area in graph where no further edges outgoing in adjacency list
            output.remove(output.size()-1);// remove from output too as part of backtrack
        }

        return false;

    }
}
