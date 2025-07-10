package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /*
You are given a list of distinct integers candidates[].
You are also given an integer target.
Find all unique combinations where the chosen numbers sum up to the target.
You can use the same number from candidates[] unlimited times.
The solution should avoid duplicate combinations (regardless of order).
🔍 Example
plaintext
Copy
Edit
Input: candidates = [2, 3, 6, 7], target = 7
Output: [[2, 2, 3], [7]]
     */

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            //dfs(candidates, 0, target, new ArrayList<>(), result);
           pickNotPick( 0, candidates, new ArrayList<>(), target,0,result);
            return result;
        }

    private void pickNotPick(int index, int[] arr, List<Integer> current, int target, int depth,List<List<Integer>> result) {
        // Base case: target achieved
        if (target == 0) {
            System.out.println(indent(depth) + "✅ Found: " + current);
            result.add(new ArrayList<>(current)); // Store valid combination
            return;
        }

        // Base case: out of bounds or negative target
        if (index >= arr.length || target < 0) {
            System.out.println(indent(depth) + "❌ Rejected: " + current + " (target=" + target + ")");
            return;
        }
        // --- Pick ---
        current.add(arr[index]);
        System.out.println(indent(depth) + "Pick: " + arr[index] + " → " + current + " (target=" + target + ")");
        pickNotPick(index, arr, current, target - arr[index], depth + 1,result); // stay on same index
        current.remove(current.size() - 1); // backtrack
        // --- Not Pick ---
        System.out.println(indent(depth) + "Skip: " + arr[index] + " → " + current + " (target=" + target + ")");
        pickNotPick(index + 1, arr, current, target, depth + 1,result); // move to next index
    }

    // Indentation for tree visualization
    private String indent(int depth) {
        return "  ".repeat(depth);
    }

        private void dfs(int[] candidates, int index, int target,
                         List<Integer> path, List<List<Integer>> result) {
            // ✅ Base Case: If target is achieved
            if (target == 0) {
                result.add(new ArrayList<>(path));  // deep copy
                return;
            }

            // ❌ Base Case: Exceeded the sum
            if (target < 0) {
                return;
            }

            // Start from current index (not 0) to avoid using past values
            for (int i = index; i < candidates.length; i++) {
                path.add(candidates[i]); // choose
                dfs(candidates, i, target - candidates[i], path, result); // stay on i (repeat allowed)
                path.remove(path.size() - 1); // backtrack
            }
        }

        public static void main(String[] args) {
            CombinationSum cs = new CombinationSum();
            int[] candidates = {2, 3, 6, 7};
            int target = 7;
            List<List<Integer>> result = cs.combinationSum(candidates, target);
            System.out.println(result);  // Output: [[2, 2, 3], [7]]
        }

}
