package reading.offer.tree;

/**
 * @author jhmarryme.cn
 * @date 2019/9/8 23:01
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null){
            return false;
        }
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val == root2.val){
            return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
        } else{
            return false;
        }
    }
}
