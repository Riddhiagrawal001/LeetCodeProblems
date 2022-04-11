// Whenver there's a problem where you have to find a combination/ sub-sequence , recursion can be an option . 
// When ever there's a problem when we have to find all the possible solutions and choose based upon that we can use the concept of backtracking.

// for a particular index we have a option to pick or not pick . so every index has two options 1.Pick 2.Not-Pick

class Solution {
public void  findUsingBacktracking(int index,int[] candidates,int target,List<List<Integer>> list, List<Integer> ds ){
  // if you have used all the possible things in the array 
        if(index==candidates.length){
          // if your current combination is equal to target
            if(target==0)
              // add to the current combination to the list
                list.add(new ArrayList<>(ds));
            return;
        }
  // if current index is less than target ( situation of picking up)
       if(candidates[index]<=target){
         // add the current element to the current combination
           ds.add(candidates[index]);
         // condition of picking up a number and the performing the next recursion till you get the combination
           findUsingBacktracking(index,candidates,target-candidates[index],list,ds);
         // suppose the current combination doesn't match the target the backtrack and remove the last value
           ds.remove(ds.size()-1);
       }
  // if suppose you dont pick the current element , hence move to the next index.
          findUsingBacktracking(index+1,candidates,target,list,ds); 
    }
  
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      // the resultant list
        List<List<Integer>>  list =new ArrayList();
      // the starting recursion ( start with 0th index , the array, target value, the final ans list , and a list to store the current possible combination )
        findUsingBacktracking(0,candidates,target,list,new ArrayList<>());
        return list;
    }
}
