package com.gildedrose.grader;

import com.gildedrose.Item;

public class AgingCheeseItemGradingStrategy implements ItemGradingStrategy{
    @Override
    public void gradeItem(Item item) {
        item.quality = Math.min(MAX_QUALITY_VALUE, item.quality + BASE_QUALITY_DEGRADING_VALUE);
    }
}
