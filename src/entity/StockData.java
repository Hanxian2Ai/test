package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HanXian
 * @description: 股票数据
 * @date: 2024-04-16 17:39
 */
public class StockData {
    /**
     * 股票价格数组
     */
    private final int[][] prices;

    private StockData(int[][] prices) {
        this.prices = prices;
    }

    public int[][] getPrices() {
        return prices;
    }

    /**
     * @description 读取股票数据
     * @param scanner: scanner
     * @return StockData 股票数据
     * @author HanXian
     * @date 2024-04-16 18:57
     */
    public static StockData readFromInput(Scanner scanner) {
        List<int[]> priceList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()){
                break;
            }
            String[] priceStrs = inputLine.split(",");
            int[] stockPrices = new int[priceStrs.length];
            for (int i = 0; i < priceStrs.length; i++) {
                stockPrices[i] = Integer.parseInt(priceStrs[i].trim());
            }
            priceList.add(stockPrices);
        }
        int[][] prices = new int[priceList.size()][];
        return new StockData(priceList.toArray(prices));
    }

}
