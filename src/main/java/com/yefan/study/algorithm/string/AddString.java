package com.yefan.study.algorithm.string;

import org.junit.Test;

public class AddString {
    @Test
    public void test() {
        System.out.println('1' - '1');
    }
    public String addStrings(String num1, String num2) {
        //point to num1
        int i = num1.length() - 1;
        //point to num2
        int j = num2.length() - 1;
        //进位
        int carry = 0;
        //保存最后的运算结果
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0) {
            //当前n1的值
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;

            //当前n2的值
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            //当前两个数字相加结果
            int tmp = n1 + n2 + carry;
            //进位
            carry = tmp / 10;
            //将进位剩下的数放入到 res
            res.append(tmp % 10);

            i--;
            j--;

        }
        if(carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }
}
