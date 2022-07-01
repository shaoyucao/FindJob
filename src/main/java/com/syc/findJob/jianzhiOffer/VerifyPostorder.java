package com.syc.findJob.jianzhiOffer;

import java.util.Arrays;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {

        if(postorder == null || postorder.length <= 1)
            return true;

        int len = postorder.length;

        return verifyPostorder(postorder, 0, len-1);

    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {

        if(end - start == 0)
            return true;

        int rootVal = postorder[end];

        int index = start;
        for( ; index < end; index++) {
            if(postorder[index] > rootVal)
                break;
        }

        //右边的值都大于根节点值
        for(int j = index; j < end; j++) {
            if(postorder[j] < rootVal)
                return false;
        }

        //校验左子树
        boolean left = true;
        if(index > start)
            left = verifyPostorder(postorder, start, index-1);

        //校验右子树
        boolean right = true;
        if(index < end)
            right = verifyPostorder(postorder, index, end-1);

        return left && right;

    }
}
