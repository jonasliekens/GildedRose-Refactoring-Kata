package com.gildedrose.grader.strategy;

import com.gildedrose.Item;

/**
 * Common items decrease in value with 1 point.
 * When the sellIn value is lower or equal to 0, they decrease in value by two points
 */
public class CommonItemGradingStrategy implements ItemGradingStrategy {

    @Override
    public void gradeItem(Item item) {
        item.quality -= Math.min(item.quality, determineDegradingValue(item));
    }

    protected Integer determineDegradingValue(Item item) {
        return BASE_QUALITY_DEGRADING_VALUE * determineDegradingMultiplier(item.sellIn);
    }

    protected Integer determineDegradingMultiplier(Integer sellIn) {
        return sellIn <= 0 ? 2 : 1;
    }
}
