class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <=0 || k <=0 || n<k) {
            return res;
        }
        findComb(n, k, 1, new Stack<Integer>());
        return res;
    }

    private void findComb(int n, int k, int start, Stack<Integer> stack) {
        if (stack.size() == k) {
            res.add(new ArrayList(stack));
            return;
        }

        for (int i = start; i <= n - (k - stack.size()) + 1; i++) {
            stack.add(i);
            findComb(n, k, i+1, stack);
            stack.pop();
        }
        
    }
}