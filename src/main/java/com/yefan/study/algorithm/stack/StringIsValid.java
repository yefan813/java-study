package com.yefan.study.algorithm.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author yefan
 */
public class StringIsValid {

    private HashMap<Character, Character> mappings;

    public StringIsValid () {
        mappings  = new HashMap<>();
        //这样放是后去匹配的时候直接从 key 能获取到
        mappings.put('}','{');
        mappings.put(')','(');
        mappings.put(']','[');

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(mappings.containsKey(c)){
                //stack.isEmpty() stack 为空后异常
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                //判断档期c 对应的 val 是否是已知的
                if(topElement != this.mappings.get(c)) {
                    return false;
                }
            }else {
                //如果mappings不存在则 可能是左边的或者未知的
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
