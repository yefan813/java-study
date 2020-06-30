package com.yefan.study.algorithm.string;

import org.junit.Test;

/**
 * 字符串删除某个位置后，判断是不是回文
 */
public class IsPalindromeString {
    @Test
    public  void test() {
        System.out.println(validPalindrome("afbcbfacc"));
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) {
                return isPalindrome(s,i + 1, j) || isPalindrome(s,i,j - 1);
            }
        }
        return true;
    }


    /**
     * 判断字符串s从 i - 》j 是否是回文
     * @param s
     * @param i
     * @param j
     * @return
     */
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
