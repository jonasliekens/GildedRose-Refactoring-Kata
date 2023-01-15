package com.gildedrose.grader;

import com.gildedrose.Item;

@FunctionalInterface
public interface ItemGradingStrategy {
    Integer BASE_QUALITY_DEGRADING_VALUE = 1;
    Integer MAX_QUALITY_VALUE = 50;
    /**
     * Calculates the remaining quality value for an item at the end of the day
     * @param item The item in the shop
     */
    void gradeItem(Item item);
}
