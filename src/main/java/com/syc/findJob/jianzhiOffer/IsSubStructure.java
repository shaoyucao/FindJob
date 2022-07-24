package com.syc.findJob.jianzhiOffer;

/**
 * 树的子结构
 */
public class IsSubStructure {
    /**
     * 递归方法
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean ret = false;
        if(null != A && null != B) {
            if(A.val == B.val) {
                ret = doesHasSubTree(A, B);
            }
            //上述节点不符合子结构性质，继续往下遍历，寻找与B节点相同的子结构
            if(!ret) {
                ret = isSubStructure(A.left, B);
            }
            if(!ret) {
                ret = isSubStructure(A.right, B);
            }
        }
        return ret;
    }

    public boolean doesHasSubTree(TreeNode a, TreeNode b) {
        //递归结束的标志是达到叶子节点
        if(null == b)
            return true;
        if(null == a)
            return false;
        if(a.val != b.val)
            return false;
        //递归地层序进行遍历
        return doesHasSubTree(a.left, b.left) && doesHasSubTree(a.right, b.right);
    }
}
