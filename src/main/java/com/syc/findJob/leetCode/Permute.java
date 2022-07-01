package com.syc.findJob.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0)
            return res;

        boolean[] visited = new boolean[nums.length];

        generatePermutation(nums, 0, new ArrayList<>(), visited);

        return res;
    }

    //p中保存有index个元素的排列，向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
    public void generatePermutation(int[] nums, int index, List<Integer> p, boolean[] visited) {

        System.out.println("start iterator index = " + index);

        if(index == nums.length){
            res.add(new ArrayList<>(p));
            System.out.println("res : " + res + "return");
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            System.out.println("visited[" + i + "] = " + visited[i] );
            if(!visited[i]) {
                p.add(nums[i]);
                System.out.println("p is: " + p);
                visited[i] = true;
                generatePermutation(nums, index+1, p, visited);
                System.out.println("current p is :" + p + " , current i is : " + i + " , current index is : " + index);
                visited[i] = false;
                p.remove(p.size()-1);

            }
        }

        System.out.println("end iterator index = " + index);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permute().permute(nums));
    }
}
