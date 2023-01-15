package com.gildedrose.grader.strategy;

import com.gildedrose.Item;

public class CommonItemGradingStrategy implements ItemGradingStrategy {

    @Override
    public void gradeItem(Item item) {
        item.quality -= Math.min(item.quality, determineDegradingValue(item));
    }

    private Integer determineDegradingValue(Item item) {
        return BASE_QUALITY_DEGRADING_VALUE * determineDegradingMultiplier(item.sellIn);
    }

    protected Integer determineDegradingMultiplier(Integer sellIn) {
        return sellIn <= 0 ? 2 : 1;
    }
}
