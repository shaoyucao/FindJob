package com.syc.findJob.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
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
}
