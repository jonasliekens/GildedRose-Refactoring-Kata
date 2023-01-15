package com.gildedrose.grader;

import com.gildedrose.Item;

public class BackstagePassItemGradingStrategy implements ItemGradingStrategy{

    @Override
    public void gradeItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            item.quality = Math.min(MAX_QUALITY_VALUE, item.quality + determineGradingValue(item));
        }
    }

    private Integer determineGradingValue(Item item) {
        return BASE_QUALITY_DEGRADING_VALUE * determineDegradingMultiplier(item.sellIn);
    }

    private Integer determineDegradingMultiplier(Integer sellIn) {
        if (sellIn <= 5) {
            return 3;
        }

        if (sellIn <= 10) {
            return 2;
        }

        return 1;
    }
}
