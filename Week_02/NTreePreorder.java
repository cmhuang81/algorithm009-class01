class Solution {
    List result = new LinkedList();
    public List<Integer> preorder(Node root) {
        porder(root);
        return result;       
    }

    public void porder(Node node) {
        if (null == node) {
            return;
        }
        result.add(node.val);
        for (Node children : node.children) {
            porder(children);
        }
    }
}