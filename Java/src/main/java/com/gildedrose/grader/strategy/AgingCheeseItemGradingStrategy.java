package com.gildedrose.grader.strategy;

import com.gildedrose.Item;

public class AgingCheeseItemGradingStrategy implements ItemGradingStrategy{
    @Override
    public void gradeItem(Item item) {
        item.quality = Math.min(MAX_QUALITY_VALUE, item.quality + determineDegradingValue(item));
    }

    private Integer determineDegradingValue(Item item) {
        return BASE_QUALITY_DEGRADING_VALUE * determineDegradingMultiplier(item.sellIn);
    }

    private Integer determineDegradingMultiplier(Integer sellIn) {
        return sellIn <= 0 ? 2 : 1;
    }
}
