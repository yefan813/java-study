package com.yefan.study.algorithm.array;

public class MaxProfit {
    /**
     * 复杂度O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 时间复杂度O(n)
     * 技巧点：将历史最低的点保存，就是和自己买股票的时候想的 要是我能在这时候买入多好啊。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minProfit){
                minProfit = prices[i];
            }else if(prices[i] - minProfit > maxProfit){
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }
}
