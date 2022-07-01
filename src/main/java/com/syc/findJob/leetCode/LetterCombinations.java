package com.syc.findJob.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private final List<String> res = new ArrayList<>();

    private final String[] letters = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(null == digits || digits.equals("")){
            return res;
        }
        findCombinations(digits, 0, "");

        return res;
    }

    //s用来存放[0...index-1]位构成的字母组合
    public void findCombinations(String digits, int index, String s) {
        System.out.println(index + " : " + s );
        if(index == digits.length()) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letter = letters[c-'0'];
        for(int i = 0; i < letter.length(); i++) {
            findCombinations(digits, index+1, s + letter.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }

}
