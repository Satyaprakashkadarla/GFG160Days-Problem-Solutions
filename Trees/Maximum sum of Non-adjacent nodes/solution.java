class Solution {
    public int getMaxSum(Node root) {
        Map<Node, Integer> mp = new HashMap();
        return getMax(root, mp);
    }
    static int getMax(Node root, Map<Node, Integer> mp){
        if(root == null) {
            return 0;
        }
        if(mp.containsKey(root)){
            return mp.get(root);
        }
        int sum = root.data;
        if(root.left!=null){
            sum+=getMax(root.left.left, mp)+getMax(root.left.right, mp);
        }
        if(root.right!=null){
            sum+=getMax(root.right.left, mp)+getMax(root.right.right, mp);
        }
        mp.put(root, Math.max(sum, getMax(root.left, mp) + getMax(root.right, mp)));
        return mp.get(root);
    }
}