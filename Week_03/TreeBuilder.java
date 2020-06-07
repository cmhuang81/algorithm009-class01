class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap map = new HashMap();
        for (int i = 0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return treeBuilder(preorder, inorder, 0, preorder.length, 0, inorder.length, map);
    }

    private TreeNode treeBuilder(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
        int inEnd, HashMap map) {
            if (preStart == preEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRootIndex = (int)map.get(root.val);
            int leftLength = inRootIndex - inStart;
            root.left = treeBuilder(preorder, inorder, preStart+1, preStart+1+leftLength, inStart, inRootIndex, map);
            root.right = treeBuilder(preorder, inorder, preStart+1+leftLength, preEnd, inRootIndex+1, inEnd, map);
            return root;
        }
}