import javax.swing.tree.TreeNode;
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 求二叉树的右视图
     *
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder  int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length < 1 || inOrder == null || inOrder.length < 1) {
            return new int[0];
        }
        TreeNode root = rebuild(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.peekLast().val);
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode rebuild(int[] preOrders, int preS, int preE, int[] inOrders, int inS, int inE) {
        if (preS < 0 || inS < 0 || preS > preE || inS > inE){
            return null;
        }
        TreeNode root = new TreeNode(preOrders[preS]);
        int index = 0;
        for (int i = 0; i < inOrders.length; i++){
            if (inOrders[i] == preOrders[preS]){
                index = i;
                break;
            }
        }
        int leftLen = index - inS;
        root.left = rebuild(preOrders, preS + 1, leftLen + preS, inOrders, inS, index - 1);
        root.right = rebuild(preOrders, leftLen + preS + 1, preE, inOrders, index + 1, inE);
        return root;

    }
}