package strategy;

import implement.ShortTermMaxProfitCalculator;
import interfaces.BaseProfitCalculator;

/**
 * @description 股票交易枚举类
 * @author HanXian
 * @date 2024-04-16 21:05
 */
public enum StockTradeStrategyEnum {
    SHORT_TERM("超短期", new ShortTermMaxProfitCalculator());

    // 股票交易策略描述
    private String description;
    // 股票交易策略实现类
    private BaseProfitCalculator baseProfitCalculator;

    StockTradeStrategyEnum(String description, BaseProfitCalculator baseProfitCalculator) {
        this.description = description;
        this.baseProfitCalculator = baseProfitCalculator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BaseProfitCalculator getBaseProfitCalculator() {
        return baseProfitCalculator;
    }

    public void setBaseProfitCalculator(BaseProfitCalculator baseProfitCalculator) {
        this.baseProfitCalculator = baseProfitCalculator;
    }
}
