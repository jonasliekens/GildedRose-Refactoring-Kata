package com.gildedrose.grader.strategy;

import com.gildedrose.Item;

/**
 * Aging Cheese items follow the same grading logic as common items,
 * with the exception that they increase with the calculated value instead of decreasing in value.
 */
public class AgingCheeseItemGradingStrategy extends CommonItemGradingStrategy{
    @Override
    public void gradeItem(Item item) {
        item.quality = Math.min(MAX_QUALITY_VALUE, item.quality + determineDegradingValue(item));
    }
}
