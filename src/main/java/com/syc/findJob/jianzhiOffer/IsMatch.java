package com.syc.findJob.jianzhiOffer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class IsMatch {
    public boolean isMatch(String s, String p) {

        if(p.isEmpty())
            return s.isEmpty();

        //查看首元素是否一致
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //如果p的下一个字符是“*”
        if(p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }else{
            //一般情况，匹配后继续比较
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }
}
