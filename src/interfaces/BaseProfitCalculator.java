package interfaces;

import entity.StockData;

/**
 * @author: HanXian
 * @description: 股票利润计算接口
 * @date: 2024-04-16 17:39
 */
public interface BaseProfitCalculator {
     /**
      * @description 计算利润
      * @param stockData: 股票数据
      * @return int 利润
      * @author HanXian
      * @date 2024-04-16 18:41
      */
     int calculateProfit(StockData stockData);
}
