class Solution {
    private void findUsingBacktracking(int index,int[] candidates,int target,List<List<Integer>> list , List<Integer> ds ){

            if(target==0){
                list.add(new ArrayList<>(ds)); 
            return ;
            }
        
       for(int i=index;i<candidates.length;i++){
           if(candidates[i]>target) break;
           if(i>index && candidates[i]==candidates[i-1]) continue;
           ds.add(candidates[i]);
           findUsingBacktracking(i+1,candidates,target-candidates[i],list,ds);
           ds.remove(ds.size()-1);
       }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list =new ArrayList();
        Arrays.sort(candidates);
        findUsingBacktracking(0,candidates,target,list,new ArrayList<>());
        return list;
    }
}
