package com.syc.findJob.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *字符串加减乘除计算
 */
public class Calculate {

    public static void main(String[] args) {
        String str = "(1+(5*6)-(4/2))";
        calculate(str);
    }

    private static void calculate(String str) {
        System.out.println(str);

        List<Object> stackAll = new ArrayList<Object>();

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        List<Integer> list1 = new ArrayList<Integer>();
        List<String> list2 = new ArrayList<String>();

        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            String str2 = charArr[i] + "";
            if (figure(str2)) {
                Object[] objArr = m(charArr, i);
                stack1.add(objArr[0]);
                list1.add(Integer.parseInt(objArr[0].toString()));
                i = (Integer) objArr[1];
                stackAll.add(objArr[0]);
            } else {
                stack2.add(str2);
                list2.add(str2.toString());
                stackAll.add(str2);
            }
        }

        Stack stack3 = new Stack();

        for (int i = 0; i < stackAll.size(); i++) {
            String s = (String) stackAll.get(i);
            if (s.equals(")")) {
                Stack temp_stack = new Stack();
                while (!stack3.empty()) {
                    Object obj = stack3.pop();
                    if (obj.equals("(")) {
                        double count = 0;
                        while (!temp_stack.empty()) {
                            if (temp_stack.size() == 3) {
                                Object one = temp_stack.pop();
                                Object two = temp_stack.pop();
                                Object three = temp_stack.pop();
                                if (two.equals("+")) {
                                    count = Double.parseDouble(one.toString()) + Double.parseDouble(three.toString());
                                    break;
                                } else if (two.equals("-")) {
                                    count = Double.parseDouble(one.toString()) - Double.parseDouble(three.toString());
                                    break;
                                } else if (two.equals("*")) {
                                    count = Double.parseDouble(one.toString()) * Double.parseDouble(three.toString());
                                    break;
                                } else if (two.equals("/")) {
                                    count = Double.parseDouble(one.toString()) / Double.parseDouble(three.toString());
                                    break;
                                }
                            } else if (temp_stack.size() > 3) {
                                Object one = temp_stack.pop();
                                Object two = temp_stack.pop();
                                Object three = temp_stack.pop();
                                if (two.equals("*")) {
                                    Double four = Double.parseDouble(one.toString()) * Double.parseDouble(three.toString());
                                    temp_stack.push(four);
                                    continue;
                                } else if (two.equals("/")) {
                                    Double four = Double.parseDouble(one.toString()) / Double.parseDouble(three.toString());
                                    temp_stack.push(four);
                                    continue;
                                }
                                Object four = temp_stack.pop();
                                if (four.equals("+") || four.equals("-")) {
                                    if (two.equals("+")) {
                                        Double four2 = Double.parseDouble(one.toString()) + Double.parseDouble(three.toString());
                                        temp_stack.push(four);
                                        temp_stack.push(four2);
                                        continue;
                                    } else if (two.equals("-")) {
                                        Double four2 = Double.parseDouble(one.toString()) - Double.parseDouble(three.toString());
                                        temp_stack.push(four);
                                        temp_stack.push(four2);
                                        continue;
                                    }
                                }
                                if (four.equals("*")) {
                                    Double five = Double.parseDouble(temp_stack.pop().toString());
                                    Double six = Double.parseDouble(three.toString()) * five;
                                    temp_stack.push(six);
                                    temp_stack.push(two);
                                    temp_stack.push(one);
                                    continue;

                                } else if (four.equals("/")) {
                                    Double five = Double.parseDouble(temp_stack.pop().toString());
                                    Double six = Double.parseDouble(three.toString()) / five;
                                    temp_stack.push(six);
                                    temp_stack.push(two);
                                    temp_stack.push(one);
                                    continue;
                                }
                            }
                        }
                        stack3.push(count);
                        break;
                    }
                    temp_stack.add(obj);
                }
                continue;
            }
            stack3.add(s);
        }
        System.out.println(stack3);
    }

    public static Object[] m(char[] charArr, int startIndex) {
        Object[] objArr = new Object[2];
        boolean b = false;
        int outindex = 0;
        String returnStr = "";
        for (int i = startIndex; i < charArr.length; i++) {
            String str = charArr[i] + "";
            b = figure(str);
            if (b) {
                returnStr += str;
            } else {
                outindex = i;
                break;
            }
        }
        objArr[0] = returnStr;
        objArr[1] = outindex - 1;
        return objArr;
    }

    public static boolean figure(String str) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher m = pattern.matcher(str);
        boolean b = m.matches();
        return b;
    }

    public static boolean Str(String str) {
        String pattern = "(+-*/)";
        return pattern.contains(str);
    }
}

