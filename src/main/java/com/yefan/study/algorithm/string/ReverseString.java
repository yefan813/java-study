package com.yefan.study.algorithm.string;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            right--;
            left++;
        }
    }

}
