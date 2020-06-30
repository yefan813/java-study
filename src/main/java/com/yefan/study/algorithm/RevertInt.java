package com.yefan.study.algorithm;

public class RevertInt {
    public static void main(String[] args) {
        System.out.println(reverse(14527));
    }

    // rev * 10 + pop 可能超过了 Integer.MAX_VALUE
    public static int reverse(int x) {
        int rev = 0;
        while(x != 0){
            //取个位
            int pop = x % 10;
            //取除去个位
            x = x / 10;
            //正数越界
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            //负数越界
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
