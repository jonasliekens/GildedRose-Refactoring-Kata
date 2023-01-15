package com.gildedrose.grader;

import com.gildedrose.Item;

public class ConjuredItemGradingStrategy implements ItemGradingStrategy{
    @Override
    public void gradeItem(Item item) {
        item.quality -= Math.min(item.quality, determineDegradingValue(item));
    }

    private Integer determineDegradingValue(Item item) {
        return BASE_QUALITY_DEGRADING_VALUE * determineDegradingMultiplier(item.sellIn);
    }

    private Integer determineDegradingMultiplier(Integer sellIn) {
        return sellIn < 0 ? 4 : 2;
    }
}
