package implement;

import entity.StockData;
import interfaces.BaseProfitCalculator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: HanXian
 * @description: 超短线策略 股票收益计算
 * @date: 2024-04-16 17:39
 */
public class ShortTermMaxProfitCalculator implements BaseProfitCalculator {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = dateFormat.format(date);
        System.out.println(format);
    }
    @Override
    public int calculateProfit(StockData stockData) {

        int[][] prices = stockData.getPrices();
        int stocksNum = prices.length;
        int daysNum = prices[0].length;
        int[][] profits = new int[stocksNum][daysNum - 1];

        // 计算每支股票每天的买卖收益
        for (int i = 0; i < stocksNum; i++) {
            for (int j = 0; j < daysNum - 1; j++) {
                profits[i][j] = prices[i][j + 1] - prices[i][j];
            }
        }

        int totalMaxProfit = 0;
        // 遍历所有收益数组，每个位置只选收益最大的
        for (int day = 0; day < daysNum - 1; day++) {
            int maxDayProfit = findMax(profits, day);
            if (maxDayProfit > 0) {
                totalMaxProfit += maxDayProfit;
            }
        }
        return totalMaxProfit;
    }

    private int findMax(int[][] profits, int day) {
        int maxProfit = Integer.MIN_VALUE;
        for (int[] profit : profits) {
            if (profit[day] > maxProfit) {
                maxProfit = profit[day];
            }
        }
        return maxProfit;
    }

}
