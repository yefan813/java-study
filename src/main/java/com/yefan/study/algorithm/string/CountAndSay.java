package com.yefan.study.algorithm.string;

import org.junit.Test;

public class CountAndSay {

    @Test
    public void test() {
        for(int i =1;i < 6 ;i++){
            System.out.println(countAndSay(i));
        }
    }

    public String countAndSay(int n) {
        if(n == 1 ) return "1";
        return say(countAndSay(n -1));
    }
    //具体怎么读出来字符串
    private String say(String s){
        //记录数值出现的次数
        int count=1;
        //当前的数值
        char num = s.charAt(0);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            //相等只计算数量
            if(c == num){
                count++;
            }else{
                //不相等打印之前的数量和具体数字
                sb.append(count);
                sb.append(num);
                //重置当前数量和当前的数字用于下一次计算
                num = c;
                count = 1;
            }
        }
        //后面可能只计算数量或者打印了之前的值但是当前值未打印，循环就结束则需要将这部分继续打印
        sb.append(count);
        sb.append(num);
        return sb.toString();
    }
}
