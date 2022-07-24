package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 */
public class PathSum {
    /**
     * 递归回溯
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> ret = new ArrayList<>();

        if(null == root)
            return ret;

        pathSum(root, target, ret, new LinkedList<>());

        return ret;

    }

    public void pathSum(TreeNode root, int target, List<List<Integer>> ret, LinkedList<Integer> path) {

        if(null == root)
            return ;

        path.add(root.val);

        if(root.left == null && root.right == null && root.val == target){
            ret.add(new ArrayList<>(path)); //如果这里直接添加path，则只是加了一个引用，后续当path改变时，这里都会改变。所以需要拷贝一个对象
            //这里不能直接return，因为当遍历到根节点的时候，需要回溯
        }

        pathSum(root.left, target-root.val, ret, path);

        pathSum(root.right, target-root.val, ret, path);

        path.pollLast();

    }

    ///////////// review
    List<List<Integer>> res;
    public List<List<Integer>> pathSum2(TreeNode root, int target) {
        res = new ArrayList<>();
        if(null == root)
            return res;
        ArrayList<Integer> path = new ArrayList<>();
        pathSum2(root, target, path);
        return res;
    }

    public void pathSum2(TreeNode root, int target, ArrayList<Integer> path) {
        if(null == root)
            return;
        int value = root.val;
        path.add(value);
        if(root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        pathSum2(root.left, target-value, path);
        pathSum2(root.right, target-value, path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.remove(list.size()-1);
        System.out.println(list);
    }
}
