import entity.StockData;
import interfaces.BaseProfitCalculator;
import strategy.StockTradeStrategyEnum;

import java.util.Scanner;

/**
 * @description StockTrading 股票交易入口类
 * @author HanXian
 * @date 2024-04-16 20:55
 */
public class StockTrading {
    public static void main(String[] args) {
        // 读取股票数据
        Scanner scanner = new Scanner(System.in);
        StockData stockData = StockData.readFromInput(scanner);
        scanner.close();

        //通过枚举拿到想要的股票交易处理策略
        BaseProfitCalculator calculator = StockTradeStrategyEnum.SHORT_TERM.getBaseProfitCalculator();
        // 输出最大收益
        System.out.println(calculator.calculateProfit(stockData));
    }
}



