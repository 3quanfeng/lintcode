import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> items = new ArrayList<Integer>();
        if (nums == null){
            return rst;
        }
        Collections.sort(nums);
        subsetsWithDupHelper(rst, items, nums, 0);
        return rst;
    }
    public void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> items, ArrayList<Integer> nums, int pos){
        rst.add((ArrayList<Integer>) items.clone());
        for (int i = pos; i < nums.size(); i++){
            if (i > 0 && i > pos && nums.get(i) == nums.get(i - 1)){
                continue;
            }
            items.add(nums.get(i));
            subsetsWithDupHelper(rst, items, nums, i + 1);
            items.remove(items.size() - 1);
        }
    }
}

