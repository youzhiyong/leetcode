package com.yzy.leetcode;

import com.yzy.common.ListNode;

import java.util.*;

/**
 * Description:
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true

 * Date: 2019-02-27
 *
 * @author youzhiyong
 */
public class LeetCode20 {

    public static void main(String[] args) {
        String input = "((()[]{}))";
        boolean head = solution(input);
        System.out.println(head);
    }

    /**
     40 0x28 ( 开括号
     41 0x29 ) 闭括号
     .
     .
     .
     91 0x5B [ 开方括号
     .
     93 0x5D ] 闭方括号
     .
     .
     .
     123 0x7B { 开花括号
     ...
     125 0x7D } 闭花括号

     基于ASCII码可知，一对有效括号之间的差值的绝对值小于等于2
     */

    //执行时间 6s
    public static boolean solution(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']'){
                if (stack.empty()) return false;
                char item = stack.pop();

                //基于ASCII码可知，一对有效括号之间的差值的绝对值小于等于2
                if (Math.abs(item - c) > 2) return false;
            }
        }
        return stack.empty();
    }

    // 执行时间 10s
    public static boolean solution0(String input) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty()) return false;
                if (map.get(ch) != stack.pop()) return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
