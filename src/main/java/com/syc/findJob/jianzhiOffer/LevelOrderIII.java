package com.syc.findJob.jianzhiOffer;

import java.util.*;

public class LevelOrderIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(null == root)
            return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                if((level & 1) != 0){
                    TreeNode temp = queue.removeLast();
                    list.add(temp.val);
                    if(temp.right != null)
                        queue.addFirst(temp.right);
                    if(temp.left != null)
                        queue.addFirst(temp.left);
                }
                else {
                    TreeNode temp = queue.poll();
                    list.add(temp.val);
                    if (temp.left != null)
                        queue.offer(temp.left);
                    if (temp.right != null)
                        queue.offer(temp.right);
                }
            }
            level++;
            ret.add(list);
        }
        return ret;
    }

    //稍微变形
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(null == root)
            return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(isOrderLeft){
                    list.offerLast(temp.val);
                }else
                    list.offerFirst(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            isOrderLeft = !isOrderLeft;
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }
}
