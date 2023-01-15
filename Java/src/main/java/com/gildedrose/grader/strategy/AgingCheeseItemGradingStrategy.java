package com.gildedrose.grader.strategy;

import com.gildedrose.Item;

public class AgingCheeseItemGradingStrategy extends CommonItemGradingStrategy{
    @Override
    public void gradeItem(Item item) {
        item.quality = Math.min(MAX_QUALITY_VALUE, item.quality + determineDegradingValue(item));
    }
}
