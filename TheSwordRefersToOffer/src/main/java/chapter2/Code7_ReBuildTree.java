package chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/8/30 18:44
 */



class TreeNode {
     int val;TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class Code7_ReBuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre, in, 0,pre.length-1, 0,in.length-1);
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in, int preStart, int preEnd, int inStart, int inEnd){
        //退出条件
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);

        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == pre[preStart]){
                root.left = reConstructBinaryTree(pre, in, preStart+1, preStart+i-inStart, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, in, preStart+i-inStart+1, preEnd, i+1, inEnd);
                break;
            }
        }
        return root;
    }
}
